import javax.swing.*;
import java.awt.*;

/**
 * Created by dhairyathakkar on 04-03-2017.
 */
public class IntroWindowFrame extends JFrame{
    public IntroPanel mainpanel;
    public  IntroWindowFrame(){
        mainpanel=new IntroPanel();
        setPreferredSize(new Dimension(1500,800));
        getContentPane().add(mainpanel);
        pack();
    }
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new IntroWindowFrame().setVisible(true);
            }
        });
    }
}
