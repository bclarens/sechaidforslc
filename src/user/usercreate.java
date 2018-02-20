/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilities.immm;
import utilities.sqlcon;

/**
 *
 * @author Inspiron 14
 */
public class usercreate {
    public void createTable_data(String tabname){
        sqlcon dbconn = new sqlcon();
        Connection connect = null;
        PreparedStatement state = null;
        connect = dbconn.getConnection();
        
        try {
            PreparedStatement create = connect.prepareStatement("CREATE TABLE IF NOT EXISTS "+tabname+"data (img_id INT(11) NOT NULL AUTO_INCREMENT, img LONGBLOB, img_name VARCHAR(15), user_id INT(11), img_grp SMALLINT(6), PRIMARY KEY (img_id), FOREIGN KEY (user_id) REFERENCES user(user_id), FOREIGN KEY (img_grp) REFERENCES dataset_grp(img_grp))");
            create.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(immm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void createTable_feat(String tabname){
        sqlcon dbconn = new sqlcon();
        Connection connect = null;
        PreparedStatement state = null;
        connect = dbconn.getConnection();
        
        try {
            PreparedStatement create = connect.prepareStatement("CREATE TABLE IF NOT EXISTS "+tabname+
                    "feat (df_id INT(11) NOT NULL AUTO_INCREMENT, "+
                    "img_id INT(11), "+        
                    "A TINYINT(1), "+
                    "B TINYINT(1), "+
                    "C TINYINT(1), "+
                    "D1 TINYINT(1), "+
                    "D2 TINYINT(1), "+
                    "PRIMARY KEY (df_id), "+
                    "FOREIGN KEY (img_id) REFERENCES "+tabname+"data(img_id))");
            create.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(immm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
