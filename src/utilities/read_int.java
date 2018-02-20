
package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



public class read_int {    
    public ArrayList<String[]> r_interp(int loc){
        File file = null;
        if (loc == 0){
           file = new File("lib\\acc_int.csv");
        }else if (loc == 2){
           file = new File("lib\\hypo_int.csv");
        }
        
        // 2-dimensional array of Strings
        ArrayList<String[]> al = new ArrayList<String[]>();
        String line;
        String[] arrdata;        
       
        try{           
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            line = br.readLine();
            
            while((line = br.readLine()) != null){
                arrdata = line.split(",");
                al.add(arrdata);  
            }
            br.close();
        }catch(IOException ioe){
    	   System.out.println("Exception occurred:");
    	   ioe.printStackTrace();
        } 
        
        return al;
    }  
}
