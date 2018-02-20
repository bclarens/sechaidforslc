
package Training;

import com.github.rcaller.rstuff.RCaller;
import com.github.rcaller.rstuff.RCode;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Mehmet Hakan Satman
 * @since 2.0
 * @version 2.0
 * 
 */
public class ModelTraining{
    public static RCaller caller = RCaller.create();
    public static RCode code = RCode.create();
    
    public void ModelTrain(Integer index, JLabel label)
    {
    
        try 
        {
          code.addRCode("library(CHAID)");
          code.addRCode("DB_M <- read.csv(\"././src-csv/Feat_TrainM.csv\", header = TRUE, sep = \",\")");
          code.addRCode("DB_N <- read.csv(\"././src-csv/Feat_TrainN.csv\", header = TRUE, sep = \",\")");
          code.addRCode("DB_SK <- read.csv(\"././src-csv/Feat_TrainSK.csv\", header = TRUE, sep = \",\")");

          if(index == 0)      //Melanoma Dataset (Diameter)
          {
              code.addRCode("DB_Feature <- rbind(DB_M, DB_N[1:125, ], DB_SK[126:250, ])");
              code.addRCode("Diagnosis<-DB_Feature[,6]");
              code.addRCode("DB_Train <- cbind(DB_Feature[,1:4], Diagnosis)");
              CHAID("CHAID_M1", 0, label);          
          }
          else if(index == 1)      //Nevus Dataset (Diameter)
          {
              code.addRCode("DB_Feature <- rbind(DB_N, DB_M[1:125, ], DB_SK[126:250, ])");
              code.addRCode("Diagnosis<-DB_Feature[,7]");
              code.addRCode("DB_Train <- cbind(DB_Feature[,1:4], Diagnosis)");
              CHAID("CHAID_N1", 0, label);
          }
          else if(index == 2)       //Seborrheic Keratosis Dataset (Diameter)
          {
              code.addRCode("DB_Feature <- rbind(DB_SK, DB_M[1:125, ], DB_N[126:250, ])");
              code.addRCode("Diagnosis<-DB_Feature[,8]");
              code.addRCode("DB_Train <- cbind(DB_Feature[,1:4], Diagnosis)");
              CHAID("CHAID_SK1", 0, label);
          } 
          else if(index == 3)       //Melanoma Dataset (Dermoscopic Structure)
          {
              code.addRCode("DB_Feature <- rbind(DB_M, DB_N[76:200, ], DB_SK[76:200, ])");
              code.addRCode("Diagnosis<-DB_Feature[,6]");
              code.addRCode("Dermo<-DB_Feature[,5]");
              code.addRCode("DB_Train <- cbind(DB_Feature[,1:3],Dermo, Diagnosis)");
              CHAID("CHAID_M2", 1, label);
          } 
          else if(index == 4)       //Nevus Dataset (Dermoscopic Structure)
          {
              code.addRCode("DB_Feature <- rbind(DB_N, DB_M[1:125, ], DB_SK[126:250, ])");
              code.addRCode("Diagnosis<-DB_Feature[,7]");
              code.addRCode("Dermo<-DB_Feature[,5]");
              code.addRCode("DB_Train <- cbind(DB_Feature[,1:3],Dermo, Diagnosis)");
              CHAID("CHAID_N2", 1, label);
          } 
          else if(index == 5)       //Seborrheic Keratosis Dataset (Dermoscopic Structure)
          {
              code.addRCode("DB_Feature <- rbind(DB_SK, DB_M[1:125, ], DB_N[126:250, ])");
              code.addRCode("Diagnosis<-DB_Feature[,8]");
              code.addRCode("Dermo<-DB_Feature[,5]");
              code.addRCode("DB_Train <- cbind(DB_Feature[,1:3],Dermo, Diagnosis)");
              CHAID("CHAID_SK2", 1, label);
          } 
          caller = RCaller.create();
        } catch (Exception e) {Logger.getLogger(ModelTraining.class.getName()).log(Level.SEVERE, e.getMessage()); System.exit(0);}
  }
    
 public void ModelTrain2(int i)
    {
    
        try 
        {
          code.addRCode("library(CHAID)");
          code.addRCode("DB_M <- read.csv(\"././src-csv/Feat_TrainM.csv\", header = TRUE, sep = \",\")");
          code.addRCode("DB_N <- read.csv(\"././src-csv/Feat_TrainN.csv\", header = TRUE, sep = \",\")");
          code.addRCode("DB_SK <- read.csv(\"././src-csv/Feat_TrainSK.csv\", header = TRUE, sep = \",\")");

            //Melanoma Dataset (Diameter)
          switch(i){
              
              case 0:
              code.addRCode("DB_Feature <- rbind(DB_M, DB_N[1:125, ], DB_SK[126:250, ])");
              code.addRCode("Diagnosis<-DB_Feature[,6]");
              code.addRCode("DB_Train <- cbind(DB_Feature[,1:4], Diagnosis)");
              CHAID2("CHAID_M1", 0, "md1.png");          
              break;
          //Nevus Dataset (Diameter)
              case 1:
              code.addRCode("DB_Feature <- rbind(DB_N, DB_M[1:125, ], DB_SK[126:250, ])");
              code.addRCode("Diagnosis<-DB_Feature[,7]");
              code.addRCode("DB_Train <- cbind(DB_Feature[,1:4], Diagnosis)");
              CHAID2("CHAID_N1", 0, "nd1.png");
              break;
          //Seborrheic Keratosis Dataset (Diameter)
              case 2:
              code.addRCode("DB_Feature <- rbind(DB_SK, DB_M[1:125, ], DB_N[126:250, ])");
              code.addRCode("Diagnosis<-DB_Feature[,8]");
              code.addRCode("DB_Train <- cbind(DB_Feature[,1:4], Diagnosis)");
              CHAID2("CHAID_SK1", 0, "sd1.png");
              break;
           //Melanoma Dataset (Dermoscopic Structure)
              case 3:
              code.addRCode("DB_Feature <- rbind(DB_M, DB_N[76:200, ], DB_SK[76:200, ])");
              code.addRCode("Diagnosis<-DB_Feature[,6]");
              code.addRCode("Dermo<-DB_Feature[,5]");
              code.addRCode("DB_Train <- cbind(DB_Feature[,1:3],Dermo, Diagnosis)");
              CHAID2("CHAID_M2", 1, "md2.png");
              break;
              //Nevus Dataset (Dermoscopic Structure)
              case 4:
              code.addRCode("DB_Feature <- rbind(DB_N, DB_M[1:125, ], DB_SK[126:250, ])");
              code.addRCode("Diagnosis<-DB_Feature[,7]");
              code.addRCode("Dermo<-DB_Feature[,5]");
              code.addRCode("DB_Train <- cbind(DB_Feature[,1:3],Dermo, Diagnosis)");
              CHAID2("CHAID_N2", 1, "nd2.png");
              break;
              //Seborrheic Keratosis Dataset (Dermoscopic Structure)
              case 5:
              code.addRCode("DB_Feature <- rbind(DB_SK, DB_M[1:125, ], DB_N[126:250, ])");
              code.addRCode("Diagnosis<-DB_Feature[,8]");
              code.addRCode("Dermo<-DB_Feature[,5]");
              code.addRCode("DB_Train <- cbind(DB_Feature[,1:3],Dermo, Diagnosis)");
              CHAID2("CHAID_SK2", 1, "sd2.png");
              break;
          }
          caller = RCaller.create();
        } catch (Exception e) {Logger.getLogger(ModelTraining.class.getName()).log(Level.SEVERE, e.getMessage()); System.exit(0);}
  }   
 
  
 public static void plot2(String data, String fn) throws IOException
  {
      try
      {
        caller = RCaller.create();
        File file;
        file = code.startPlot();
        code.addRCode(data);
        code.endPlot();

        caller.setRCode(code);
        caller.runOnly();

        ImageIcon ic= code.getPlot(file);
        
        code.endPlot();
        Image ii = ic.getImage();
       // BufferedImage bi = (BufferedImage)ii;
         BufferedImage bi = new BufferedImage(ii.getWidth(null),ii.getHeight(null),BufferedImage.TYPE_INT_ARGB);
         Graphics2D g2 = bi.createGraphics();
        g2.drawImage(ii, 0, 0, null);
        g2.dispose();
        try{
        
        File plotimg = new File("plotimg\\"+fn);
        ImageIO.write(bi, "png", plotimg);
        }catch(IOException e){
        }
        
        caller = RCaller.create();
        //code.showPlot(file);
      } catch (Exception e) {Logger.getLogger(ModelTraining.class.getName()).log(Level.SEVERE, e.getMessage()); System.exit(0);}
      
  }
 
    
 
  public static void plot(String data, JLabel label) throws IOException
  {
      try
      {
        caller = RCaller.create();
        File file;
        file = code.startPlot();
        code.addRCode(data);
        code.endPlot();

        caller.setRCode(code);
        caller.runOnly();

        Image dimg = code.getPlot(file).getImage()
                .getScaledInstance(label.getWidth(), 
                label.getHeight(),
                Image.SCALE_SMOOTH);
        code.endPlot();
        
        ImageIcon i = new ImageIcon(dimg);
        label.setIcon(i);
        caller = RCaller.create();
        //code.showPlot(file);
      } catch (Exception e) {Logger.getLogger(ModelTraining.class.getName()).log(Level.SEVERE, e.getMessage()); System.exit(0);}
      
  }

  public static void asDiameter(String data, JLabel label) throws IOException
  {
      try
      {
        code.addRCode("DB_Train$Asymmetry <- ordered(DB_Train$Asymmetry)");
        code.addRCode("DB_Train$Border <- ordered(DB_Train$Border)");
        code.addRCode("DB_Train$Color <- ordered(DB_Train$Color)");
        code.addRCode("DB_Train$Diameter <- ordered(DB_Train$Diameter)");
        code.addRCode("DB_Train$Diagnosis <- factor(DB_Train$Diagnosis)");

        code.addRCode(data + " <- chaid(Diagnosis ~ Asymmetry + Border + Color + Diameter, "
                + "data = DB_Train, control = ctr)");
        code.addRCode("saveRDS(" + data + ", \"RDS/" + data + ".rds\")");
        plot("plot(" + data +")", label);
        //generateTree(data);
      } catch (Exception e) {Logger.getLogger(ModelTraining.class.getName()).log(Level.SEVERE, e.getMessage()); System.exit(0);}
  }
  
  public static void asDiameter2(String data, String fn) throws IOException
  {
      try
      {
        code.addRCode("DB_Train$Asymmetry <- ordered(DB_Train$Asymmetry)");
        code.addRCode("DB_Train$Border <- ordered(DB_Train$Border)");
        code.addRCode("DB_Train$Color <- ordered(DB_Train$Color)");
        code.addRCode("DB_Train$Diameter <- ordered(DB_Train$Diameter)");
        code.addRCode("DB_Train$Diagnosis <- factor(DB_Train$Diagnosis)");

        code.addRCode(data + " <- chaid(Diagnosis ~ Asymmetry + Border + Color + Diameter, "
                + "data = DB_Train, control = ctr)");
        code.addRCode("saveRDS(" + data + ", \"RDS/" + data + ".rds\")");
        plot2("plot(" + data +")", fn);
        //generateTree(data);
      } catch (Exception e) {Logger.getLogger(ModelTraining.class.getName()).log(Level.SEVERE, e.getMessage()); System.exit(0);}
  }
  
  public static void asDermo(String data, JLabel label) throws IOException
  {
      try
      {
        code.addRCode("DB_Train$Asymmetry <- ordered(DB_Train$Asymmetry)");
        code.addRCode("DB_Train$Border <- ordered(DB_Train$Border)");
        code.addRCode("DB_Train$Color <- ordered(DB_Train$Color)");
        code.addRCode("DB_Train$Diagnosis <- factor(DB_Train$Diagnosis)");
        code.addRCode("DB_Train$Dermo <- ordered(DB_Train$Dermo)");

        code.addRCode(data + " <- chaid(Diagnosis ~ Asymmetry + Border + Color + Dermo, "
                + "data = DB_Train, control = ctr)");
        code.addRCode("saveRDS(" + data + ", \"RDS/" + data + ".rds\")");
        plot("plot(" + data +")", label);
      } catch (Exception e) {Logger.getLogger(ModelTraining.class.getName()).log(Level.SEVERE, e.getMessage()); System.exit(0);}
  }
  
  public static void asDermo2(String data, String fn) throws IOException
  {
      try
      {
        code.addRCode("DB_Train$Asymmetry <- ordered(DB_Train$Asymmetry)");
        code.addRCode("DB_Train$Border <- ordered(DB_Train$Border)");
        code.addRCode("DB_Train$Color <- ordered(DB_Train$Color)");
        code.addRCode("DB_Train$Diagnosis <- factor(DB_Train$Diagnosis)");
        code.addRCode("DB_Train$Dermo <- ordered(DB_Train$Dermo)");

        code.addRCode(data + " <- chaid(Diagnosis ~ Asymmetry + Border + Color + Dermo, "
                + "data = DB_Train, control = ctr)");
        code.addRCode("saveRDS(" + data + ", \"RDS/" + data + ".rds\")");
        plot2("plot(" + data +")", fn);
      } catch (Exception e) {Logger.getLogger(ModelTraining.class.getName()).log(Level.SEVERE, e.getMessage()); System.exit(0);}
  }
    
  public static void CHAID(String data, Integer index, JLabel label) throws IOException
  {
      code.addRCode("ctr <- chaid_control(alpha2 =  0.01, alpha3 = -1, alpha4 = 0.5,\n" +
                    "minsplit = 20, minbucket = 5, minprob = 0.05,\n" +
                    "stump = FALSE, maxheight = -1)");
      if(index == 0) asDiameter(data, label);
      else  asDermo(data, label);
  }
  
  public static void CHAID2(String data, Integer index, String fn) throws IOException
  {
      code.addRCode("ctr <- chaid_control(alpha2 =  0.01, alpha3 = -1, alpha4 = 0.5,\n" +
                    "minsplit = 20, minbucket = 5, minprob = 0.05,\n" +
                    "stump = FALSE, maxheight = -1)");
      if(index == 0) asDiameter2(data, fn);
      else  asDermo2(data, fn);
  }

    public static void generateTree(String data) 
    {
        code.addRCode("ft <- fitted("  +  data + ")");
        code.addRCode("pr <- tapply(ft[[2]], ft[[1]], function(y)min(prop.table(table(y))))");
        code.addRCode("PR1 <- c()");
        code.addRCode("for (a in 1:length(pr)){"
                + "PR1  <- c(PR1, pr[[a]])}");
        code.addRCode("result <- as.list(.GlobalEnv)");
        caller.setRCode(code);
        caller.runAndReturnResult("result"); 
    }
}
