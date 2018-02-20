package utilities;

public class combo {
    public int selectcombo_dprep(String stritem){
        if(stritem.equals("Melanoma Dataset (Training)")){
            return 0;
        }else if(stritem.equals("Nevus Dataset (Training)")){
            return 1;
        }else if(stritem.equals("Seborrheic Keratosis Dataset (Training)")){
            return 2;
        }else if(stritem.equals("Melanoma Dataset (Testing)")){
            return 3;
        }else if(stritem.equals("Nevus Dataset (Testing)")){
            return 4;
        }else if(stritem.equals("Seborrheic Keratosis Dataset (Testing)")){
            return 5;
        }
        return -1;
    }
    
    public int selectcombo_stest(String strcom){
        if(strcom.equals("Accuracy Testing")){
            return 0;
        }else if(strcom.equals("Sucess Rate Testing")){
            return 1;
        }else if(strcom.equals("Hypothesis Testing")){
            return 2;
        }
        return -1;
    }
    
    public int selectusercombo(String choice){
        if(choice.equals("Log Out")){
            return 0;
        }
        return -1;
    }
    
    public int selectcombo_strain(String stritem){
        if(stritem.equals("Melanoma Dataset (Diameter)")){
            return 0;
        }else if(stritem.equals("Nevus Dataset (Diameter)")){
            return 1;
        }else if(stritem.equals("Seborrheic Keratosis Dataset (Diameter)")){
            return 2;
        }else if(stritem.equals("Melanoma Dataset (Dermoscopic Structure)")){
            return 3;
        }else if(stritem.equals("Nevus Dataset (Dermoscopic Structure)")){
            return 4;
        }else if(stritem.equals("Seborrheic Keratosis Dataset (Dermoscopic Structure)")){
            return 5;
        }
        return -1;
    }
    
    public String getcsvname(int select){
        switch(select){
            case 0: //Melanoma Dataset (Training)
                return "Feat_TrainM.csv";
            case 1: //Nevus Dataset (Training)
                return "Feat_TrainN.csv";
            case 2: //Seborrheic Keratosis Dataset (Training)
                return "Feat_TrainSK.csv";
            case 3: //Melanoma Dataset (Testing)
                return "Feat_TestM.csv";
            case 4: //Nevus Dataset (Testing)
                return "Feat_TestN.csv";
            case 5: //Seborrheic Keratosis Dataset (Testing)
                return "Feat_TestSK.csv";
        }
        return "";
    }
}
