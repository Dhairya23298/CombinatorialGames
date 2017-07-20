/**
 * Created by dhairyathakkar on 27-03-2017.
 */
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class ImagePanel extends JFrame {
    JPanel contentPane;
    JLabel imageLabel = new JLabel();

    public ImagePanel() {
        try {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            contentPane = (JPanel) getContentPane();
            contentPane.setLayout(new BorderLayout());
            setSize(new Dimension(1500, 800));
            //setTitle("Your Job Crashed!");
            // add the header label
            //headerLabel.setFont(new java.awt.Font("Comic Sans MS", Font.BOLD, 16));
            //headerLabel.setText("   Your job crashed during the save process!");
            //contentPane.add(headerLabel, java.awt.BorderLayout.NORTH);
            // add the image label
            ImageIcon ii = new ImageIcon(this.getClass().getResource(
                    "LostGifnew.gif"));
            imageLabel.setIcon(ii);
            contentPane.add(imageLabel, java.awt.BorderLayout.CENTER);
            // show it
            this.setLocationRelativeTo(null);
            this.setVisible(true);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    public static void main(String[] args){
        new ImagePanel();
    }

}
