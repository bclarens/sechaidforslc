package utilities;

import java.sql.Connection;
import java.sql.DriverManager;

public class sqlcon {
    static final String DB_URL = "jdbc:mysql://localhost:3306/chaiddb";
    static final String DB_USER = "root";
    static final String DB_PASSWD = "";
    
    public Connection getConnection(){
        Connection con = null;
        
        try{
            con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            return con;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
