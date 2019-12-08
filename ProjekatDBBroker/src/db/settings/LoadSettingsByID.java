/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.settings;

/**
 *
 * @author Marenda
 */
public class LoadSettingsByID<IDType> {

    public String className = null;
    public IDType id = null;
    public String idColumnName = null;
    public String tableName = null;
    public String[] columnNames = null;
    public String[] joins = null;
    public String[] orderBy = null;
    public int startLimit = 0;
    public int endLimit = 100;

    public LoadSettingsByID() {
    }

    public LoadSettingsByID(String className, String tblName, String idColName, IDType idValue, String[] colNames) {
        this.className = className;
        tableName = tblName;
        idColumnName = idColName;
        columnNames = colNames;
        id = idValue;
    }

}
