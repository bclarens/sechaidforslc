package admin;

public class Feat {
    private int imageid;
    private String imagename;
    private int featA;
    private int featB;
    private int featC;
    private int featD1;
    private int featD2;
    private String atype;
    private String passwd;
    
    public Feat(int iid, String iname, int va, int vb, int vc, int vd1, int vd2){
        this.imageid = iid;
        this.imagename = iname;
        this.featA = va;
        this.featB = vb;
        this.featC = vc;
        this.featD1 = vd1;
        this.featD2 = vd2;
    }
    
    public int getImgId(){
        return imageid;
    }
    
    public String getImgName(){
        return imagename;
    }
    
    public int getA(){
        return featA;
    }
    
    public int getB(){
        return featB;
    }
    
    public int getC(){
        return featC;
    }
    
    public int getD1(){
        return featD1;
    }
    
    public int getD2(){
        return featD2;
    }
}
