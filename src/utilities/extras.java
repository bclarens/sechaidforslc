/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

/**
 *
 * @author Inspiron 14
 */
public class extras {
    public int selectcombo(String stritem){
        if(stritem.equals("Melanoma Dataset")){
            return 0;
        }else if(stritem.equals("Nevus Dataset")){
            return 1;
        }else if(stritem.equals("Seborrheic Keratosis Dataset")){
            return 2;
        }
        return -1;
    }
}
