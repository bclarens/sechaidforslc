/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testing;

import utilities.*;
import com.github.rcaller.rstuff.RCaller;
import com.github.rcaller.rstuff.RCode;

/**
 *
 * @author Skylar Gail
 */
public class Diameter {
    public static RCaller caller = RCaller.create();
    public static RCode code = RCode.create();
    
    public Diameter(RCaller caller, RCode code)
    {
        this.caller = caller;
        this.code = code;
    }
    
    public static void run()
    {
        loadD1();
        testMD1();
        testND1();
        testSKD1();
    }
            
    
     public static void loadD1()
    {
      code.addRCode("CHAID1_1 <- readRDS(\"././RDS/CHAID_M1.rds\")");
      code.addRCode("CHAID1_2 <- readRDS(\"././RDS/CHAID_N1.rds\")");
      code.addRCode("CHAID1_3 <- readRDS(\"././RDS/CHAID_SK1.rds\")");
    }
    public static void testMD1()
    {
        arrange();

        code.addRCode("M <- predict(CHAID1_1, x_test, type=\"response\")");
        code.addRCode("MN <- predict(CHAID1_1, x_test, type=\"node\")");
        code.addRCode("ft <- fitted(CHAID1_1)");
        code.addRCode("pr <- tapply(ft[[2]], ft[[1]], function(y)min(prop.table(table(y))))");
        code.addRCode("PR1 <- c()");
        code.addRCode("for (a in 1:length(pr)){"
                + "PR1  <- c(PR1, pr[[a]])}");
        code.addRCode("PR1N <- names(pr)");
        code.addRCode("result <- as.list(.GlobalEnv)");
    }
  
    public static void testND1()
    {
        arrange();

        code.addRCode("N <- predict(CHAID1_2, x_test, type=\"response\")");
        code.addRCode("NN <- predict(CHAID1_2, x_test, type=\"node\")");
        code.addRCode("ft <- fitted(CHAID1_2)");
        code.addRCode("pr <- tapply(ft[[2]], ft[[1]], function(y)min(prop.table(table(y))))");
        code.addRCode("PR2 <- c()");
        code.addRCode("for (a in 1:length(pr)){"
                + "PR2  <- c(PR2, pr[[a]])}");
        code.addRCode("PR2N <- names(pr)");
        code.addRCode("NPred <- N");
        code.addRCode("result <- as.list(.GlobalEnv)");
    }
  
    public static void testSKD1()
    {
        arrange();

        code.addRCode("SK <- predict(CHAID1_3, x_test, type=\"response\")");
        code.addRCode("SKN <- predict(CHAID1_3, x_test, type=\"node\")");
        code.addRCode("ft <- fitted(CHAID1_3)");
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
        code.addRCode("DB_Test <- cbind(DB_Feature[,1:4], Diagnosis)");
        
        code.addRCode("DB_Test$Asymmetry <- ordered(DB_Test$Asymmetry)");
        code.addRCode("DB_Test$Border <- ordered(DB_Test$Border)");
        code.addRCode("DB_Test$Color <- ordered(DB_Test$Color)");
        code.addRCode("DB_Test$Diameter <- ordered(DB_Test$Diameter)");
        code.addRCode("DB_Test$Diagnosis <- factor(DB_Test$Diagnosis)");

        code.addRCode("x_test <- DB_Test[,1:4]");
        code.addRCode("y_test <- DB_Test[,5]");
    }    
}
