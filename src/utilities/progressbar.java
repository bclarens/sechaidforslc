package utilities;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class progressbar extends JFrame{
    JProgressBar pb = new JProgressBar();
    
    public progressbar(){
        pb =new JProgressBar();
        pb.setBounds(9,26,352,14);
        pb.setVisible(true);
        pb.setIndeterminate(true);
//        pb.setStringPainted(true);
        this.add(pb);
        this.setSize(385,115);
        this.setLayout(null);
        this.setTitle("Inserting images to database...");
    }

    
    public static void main(String[]args){
        int i = 0;
        progressbar pd = new progressbar();
        pd.setVisible(true);
    }
}
