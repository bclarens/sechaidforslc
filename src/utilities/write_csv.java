package utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class write_csv {
   
//        String f = "1, 1, 1, 1, 1, 0, 0, 1";
//        String ff = "Feat_Sample.csv";
//        writecsv(f, ff);

    
    public void writecsv(String feature, String fname){
      try{
          File file = new File("src-csv\\"+fname);
          
          if(!file.exists()){
    	 	file.createNewFile(); 
                FileWriter fw = new FileWriter(file,true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.println("Asymmetry,Border,Color,Diameter,Dermo,Melanoma,Nevus,Keratosis");
                pw.close();
    	  }
          
          addData(feature, fname);
                  
       }catch(IOException ioe){
    	   System.out.println("Exception occurred:");
    	   ioe.printStackTrace();
      } 
   }      
    
    public void writecsvcas(String feature, String fname){
      try{
          String cvname = "Feat_"+fname+".csv";
          File file = new File("src-csv\\"+cvname);
          
          if(!file.exists()){
    	 	file.createNewFile(); 
                FileWriter fw = new FileWriter(file,true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.println("Asymmetry,Border,Color,Diameter,Dermo");
                pw.close();
    	  }
          
          addData(feature, cvname);
                  
       }catch(IOException ioe){
    	   System.out.println("Exception occurred:");
    	   ioe.printStackTrace();
      } 
   } 
    
    
     public void addData(String feature, String filename){
        try{
              File file = new File("src-csv\\"+filename);
             
              FileWriter fw = new FileWriter(file,true);
              BufferedWriter bw = new BufferedWriter(fw);
              PrintWriter pw = new PrintWriter(bw);
              pw.println(feature);         
              pw.close();
              System.out.println("Data successfully appended at the end of file");

        }catch(IOException ioe){
               System.out.println("Exception occurred:");
               ioe.printStackTrace();
        }
    }
}
