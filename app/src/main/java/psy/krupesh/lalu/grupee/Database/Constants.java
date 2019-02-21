package psy.krupesh.lalu.grupee.Database;

public class Constants {
    //COLUMNS
    static final String ROW_ID="id";
    static final String TIME="time";
    static final String URL="url";

    //DB PROPERTIES
    static final String DB_NAME="cc_DB";
    static final String TB_NAME="cc_TB";
    static final int DB_VERSION=1;

    //CREATE TABLE STMT
    static final String CREATE_TB="CREATE TABLE cc_TB(id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "time TEXT NOT NULL,url TEXT NOT NULL);";

    //UPGRADE TB
    static final String DROP_TB="DROP TABLE IF EXISTS "+TB_NAME;

}