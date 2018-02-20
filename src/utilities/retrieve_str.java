package utilities;
/*
    format absolute path for feature extraction
*/
public class retrieve_str {
    public String feat_folderpath(String fullpath){
         String foldername = fullpath.substring(0, fullpath.lastIndexOf('\\'));
         return foldername;
    }
    
    public String feat_imgname(String path){
        String imgname = path.substring(path.lastIndexOf('\\')+1, path.length());
        return imgname;
    }
    
    public String get_name(String path){
        String imgname = path.substring(path.lastIndexOf('\\')+1, path.length());
        String imgnamenoext = imgname.substring(0, imgname.lastIndexOf('.'));
        return imgnamenoext;
    }
}
