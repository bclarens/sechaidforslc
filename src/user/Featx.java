/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

/**
 *
 * @author Inspiron 14
 */
public class Featx {
    private int imageid;
    private String imagename;
    private String sclass;
    
    public Featx(int iid, String iname, String skinclass){
        this.imageid = iid;
        this.imagename = iname;
        this.sclass = skinclass;
    }
    
    public int getImgId(){
        return imageid;
    }
    
    public String getImgName(){
        return imagename;
    }
    
    public String getImgClass(){
        return sclass;
    }
}
