/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testing;

import com.github.rcaller.rstuff.RCaller;
import com.github.rcaller.rstuff.RCode;

/**
 *
 * @author Skylar Gail
 */
public class Dermoscopic {
    public static RCaller caller = RCaller.create();
    public static RCode code = RCode.create();
    
    public Dermoscopic(RCaller caller, RCode code)
    {
        this.caller = caller;
        this.code = code;
    }
    
    public static void run()
    {
        loadD2();
        testMD2();
        testND2();
        testSKD2();
    }
            
    
     public static void loadD2()
    {
      code.addRCode("CHAID2_1 <- readRDS(\"././RDS/CHAID_M2.rds\")");
      code.addRCode("CHAID2_2 <- readRDS(\"././RDS/CHAID_N2.rds\")");
      code.addRCode("CHAID2_3 <- readRDS(\"././RDS/CHAID_SK2.rds\")");
    }
    public static void testMD2()
    {
        arrange();

        code.addRCode("M <- predict(CHAID2_1, x_test, type=\"response\")");
        code.addRCode("MN <- predict(CHAID2_1, x_test, type=\"node\")");
        code.addRCode("ft <- fitted(CHAID2_1)");
        code.addRCode("pr <- tapply(ft[[2]], ft[[1]], function(y)min(prop.table(table(y))))");
        code.addRCode("PR1 <- c()");
        code.addRCode("for (a in 1:length(pr)){"
                + "PR1  <- c(PR1, pr[[a]])}");
        code.addRCode("PR1N <- names(pr)");
        code.addRCode("result <- as.list(.GlobalEnv)");
    }
  
    public static void testND2()
    {
        arrange();

        code.addRCode("N <- predict(CHAID2_2, x_test, type=\"response\")");
        code.addRCode("NN <- predict(CHAID2_2, x_test, type=\"node\")");
        code.addRCode("NPred <- N");
        code.addRCode("ft <- fitted(CHAID2_2)");
        code.addRCode("pr <- tapply(ft[[2]], ft[[1]], function(y)min(prop.table(table(y))))");
        code.addRCode("PR2 <- c()");
        code.addRCode("for (a in 1:length(pr)){"
                + "PR2  <- c(PR2, pr[[a]])}");
        code.addRCode("PR2N <- names(pr)");
        code.addRCode("result <- as.list(.GlobalEnv)");
    }
  
    public static void testSKD2()
    {
        arrange();

        code.addRCode("SK <- predict(CHAID2_3, x_test, type=\"response\")");
        code.addRCode("SKN <- predict(CHAID2_3, x_test, type=\"node\")");
        code.addRCode("ft <- fitted(CHAID2_3)");
        code.addRCode("pr <- tapply(ft[[2]], ft[[1]], function(y)min(prop.table(table(y))))");
        code.addRCode("PR3 <- c()");
        code.addRCode("for (a in 1:length(pr)){"
                + "PR3  <- c(PR3, pr[[a]])}");
        code.addRCode("PR3N <- names(pr)");
        code.addRCode("result <- as.list(.GlobalEnv)");
        caller.setRCode(code);
        caller.runAndReturnResult("result");
    }
  
    public static void arrange()
    {
        code.addRCode("Dermo <- DB_Feature[,5]");
        code.addRCode("DB_Test <- cbind(DB_Feature[,1:3], Dermo, Diagnosis)");

        code.addRCode("DB_Test$Asymmetry <- ordered(DB_Test$Asymmetry)");
        code.addRCode("DB_Test$Border <- ordered(DB_Test$Border)");
        code.addRCode("DB_Test$Color <- ordered(DB_Test$Color)");
        code.addRCode("DB_Test$Dermo <- ordered(DB_Test$Dermo)");
        code.addRCode("DB_Test$Diagnosis <- factor(DB_Test$Diagnosis)");

        code.addRCode("x_test <- DB_Test[,1:4]");
        code.addRCode("y_test <- DB_Test[,5]");
    } 
}
