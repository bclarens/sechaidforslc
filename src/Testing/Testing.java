/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testing;

import utilities.*;
import com.github.rcaller.rstuff.RCaller;
import com.github.rcaller.rstuff.RCode;
import java.util.Arrays;

/**
 *
 * @author Skylar Gail
 */
public class Testing 
{
    public static RCaller caller = RCaller.create();
    public static RCode code = RCode.create();
    
    public Testing(RCaller caller, RCode code)
    {
        this.caller = caller;
        this.code = code;
    }
    public static double getAccuracy()
    {
        code.addRCode("confusionTable <- table(pred, y_test)");
        getCM();
        code.addRCode("result <- as.list(.GlobalEnv)");
        caller.setRCode(code);
        caller.runAndReturnResult("result");
        System.out.println("confusionTable: " + Arrays.toString(caller.getParser().getAsStringArray("confusionTable")));
        System.out.println("y_test: " + Arrays.toString(caller.getParser().getAsStringArray("y_test")));
        double TP = (caller.getParser().getAsDoubleArray("confusionTable")[0]);
        double FN = (caller.getParser().getAsDoubleArray("confusionTable")[1]);
        double ans = (TP / (TP + FN));
        return ans;
    }
    public static double[] getSuccessRate()
    {
        caller = RCaller.create();
        code.addRCode("confusionTable <- table(pred, M)");
        getCM();
        code.addRCode("result <- as.list(.GlobalEnv)");
        caller.setRCode(code);
        caller.runAndReturnResult("result");
        //System.out.println(Arrays.toString(caller.getParser().getAsStringArray("pred")));
        double TP = (caller.getParser().getAsDoubleArray("confusionTable")[0]);
        double FN = (caller.getParser().getAsDoubleArray("confusionTable")[1]);
        double ans1 = (TP / (TP + FN));
        
        caller = RCaller.create();
        code.addRCode("confusionTable <- table(pred, N)");
        getCM();
        code.addRCode("result <- as.list(.GlobalEnv)");
        caller.setRCode(code);
        caller.runAndReturnResult("result");
        TP = (caller.getParser().getAsDoubleArray("confusionTable")[0]);
        FN = (caller.getParser().getAsDoubleArray("confusionTable")[1]);
        double ans2 = (TP / (TP + FN));
        
        caller = RCaller.create();
        code.addRCode("confusionTable <- table(pred, SK)");
        getCM();
        code.addRCode("result <- as.list(.GlobalEnv)");
        caller.setRCode(code);
        caller.runAndReturnResult("result");
        //System.out.println(Arrays.toString(caller.getParser().getAsStringArray("pred")));
        TP = (caller.getParser().getAsDoubleArray("confusionTable")[0]);
        FN = (caller.getParser().getAsDoubleArray("confusionTable")[1]);
        double ans3 = (TP / (TP + FN));
        
        double[] result = {ans1,  ans2, ans3};
        return result;
    }
    
    public static void getCM()
    {
        code.addRCode("TN <- confusionTable[1]");
        code.addRCode("FN <- confusionTable[3]");
        code.addRCode("FP <- confusionTable[2]");
        code.addRCode("TP <- confusionTable[4]");
    }
}
