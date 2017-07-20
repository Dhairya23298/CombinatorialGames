import javax.swing.*;
import java.awt.*;

/**
 * Created by dhairyathakkar on 02-05-2017.
 */
public class ZMIntroWindowFrame extends JFrame{
    public ZMIntroPanel mainpanel;
    public  ZMIntroWindowFrame(){
        mainpanel=new ZMIntroPanel();
        setPreferredSize(new Dimension(1500,800));
        getContentPane().add(mainpanel);
        pack();
    }
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ZMIntroWindowFrame().setVisible(true);
            }
        });
    }
}
