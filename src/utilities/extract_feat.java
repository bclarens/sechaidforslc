package utilities;
import com.mathworks.toolbox.javabuilder.MWArray;
import com.mathworks.toolbox.javabuilder.MWCharArray;
import com.mathworks.toolbox.javabuilder.MWException;
import java.util.Arrays;

import FeatureExtractor.featureclass;
/*
    access matlab functions through a jar file
    extract features using the parameter filename, filedir, skin group
*/
public class extract_feat {
    public String retrieve_feat(String fname, String loc, int grp){
        featureclass feat = null;
        Object result[] = null;
        MWCharArray file = null;
        MWCharArray location = null;
        MWCharArray group = null;
        
        try{
            feat = new featureclass();
            file = new MWCharArray(fname);
            location = new MWCharArray(loc);
            group = new MWCharArray(grp);
            result = feat.FeatureExtractor(8, file, location, grp);
            String fin = Arrays.toString(result);
            return fin;
        }catch(MWException e){
            e.printStackTrace();
        }finally{
            MWArray.disposeArray(file);
            MWArray.disposeArray(location);
            MWArray.disposeArray(result);
            feat.dispose();
        }
        return "";
    }
}
