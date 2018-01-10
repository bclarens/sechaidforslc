package features;

import featExtractor.Features;
import com.mathworks.toolbox.javabuilder.*;
import java.util.Arrays;
/**
 *
 * @author Inspiron 14
 */
public class extraction {
    public static void main(String[]args){
        Features feat = null;
        Object result[] = null;
        MWCharArray file = null;
        MWCharArray location = null;
        
        try{
            feat = new Features();
            file = new MWCharArray("ISIC_0000029.jpg");
            location = new MWCharArray("C:\\Users\\Inspiron 14\\Desktop\\melanoma");
            result = feat.FeatureExtractor(4, file, location);
            System.out.println(Arrays.toString(result));
        }catch(MWException e){
            e.printStackTrace();
        }finally{
            MWArray.disposeArray(file);
            MWArray.disposeArray(location);
            MWArray.disposeArray(result);
            feat.dispose();
        }
    }
}