package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import FeatureExtractor.featureclass;

public class writefeatures {    
    
    //feature extraction for admin
    public void feature_extract(int choice){
        write_csv wrcsv = new write_csv();
        retrieve_str rstr = new retrieve_str();
        rw_data r = new rw_data();
        combo x = new combo();
        
        String line = null;
        String arrdata[];
        extract_feat extract = new extract_feat();
        
        String csvname = x.getcsvname(choice);
        
        try{
            File file = new File("tempdata.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            
            while((line = br.readLine()) != null){
                //example: "image1.jpg,C:\Desktop\SampleFolder,1"
                arrdata = line.split(",");
                
                //getting the id
                String arrdata0 = arrdata[0];
                int arrdata2 = Integer.parseInt(arrdata[2]);
                String indicator = rstr.get_name(arrdata0);
                int pid = get_imgid(indicator);
                //System.out.println("IMG ID: "+pid+" IMGNAME: "+arrdata[0]+" DIR: "+arrdata[1]);
                
                
                //feature extraction
                String res = extract.retrieve_feat(arrdata[0], arrdata[1], arrdata2);
                String fres = format_res(res);
                System.out.println("Result: "+fres);
                
                //write features to csv
                wrcsv.writecsv(fres, csvname);
                
                //insert features to database
                int valA = Character.getNumericValue(fres.charAt(0));
                int valB = Character.getNumericValue(fres.charAt(3));
                int valC = Character.getNumericValue(fres.charAt(6));
                int valD1 = Character.getNumericValue(fres.charAt(9));
                int valD2 = Character.getNumericValue(fres.charAt(12));
                insertfeat_db(pid, valA, valB, valC, valD1, valD2);
                        
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(rw_data.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(rw_data.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //feature extraction for casual user
    public void feature_extractcas(String csvname){
        write_csv wrcsvcas = new write_csv();
        retrieve_str rstr = new retrieve_str();
        rw_data r = new rw_data();
        
        String line = null;
        String arrdata[];
        extract_feat extract = new extract_feat();
        
        
        try{
            File file = new File("tempdatacas.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            
            while((line = br.readLine()) != null){
                //example: "image1.jpg,C:\Desktop\SampleFolder"
                arrdata = line.split(",");
                
                //getting the id
                String arrdata0 = arrdata[0];
                int arrdata2 = 0; //
                String indicator = rstr.get_name(arrdata0);
                int pid = get_imgidcas(indicator,csvname);
                //System.out.println("IMG ID: "+pid+" IMGNAME: "+arrdata[0]+" DIR: "+arrdata[1]);
                
                
                //feature extraction
                String res = extract.retrieve_feat(arrdata[0], arrdata[1], arrdata2);
                // res = [2, 0, 1, 1, 1, 1, 0, 0]
                String fres = format_res(res);
                // fres = 2, 0, 1, 1, 1, 1, 0, 0
                String nfres = format_frescas(fres);
                // nfres = 2, 0, 1, 1, 1
                System.out.println("Result: "+fres);
                
                //write features to csv
                wrcsvcas.writecsvcas(nfres, csvname);
                
                //insert features to database
                int valA = Character.getNumericValue(fres.charAt(0));
                int valB = Character.getNumericValue(fres.charAt(3));
                int valC = Character.getNumericValue(fres.charAt(6));
                int valD1 = Character.getNumericValue(fres.charAt(9));
                int valD2 = Character.getNumericValue(fres.charAt(12));
                insertfeat_dbcas(pid, valA, valB, valC, valD1, valD2, csvname);
                        
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(rw_data.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(rw_data.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String format_res(String res){
        String fres = res.substring(res.indexOf('[')+1, res.indexOf(']'));
        
        return fres;
    }
    
    public String format_frescas(String fres){
        String nfres = fres.substring(0, 13);
        
        return nfres;
    }
    
    public int get_imgid(String pointer){
        sqlcon dbconn = new sqlcon();
        Connection connect = null;
        PreparedStatement state = null;
        connect = dbconn.getConnection();
        ResultSet resset = null;
        int pointid;
        try{
            String query = "SELECT img_id FROM dataset WHERE dataset.img_name = ?";
            state = connect.prepareStatement(query);
            state.setString(1, pointer);
            resset = state.executeQuery();
            
            while(resset.next()){
                pointid = resset.getInt("img_id");
                return pointid;
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return 0;
    }
    
    public int get_imgidcas(String pointer, String tablename){
        sqlcon dbconn = new sqlcon();
        Connection connect = null;
        PreparedStatement state = null;
        connect = dbconn.getConnection();
        ResultSet resset = null;
        int pointid;
        try{
            String query = "SELECT img_id FROM "+tablename+"data WHERE "+tablename+"data.img_name = ?";
            state = connect.prepareStatement(query);
            state.setString(1, pointer);
            resset = state.executeQuery();
            
            while(resset.next()){
                pointid = resset.getInt("img_id");
                return pointid;
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return 0;
    }
    
/*    public static void retrieve_frm_db(){
        sqlcon dbconn = new sqlcon();
        Connection connect = null;
        PreparedStatement state = null;
        connect = dbconn.getConnection();
        ResultSet resset = null;
        int fa,fb,fc,fd1,fd2;
         write_csv wrcsv = new write_csv();
        String sa,sb,sc,sd1,sd2,fs;
        try{
            String query = "SELECT A, B, C, D1, D2 FROM data_feat WHERE img_id>=958 AND img_id<=1077 ";
            state = connect.prepareStatement(query);
            resset = state.executeQuery();
            
            while(resset.next()){
                
                fa = resset.getInt("A");
                fb = resset.getInt("B");
                fc = resset.getInt("C");
                fd1 = resset.getInt("D1");
                fd2 = resset.getInt("D2");
                
                sa = Integer.toString(fa);
                sb = Integer.toString(fb);
                sc = Integer.toString(fc);
                sd1 = Integer.toString(fd1);
                sd2 = Integer.toString(fd2);
                
                fs = sa+", "+sb+", "+sc+", "+sd1+", "+sd2+", "+"0, 0, 1";
                
                wrcsv.writecsv(fs);

            }
           
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
*/    
    public static void insertfeat_db(int id, int val_a, int val_b, int val_c, int val_d1, int val_d2){
        sqlcon dbconn = new sqlcon();
        Connection connect = null;
        PreparedStatement pstate = null;
        connect = dbconn.getConnection();
        int result;
        try{
            String query = "INSERT INTO data_feat(img_id, A, B, C, D1, D2) VALUES (?,?,?,?,?,?)";
            pstate = connect.prepareStatement(query);
          
            pstate.setInt(1, id);
            pstate.setInt(2, val_a);
            pstate.setInt(3, val_b);
            pstate.setInt(4, val_c);
            pstate.setInt(5, val_d1);
            pstate.setInt(6, val_d2);
            result = pstate.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public static void insertfeat_dbcas(int id, int val_a, int val_b, int val_c, int val_d1, int val_d2, String tabname){
        sqlcon dbconn = new sqlcon();
        Connection connect = null;
        PreparedStatement pstate = null;
        connect = dbconn.getConnection();
        int result;
        try{
            String query = "INSERT INTO "+tabname+"feat(img_id, A, B, C, D1, D2) VALUES (?,?,?,?,?,?)";
            pstate = connect.prepareStatement(query);
          
            pstate.setInt(1, id);
            pstate.setInt(2, val_a);
            pstate.setInt(3, val_b);
            pstate.setInt(4, val_c);
            pstate.setInt(5, val_d1);
            pstate.setInt(6, val_d2);
            result = pstate.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
