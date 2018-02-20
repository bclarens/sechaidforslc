/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testing;

import com.github.rcaller.rstuff.RCaller;
import com.github.rcaller.rstuff.RCode;
import java.util.Arrays;
import javax.swing.JTextArea;

/**
 *
 * @author Skylar Gail
 */
public class UserTesting 
{
    public static RCaller caller = RCaller.create();
    public static RCode code = RCode.create();
    public static TestOne testDiameter;
    public static TestTwo testDermo;
    public static Classification c;
    public static int[] intClassify;
    public static String[] stringClassify;
    
    public void UserTest(String file, JTextArea jTextArea1)
    {
        code.addRCode("library(CHAID)");
        code.addRCode("library(ggplot2)");
        code.addRCode("library(caret)");
        code.addRCode("library(e1071)");
        code.addRCode("library(stats)");
        
        code.addRCode("DB_Test <- read.csv(\"././src-csv/Feat_" + file + ".csv\", header = TRUE, sep = \",\")");
        int i = 1;
        if(i == 1)
            TestDiameter(jTextArea1);
        
        caller =  RCaller.create();
        
        if(i == 1)
            TestDermo(jTextArea1);
    }
    
    public static void TestDiameter(JTextArea jTextArea1)
    {
        testDiameter =  new TestOne(caller, code);
        testDiameter.run();
        System.out.println(Arrays.toString(caller.getParser().getAsStringArray("M")));
        System.out.println(Arrays.toString(caller.getParser().getAsStringArray("N")));
        System.out.println(Arrays.toString(caller.getParser().getAsStringArray("SK")));
          
        initialize();
          
        stringClassify = c.getClassification();
        jTextArea1.setText("Diameter Result: "+Arrays.toString(stringClassify));
    }
    
    public static void TestDermo(JTextArea jTextArea1)
    {
        testDermo =  new TestTwo(caller, code);
        testDermo.run();
        System.out.println(Arrays.toString(caller.getParser().getAsStringArray("M")));
        System.out.println(Arrays.toString(caller.getParser().getAsStringArray("N")));
        System.out.println(Arrays.toString(caller.getParser().getAsStringArray("SK")));
          
        initialize();
          
        stringClassify = c.getClassification();
        jTextArea1.setText(jTextArea1.getText() + "\nDermoscopic Structure Result: "  +  Arrays.toString(stringClassify));
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
}
