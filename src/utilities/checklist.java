package utilities;

import admin.DPrepTab;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class checklist {
    public int checkname(String strcheck){
        sqlcon dbconn = new sqlcon();
        
        Connection connect = dbconn.getConnection();
        PreparedStatement state = null;
        ResultSet resset = null;
        
        Scanner scan = null;
        
        try{
            String sql = "SELECT img_name from dataset WHERE img_name = ?";
            state = connect.prepareStatement(sql);
            state.setString(1, strcheck);
            resset = state.executeQuery();
        
            int count = 0;
            
            while(resset.next()){
                count++;
            }
            if(count==1){
                //if img_name already exists in the database
                return 0;
            }else if(count>1){
            }else{
                //if img_name does not exist in the database
                return 1;
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{ 
            try{
                if(state!=null)
                        state.close();
                if(connect!=null)
                        connect.close();
                if(resset!=null)
                        connect.close();
                if(scan!=null)
                        scan.close();
             }catch(Exception ex){
            ex.printStackTrace();
            }
        }    
        return -1;
    }
    
    public int checknamecas(String strcheck, String tname){
        sqlcon dbconn = new sqlcon();
        
        Connection connect = dbconn.getConnection();
        PreparedStatement state = null;
        ResultSet resset = null;
        
        Scanner scan = null;
        
        try{
            String sql = "SELECT img_name from "+tname+"data WHERE img_name = ?";
            state = connect.prepareStatement(sql);
            state.setString(1, strcheck);
            resset = state.executeQuery();
        
            int count = 0;
            
            while(resset.next()){
                count++;
            }
            if(count==1){
                //if img_name already exists in the database
                return 0;
            }else if(count>1){
            }else{
                //if img_name does not exist in the database
                return 1;
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{ 
            try{
                if(state!=null)
                        state.close();
                if(connect!=null)
                        connect.close();
                if(resset!=null)
                        connect.close();
                if(scan!=null)
                        scan.close();
             }catch(Exception ex){
            ex.printStackTrace();
            }
        }    
        return -1;
    }
 
    public int checkuname(String checkuname){
        sqlcon dbconn = new sqlcon();
        
        Connection connect = dbconn.getConnection();
        PreparedStatement state = null;
        ResultSet resset = null;
        
        Scanner scan = null;
        
        try{
            String sql = "SELECT u_name from user WHERE u_name = ?";
            state = connect.prepareStatement(sql);
            state.setString(1, checkuname);
            resset = state.executeQuery();
        
            int count = 0;
            
            while(resset.next()){
                count++;
            }
            if(count==1){
                //if img_name already exists in the database
                return 0;
            }else if(count>1){
            }else{
                //if img_name does not exist in the database
                return 1;
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{ 
            try{
                if(state!=null)
                        state.close();
                if(connect!=null)
                        connect.close();
                if(resset!=null)
                        connect.close();
                if(scan!=null)
                        scan.close();
             }catch(Exception ex){
            ex.printStackTrace();
            }
        }    
        return -1;
    }
}
