/*
 * MATLAB Compiler: 6.4 (R2017a)
 * Date: Tue Jan 02 17:14:19 2018
 * Arguments: 
 * "-B""macro_default""-W""java:featExtractor,Features""-T""link:lib""-d""C:\\Users\\Inspiron 
 * 14\\Desktop\\hibi\\featExtractor\\for_testing""class{Features:C:\\Users\\Inspiron 
 * 14\\Desktop\\shit\\FeatureExtractor.m}"
 */

package featExtractor;

import com.mathworks.toolbox.javabuilder.*;
import com.mathworks.toolbox.javabuilder.internal.*;

/**
 * <i>INTERNAL USE ONLY</i>
 */
public class FeatExtractorMCRFactory
{
   
    
    /** Component's uuid */
    private static final String sComponentId = "featExtracto_188B49C7539CE4A419B12F3172E399F1";
    
    /** Component name */
    private static final String sComponentName = "featExtractor";
    
   
    /** Pointer to default component options */
    private static final MWComponentOptions sDefaultComponentOptions = 
        new MWComponentOptions(
            MWCtfExtractLocation.EXTRACT_TO_CACHE, 
            new MWCtfClassLoaderSource(FeatExtractorMCRFactory.class)
        );
    
    
    private FeatExtractorMCRFactory()
    {
        // Never called.
    }
    
    public static MWMCR newInstance(MWComponentOptions componentOptions) throws MWException
    {
        if (null == componentOptions.getCtfSource()) {
            componentOptions = new MWComponentOptions(componentOptions);
            componentOptions.setCtfSource(sDefaultComponentOptions.getCtfSource());
        }
        return MWMCR.newInstance(
            componentOptions, 
            FeatExtractorMCRFactory.class, 
            sComponentName, 
            sComponentId,
            new int[]{9,2,0}
        );
    }
    
    public static MWMCR newInstance() throws MWException
    {
        return newInstance(sDefaultComponentOptions);
    }
}
