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
public class LoadAllSettings {

    public String className = null;
    public String tableName = null;
    public String[] columnNames = null;
    public String[] joins = null;
    public String[] orderBy = null;
    public int startLimit = 0;
    public int endLimit = 100;

    public LoadAllSettings() {
    }

    public LoadAllSettings(String cName, String tblName, String[] colNames) {
        className = cName;
        tableName = tblName;
        columnNames = colNames;
    }

}
