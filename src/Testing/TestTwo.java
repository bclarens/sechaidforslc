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
public class TestTwo {
    public static RCaller caller = RCaller.create();
    public static RCode code = RCode.create();
    
    public TestTwo(RCaller caller, RCode code)
    {
        this.caller = caller;
        this.code = code;
    }
    
    public static void run()
    {
        load();
        testMD();
        testND();
        testSKD();
    }
            
    
     public static void load()
    {
      code.addRCode("CHAID1_1 <- readRDS(\"././RDS/CHAID_M2.rds\")");
      code.addRCode("CHAID1_2 <- readRDS(\"././RDS/CHAID_N2.rds\")");
      code.addRCode("CHAID1_3 <- readRDS(\"././RDS/CHAID_SK2.rds\")");
    }
    public static void testMD()
    {
        arrange();

        code.addRCode("Dermo <- DB_Test[,5]");
        code.addRCode("x_test <- cbind(DB_Test[,1:3], Dermo)");
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
  
    public static void testND()
    {
        arrange();
        
        code.addRCode("Dermo <- DB_Test[,5]");
        code.addRCode("x_test <- cbind(DB_Test[,1:3], Dermo)");
        code.addRCode("N <- predict(CHAID1_2, x_test, type=\"response\")");
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
  
    public static void testSKD()
    {
        arrange();
        
        code.addRCode("Dermo <- DB_Test[,5]");
        code.addRCode("x_test <- cbind(DB_Test[,1:3], Dermo)");
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
        code.addRCode("DB_Test$Asymmetry <- ordered(DB_Test$Asymmetry)");
        code.addRCode("DB_Test$Border <- ordered(DB_Test$Border)");
        code.addRCode("DB_Test$Color <- ordered(DB_Test$Color)");
        code.addRCode("DB_Test$Dermo <- ordered(DB_Test$Dermo)");
    }    
}
