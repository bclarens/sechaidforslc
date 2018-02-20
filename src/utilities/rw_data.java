package utilities;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
    writing data and reading data from tempdata.txt
*/
public class rw_data {
    public void writedata(String filename, String dir, String grp){
        try{
            File file = new File("tempdata.txt");
                if(!file.exists()){
                    file.createNewFile();
                }
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw = new BufferedWriter(fw);
            bw.append(filename+","+dir+","+grp);
            bw.newLine();
            bw.flush();
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(rw_data.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
            }catch(Exception ex){
                System.out.println("Error in closing the BufferedWriter"+ex);
            }
        }
    }
    
    public void writedata_cas(String filename, String dir){
        try{
            File file = new File("tempdatacas.txt");
                if(!file.exists()){
                    file.createNewFile();
                }
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw = new BufferedWriter(fw);
            bw.append(filename+","+dir);
            bw.newLine();
            bw.flush();
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(rw_data.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
            }catch(Exception ex){
                System.out.println("Error in closing the BufferedWriter"+ex);
            }
        }
    }
    
    public void writesession(String info){
        try{
            File file = new File("session.txt");
                if(!file.exists()){
                    file.createNewFile();
                }else{
                    file.delete();
                    file.createNewFile();
                }
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw = new BufferedWriter(fw);
            bw.write(info);
            bw.flush();
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(rw_data.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
            }catch(Exception ex){
                System.out.println("Error in closing the BufferedWriter"+ex);
            }
        }
    }
    
    public void cleartempdata(){
        File file = new File("tempdata.txt");
        if(file.exists()){
            file.delete();
        }
    }
    
    public void cleartempdatacas(){
        File file = new File("tempdatacas.txt");
        if(file.exists()){
            file.delete();
        }
    }
    
    public void readdata(){
        String line = null;
        try{
            File file = new File("tempdata.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            while((line = br.readLine()) != null){
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(rw_data.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(rw_data.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String readsession(int i){
        String line = null;
        String arrdata[];
        try{
            File file = new File("session.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            while((line = br.readLine()) != null){
                arrdata = line.split(",");
                String info = arrdata[i];
                return info;
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(rw_data.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(rw_data.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
    public int checkifempty(String filetxt){
        String line = null;
        try{
            File file = new File(filetxt);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            while((line = br.readLine()) == null){
                return 0;
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(rw_data.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(rw_data.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 1;
    }
    
    public void filterdata(){
        String line = null;
        try{
            File file = new File("tempdata.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            
            boolean found = true;
            
            while(((line = br.readLine()) != null) && !found){
                System.out.println(line);
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(rw_data.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(rw_data.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int countLineNum(){
        InputStream is = null;
        try {
            
            is = new BufferedInputStream(new FileInputStream("tempdata.txt"));
            try {
                
                byte[]c = new byte[1024];
                int count = 0;
                int readchars = 0;
                boolean empty = true;
                
                while((readchars=is.read(c)) != -1){
                    empty = false;
                    for(int i=0; i<readchars; i++){
                        if(c[i] == '\n'){
                            count++;
                        }
                    }
                }
                return (count == 0 && !empty) ? 1 : count;
            } catch (FileNotFoundException ex) {
                Logger.getLogger(rw_data.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(rw_data.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                try {
                    is.close();
                } catch (IOException ex) {
                    Logger.getLogger(rw_data.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(rw_data.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                is.close();
            } catch (IOException ex) {
                Logger.getLogger(rw_data.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;
    }
}
