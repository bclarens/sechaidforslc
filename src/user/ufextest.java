/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;
import java.util.Arrays;
import utilities.extract_feat;
/**
 *
 * @author Inspiron 14
 */
public class ufextest {
    public static void main(String[]args){
        extract_feat extract = new extract_feat();
        String res = extract.retrieve_feat("ISIC_0010389.jpg", "E:\\THESIS\\Dataset - resized\\Seborrheic Keratosis - Training (7)", 0);
        System.out.println(res);
    }
}
