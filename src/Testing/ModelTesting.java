/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Testing;

import utilities.*;
import com.github.rcaller.rstuff.RCaller;
import com.github.rcaller.rstuff.RCode;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Arrays;
import javax.swing.JTextArea;

/**
 *
 * @author Skylar Gail
 */
public class ModelTesting { 
    public static RCaller caller = RCaller.create();
    public static RCode code = RCode.create();
    public static int[] intClassify;
    public static String[] stringClassify;
    public static Diameter testDiameter =  new Diameter(caller, code);
    public static Dermoscopic testDermoscopic =  new Dermoscopic(caller, code);
    public static Classification c;
    public static double[] SR1, SR2;
    public static int ctrl = 0;
    
    public void ModelTest(Integer index1, Integer index2, JTextArea jTextArea2)
    {
        try 
        {
            code.addRCode("library(CHAID)");
            code.addRCode("library(ggplot2)");
            code.addRCode("library(caret)");
            code.addRCode("library(e1071)");
            code.addRCode("library(stats)");

            code.addRCode("DB_M <- read.csv(\"././src-csv/Feat_TestM.csv\", header = TRUE, sep = \",\")");
            code.addRCode("DB_N <- read.csv(\"././src-csv/Feat_TestN.csv\", header = TRUE, sep = \",\")");
            code.addRCode("DB_SK <- read.csv(\"././src-csv/Feat_TestSK.csv\", header = TRUE, sep = \",\")");
            
            if(index2 == 0)
            {
                code.addRCode("DB_Feature <- DB_M");
                jTextArea2.setText(jTextArea2.getText () + "\n == Melanoma ==");
                code.addRCode("Diagnosis <- DB_Feature[,6] ");
                TestDiameter(0);
                testing(index1, jTextArea2,  "Diameter");
            }
            else if(index2 == 1)
            {
                code.addRCode("DB_Feature <- DB_N");
                jTextArea2.setText(jTextArea2.getText () + "\n == Nevus ==");
                code.addRCode("Diagnosis <- DB_Feature[,7] ");
                TestDiameter(1);
                testing(index1, jTextArea2,  "Diameter");
            }
            else if(index2 == 2)
            {
                code.addRCode("DB_Feature <- DB_SK");
                jTextArea2.setText(jTextArea2.getText () + "\n == Sebborheic Keratosis ==");
                code.addRCode("Diagnosis <- DB_Feature[,8] ");
                TestDiameter(3);
                testing(index1, jTextArea2,  "Diameter");
            }  
      
            caller = RCaller.create();

            if(index2 == 0)
            {
                code.addRCode("DB_Feature <- DB_M");
                code.addRCode("Diagnosis <- DB_Feature[,6] ");
                TestDermo();
                testing(index1, jTextArea2,  "Dermoscopic Structure");
            }          
            else if(index2 == 1)
            {
                code.addRCode("DB_Feature <- DB_N");
                code.addRCode("Diagnosis <- DB_Feature[,7] ");
                TestDermo();
                testing(index1, jTextArea2,  "Dermoscopic Structure");
            }
            else if(index2 == 2)
            {
                code.addRCode("DB_Feature <- DB_SK");
                code.addRCode("Diagnosis <- DB_Feature[,8] ");
                TestDermo();
                testing(index1, jTextArea2,  "Dermoscopic Structure");
            }
     
            jTextArea2.setText(jTextArea2.getText () + "\n");
            caller = RCaller.create();
        } 
        catch (Exception e) 
        {
            Logger.getLogger(ModelTesting.class.getName()).log(Level.SEVERE, e.getMessage()); 
            System.exit(0);
        }
  }
    
    public static int[] convert(String[] classify, int index)
    {
        int[] res = new int[classify.length];
        if(index == 0){
            res = convert2(classify,"Melanoma");            
        }else if(index == 1){
            res = convert2(classify,"Nevus");            
        }else {
            res = convert2(classify,"Seborrheic Keratosis");
        }
                      
        return res;
    }
    
    public static int[] convert2(String[] classify, String c){
        int [] res = new int[classify.length];
        
        for(int i = 0; i < classify.length; i++){
            if(classify[i].equalsIgnoreCase(c)){
                 res[i] = 1;
            } else {
                res[i] = 0;
            }
        }
        return res;
    }
    public static void initialize()
    {   
        c = new Classification(
                caller.getParser().getAsDoubleArray("M"),
                caller.getParser().getAsDoubleArray("N"),
                caller.getParser().getAsDoubleArray("SK"),
                caller.getParser().getAsDoubleArray("MN"),
                caller.getParser().getAsDoubleArray("NN"),
                caller.getParser().getAsDoubleArray("SKN"),
                caller.getParser().getAsDoubleArray("PR1"),
                caller.getParser().getAsDoubleArray("PR2"),
                caller.getParser().getAsDoubleArray("PR3"),
                caller.getParser().getAsDoubleArray("PR1N"),
                caller.getParser().getAsDoubleArray("PR2N"),
                caller.getParser().getAsDoubleArray("PR3N"));
    }
    
    public static void TestDiameter(int index)
    {
        testDiameter =  new Diameter(caller, code);
        testDiameter.run();
        System.out.println(Arrays.toString(caller.getParser().getAsStringArray("M")));
        System.out.println(Arrays.toString(caller.getParser().getAsStringArray("N")));
        System.out.println(Arrays.toString(caller.getParser().getAsStringArray("SK")));
          
        initialize();
          
        stringClassify = c.getClassification();
        intClassify = convert(stringClassify, index);
        System.out.println("1's and 0's: " + Arrays.toString(intClassify));
        
    }
    public static void TestDermo()
    {
        //RCaller caller = RCaller.create();
        testDermoscopic =  new Dermoscopic(caller, code);
        testDermoscopic.run();
          
        initialize();
          
        stringClassify = c.getClassification();
        intClassify = convert(stringClassify, 0);
    }
    
    
    public static void testing(Integer index1, JTextArea jTextArea2, String a)
    {
      caller = RCaller.create();
      code.addIntArray("pred", intClassify);
      code.addRCode("pred <- as.factor(pred)");
      
      //Experiment
      if(index1 == 0)
      {
        Testing testAccuracy = new Testing(caller, code);
            jTextArea2.setText(jTextArea2.getText () + "\n Accuracy "  +  a + ": " + Math.round(testAccuracy.getAccuracy() * 100) + "%");
      }
      else if(index1 == 1)
      {
          //DecimalFormat format = new DecimalFormat("##0.00");
          Testing testSR = new Testing(caller, code);
          
          double[] def = testSR.getSuccessRate();
          if(a.equalsIgnoreCase("Diameter"))
              SR1 = def;
          else
              SR2 = def;
          
          jTextArea2.setText(jTextArea2.getText () +  "\n  Success Rates of " + a + ": " + Arrays.toString(def));
      }
      else if(index1 == 2)
      {
          if(SR1 != null && SR2 != null && ctrl == 0)
          {
            ctrl++;
            code.addDoubleArray("SR1", SR1);
            code.addDoubleArray("SR2", SR2);
            code.addRCode("res <- t.test(SR1,SR2)");
            code.addRCode("res <- res$p.value");
            code.addRCode("result <- as.list(.GlobalEnv)");
            caller.setRCode(code);
            caller.runAndReturnResult("result");
            System.out.println();
            jTextArea2.setText(jTextArea2.getText () +  "\n  Hypothesis Result(p-value): " + Arrays.toString(caller.getParser().getAsStringArray("res")));
            SR1 = new double[]{};
            SR2 = new double[]{};
          }
          else
              System.out.println("Error: No Success Rates");
      }
    }
}
