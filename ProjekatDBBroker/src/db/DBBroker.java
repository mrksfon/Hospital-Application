/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import db.settings.DBConfig;
import db.settings.LoadAllSettings;
import db.settings.LoadSettingsByID;
import interfejsi.IEntityCreate;
import interfejsi.IEntityDelete;
import interfejsi.IEntityRead;
import interfejsi.IEntityUpdate;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Marenda
 */
public class DBBroker {

    private Connection conn;
    private static final DBBroker instance = new DBBroker();

    

    private DBBroker() {

    }

    public static DBBroker getInstance() {
        return instance;
    }

    public synchronized void connect() throws Exception {
        if (isConnected()) {
            return;
        }
        DBConfig db = new DBConfig();
        conn = DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPassword());
        conn.setAutoCommit(false);
    }

    public synchronized boolean isConnected() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            return true;
        }
        return false;
    }

    public synchronized void closeConnection() throws SQLException {
        if (isConnected()) {
            conn.close();
        }
    }

    public synchronized void startTransaction() throws SQLException {
        if (conn != null) {
            conn.setAutoCommit(false);
        }
    }

    public synchronized void commit() throws SQLException {
        if (conn != null) {
            conn.commit();
        }
    }

    public synchronized void rollback() throws SQLException {
        if (conn != null) {
            conn.rollback();
        }
    }

    public synchronized void disconnect() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }

    public synchronized <T extends IEntityCreate> T save(T entity) throws Exception {
        StringBuilder sb = new StringBuilder(50);
        sb.append("INSERT INTO ").append(entity.getTableName());

        sb.append(" (");

        String[] columnNames = entity.getColumnNamesForInsert();
        String delimiter = "";
        for (String colName : columnNames) {
            sb.append(delimiter).append(colName);
            delimiter = ",";
        }

        sb.append(") VALUES(");

        String[] columnValues = entity.getColumnValuesForInsert();
        delimiter = "";

        for (String colValue : columnValues) {
            sb.append(delimiter).append(colValue);
            delimiter = ",";
        }

        sb.append(")");

        String sql = sb.toString();

        System.out.println("Insert Query : " + sql);

        Statement stmt = conn.createStatement();

        int affectedRows = stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

        if (affectedRows == 1) {
            ResultSet generatedKeys = stmt.getGeneratedKeys();

            if (generatedKeys.next() && entity.isIdAutoIncrement()) {
                Integer generatedKey = generatedKeys.getInt(1);

                String[] columnNamesForSelect = ((IEntityRead) entity).getColumnNamesForSelect();

                LoadSettingsByID<Integer> settings = new LoadSettingsByID<>(entity.getClass().getCanonicalName(), entity.getTableName(), entity.getIdColumnName(), generatedKey, columnNamesForSelect);
                settings.joins = ((IEntityRead) entity).getJoins();
                settings.endLimit = 1;

                return (T) loadByID(settings);
            } else {
                return entity;
            }
        }
        throw new Exception("Error occured in save()");
    }

    public synchronized boolean delete(IEntityDelete entity) throws SQLException {
        String sql = " DELETE FROM " + entity.getTableName() + " WHERE " + entity.getIdColumnName() + " = " + entity.getIdValue() + " LIMIT 1";

        System.out.println("DELETE QUERY : " + sql);

        Statement stmt = conn.createStatement();
        int affectedRows = stmt.executeUpdate(sql);
        if (affectedRows == 1) {
            return true;
        }
        return false;
    }

    public synchronized boolean update(IEntityUpdate entity) throws Exception {
        final String[] updateColumnNames = entity.getUpdateColumnNames();
        final String[] updateColumnValues = entity.getUpdateColumnValues();

        if (updateColumnNames.length != updateColumnValues.length) {
            throw new Exception("Column count didnt match.");
        }

        StringBuilder sb = new StringBuilder(20);
        sb.append("UPDATE " + entity.getTableName() + " SET ");
        for (int i = 0; i < updateColumnNames.length; i++) {
            sb.append((i > 0) ? ", " : "").append(updateColumnNames[i]).append("=").append(updateColumnValues[i]);
        }

        sb.append(" WHERE ").append(entity.getIdColumnName()).append(" = ").append(entity.getIdValue()).append(" LIMIT 1");

        String sql = sb.toString();

        System.out.println("Update query: " + sql);

        Statement stmt = conn.createStatement();
        int affectedRows = stmt.executeUpdate(sql);
        if (affectedRows == 1) {
            return true;
        }
        return false;
    }

    public synchronized <T extends IEntityRead> List<T> loadAll(LoadAllSettings settings) throws Exception {
        if (settings.columnNames == null || settings.tableName == null) {
            throw new Exception("Table name and column names must not be null");
        }

        String colNames = Arrays.toString(settings.columnNames).replace("[", "").replace("]", "");

        String sql = "SELECT " + colNames + " FROM " + settings.tableName;

        if (settings.joins != null) {
            String[] joins = settings.joins;
            for (String join : joins) {
                sql += " " + join + " ";
            }

        }

        String[] orderBy = settings.orderBy;
        if (orderBy != null) {
            String comma = " ";
            for (String order : orderBy) {
                sql += comma + order;
                comma = ",";
            }
        }

        sql += " LIMIT " + settings.startLimit + ", " + settings.endLimit;

        System.out.println("Load all query: " + sql);

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        List<T> listOfEntities = new ArrayList<>();

        while (rs.next()) {
            Object[] values = new Object[settings.columnNames.length];
            int valuesIndex = 0;

            for (int i = 0; i < settings.columnNames.length; i++) {
                values[valuesIndex++] = rs.getObject(i + 1);
            }

            T entity = (T) Class.forName(settings.className).newInstance();
            try {
                entity.fillAttributes(values);
                listOfEntities.add(entity);
            } catch (Exception e) {
                e.printStackTrace();
                throw e;
            }
        }
        return listOfEntities;
    }
    
    public synchronized <T extends IEntityRead> T loadByID(LoadSettingsByID settings) throws Exception{
        if(settings.columnNames == null || settings.tableName == null){
            throw new Exception("Table name and column name cannot be null");
        }
        
        String colNames = Arrays.toString(settings.columnNames).replace("[", "").replace("]", "");
        
        String sql = "SELECT "  + colNames + " FROM " +settings.tableName + " ";
        
        if(settings.joins != null){
            String[] joins = settings.joins;
            for(String join : joins){
                sql += join + " ";
            }
        }
        
        sql += "WHERE " + settings.idColumnName + " = " + settings.id;
        
        String[] orderBy = settings.orderBy;
        
        if(orderBy != null){
            String comma = "";
            for(String order : orderBy){
                sql += comma + order;
                comma = ",";
            }
        }
        
        sql += " LIMIT " + settings.startLimit + ", "+settings.endLimit;
        
        System.out.println("Load by ID query : "+sql);
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        if(rs.next()){
            Object[] values = new Object[settings.columnNames.length];
            int valuesIndex = 0;
            
            for(int i = 0 ; i < settings.columnNames.length;i++){
                values[valuesIndex++] = rs.getObject(i + 1);
            }
            
            T entity = (T) Class.forName(settings.className).newInstance();
            
            try{
                entity.fillAttributes(values);
                return entity;
            }catch(Exception ex){
                ex.printStackTrace();
                throw ex;
            }
        }
        return null;
    }

}
