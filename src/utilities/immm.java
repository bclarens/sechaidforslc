/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
//import static utilities.teststring.retrieve_frm_db;

/**
 *
 * @author Inspiron 14
 */
public class immm {
    static final String DB_URL = "jdbc:mysql://localhost:3306/mictest";
    static final String DB_USER = "root";
    static final String DB_PASSWD = "";
    
    sqlcon dbconn = new sqlcon();
    public static void main (String[]args){
//        rw_data wrdata = new rw_data();
////        String fn = "John";
////        String ln = "Doe";
////        String f1 = Character.toString(fn.toLowerCase().charAt(0));
////        String l1 = Character.toString(ln.toLowerCase().charAt(0));
////        System.out.println(f1+l1);
//        //System.out.println(n.substring(n.lastIndexOf(",")+1));
//        //String tn = "mictestfeat";
//        //createTable(tn);
//        String r = wrdata.readsession(0)+"-data";
//        System.out.println(r);

        String fname = "jd20";
       String cvname = "Feat_"+fname+".csv";
        System.out.println(cvname);
    }
    
    public static void createTable(String tabname){
        Connection connect = getConnection();
        
        try {
            PreparedStatement create = connect.prepareStatement("CREATE TABLE IF NOT EXISTS "+tabname+
                    "(df_id INT(11) NOT NULL AUTO_INCREMENT, "+
                    "img_id INT(11), "+        
                    "A TINYINT(1), "+
                    "B TINYINT(1), "+
                    "C TINYINT(1), "+
                    "D1 TINYINT(1), "+
                    "D2 TINYINT(1), "+
                    "PRIMARY KEY (df_id))");
            create.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(immm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Connection getConnection(){
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
