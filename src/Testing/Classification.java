/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testing;

import utilities.*;
import java.util.Arrays;

/**
 *
 * @author Skylar Gail
 */
public class Classification 
{
    public static double[] M, N, SK;
    public static double[] MN, NN, SKN;
    public static double[] PR1, PR2, PR3;
    public static double[] PR1N, PR2N, PR3N;
    public static String[] c;
    
    public Classification(double[] M, double[] N, double[] SK, 
            double[] MN, double[] NN, double[] SKN, 
            double[] PR1,double[] PR2, double[] PR3,
            double[] PR1N,double[] PR2N, double[] PR3N)
    {
        this.M = M;
        this.N = N;
        this.SK = SK;
        this.MN = MN;
        this.NN = NN;
        this.SKN = SKN;
        this.PR1 = PR1;
        this.PR2 = PR2;
        this.PR3 = PR3;
        this.PR1N = PR1N;
        this.PR2N = PR2N;
        this.PR3N = PR3N;
    }
    
    public static String[] getClassification()
    {
        c = new String[M.length];
        
        for(int i = 0; i < M.length; i++) 
        {
            if(check(new double[]{M[i],N[i],SK[i]}))
                if(M[i] == 1)
                    c[i] = ("Melanoma");
                else if (N[i] == 1)
                    c[i] = ("Nevus");
                else
                    c[i] = ("Keratosis");
            else
            {
                if(M[i] == N[i] && N[i] == SK[i] && M[i] == SK[i])
                {
                    c[i] = (getValue(0,i));
                }
                else if(M[i] == N[i])
                {
                    c[i] = (getValue(1,i));
                }
                else if(N[i] == SK[i])
                {
                    c[i] = (getValue(2,i));
                }
                else if(M[i] == SK[i])
                {
                    c[i] = (getValue(3,i));
                }
            }
        }
        
        System.out.println("Arrays: "+Arrays.toString(c));
        return c;
    }
    
    public static Boolean check(double[] cont)
    {
        int i1 = 0;
        for(int i = 0; i < cont.length; i++)
        {
            if(cont[i] == 1)
                i1++;
        }
        if(i1 == 1)
            return true;
        return false;
    }
    
    public static String getValue(int num, int loc)
    {
        int mi = 0, ni = 0, ski = 0;
        if(num == 0)
        {
                for(int i = 0; i < PR1N.length; i++)
                {   
                        if(PR1N[i] == MN[loc])
                        {
                            mi = i;
                        }
                }
                for(int i = 0; i < PR2N.length; i++)
                {   
                        if(PR2N[i] == NN[loc])
                        {
                            ni = i;
                        }
                }
                for(int i = 0; i < PR3N.length; i++)
                {   
                        if(PR3N[i] == SKN[loc])
                        {
                            ski = i;
                        }
                }
                return (classify(new double[]{PR1[mi], PR2[ni], PR3[ski]}));
        }
        
        else if(num == 1)
        {
                for(int i = 0; i < PR1N.length; i++)
                {   
                        if(PR1N[i] == MN[loc])
                        {
                            mi = i;
                        }
                }
                for(int i = 0; i < PR2N.length; i++)
                {   
                        if(PR2N[i] == NN[loc])
                        {
                            ni = i;
                        }
                }
                return (classify(new double[]{PR1[mi], PR2[ni]}));
        }
        
        else if(num == 2)
        {
                for(int i = 0; i < PR2N.length; i++)
                {   
                        if(PR2N[i] == NN[loc])
                        {
                            ni = i;
                        }
                }
                for(int i = 0; i < PR3N.length; i++)
                {   
                        if(PR3N[i] == SKN[loc])
                        {
                            ski = i;
                        }
                }
                return (classify(new double[]{PR2[ni], PR3[ski]}));
        }
        
        else if(num == 3)
        {
                for(int i = 0; i < PR1N.length; i++)
                {   
                        if(PR1N[i] == MN[loc])
                        {
                            mi = i;
                        }
                }
                for(int i = 0; i < PR3N.length; i++)
                {   
                        if(PR3N[i] == SKN[loc])
                        {
                            ski = i;
                        }
                }
                return (classify(new double[]{PR1[mi], PR3[ski]}));
        }
        
        return "";
    }
    public static String  classify(double [] cont)
    {
        double max = cont[0];
        int index = 0;
        String classification = "";
        for(int i = 0; i <cont.length; i++)
        {
            if(cont[i] < max)
            {
                max  = cont[i];
                index = i;
            }
            
            switch (index)
            {
                case 0:
                   classification = "Melanoma";
                   break;
                case 1:
                    classification = "Nevus";
                    break;
                case 2:
                    classification = "Seborrheic Keratosis";
                    break;
            }
        }
        return classification;
    }
        
}
