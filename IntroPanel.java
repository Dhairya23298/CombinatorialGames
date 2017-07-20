import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by dhairyathakkar on 05-03-2017.
 */
public class IntroPanel extends JPanel {
    public JLabel HeadingLabel;
    public JLabel SinglePlayer;
    public JLabel TwoPlayer;
    public JFrame myframe;
    public IntroPanel(){
        setBackground(new Color(0,102,153));
        HeadingLabel=new JLabel();
        GridBagLayout g =new GridBagLayout();
        setLayout(g);
        HeadingLabel.setText("Welcome To The Game Of NIM !! ");
        //HeadingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        HeadingLabel.setFont(new Font("AR CHRISTY",Font.BOLD+Font.ITALIC,50));
        HeadingLabel.setForeground(Color.white);

        GridBagConstraints gc=new GridBagConstraints();
        //gc.ipady=40;
        //gc.weighty=1;
        gc.gridwidth=4;
        gc.gridx=0;
        gc.gridy=0;
        add(HeadingLabel,gc);

        gc.gridheight=30;
        gc.weighty=30;
        gc.gridy=1;
        add(new JLabel(" "),gc);

        SinglePlayer=new JLabel();
        SinglePlayer.setText("Single Player Game");
        SinglePlayer.setFont(new Font("AR CHRISTY",Font.PLAIN,40));
        Font f=SinglePlayer.getFont();
        SinglePlayer.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                new MainFrame().setVisible(true);
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
                SinglePlayer.setOpaque(true);
                SinglePlayer.setBackground(new Color(0,100,135));
                SinglePlayer.setFont(new Font("AR CHRISTY",Font.PLAIN,50));
                SinglePlayer.setForeground(new Color(230,230,255));
                SinglePlayer.repaint();
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
                SinglePlayer.setOpaque(true);
                SinglePlayer.setForeground(Color.white);
                SinglePlayer.setFont(f);
                SinglePlayer.setBackground(new Color(0,102,153));
                SinglePlayer.repaint();
            }
        });
        SinglePlayer.setForeground(new Color(195,195,195));


        //gc.weighty=5;
        //gc.insets=new Insets(10,10,10,10);
        gc.gridwidth=4;
        gc.gridheight=1;
        gc.weighty=1;
        gc.gridx=0;
        gc.gridy=2;
        add(SinglePlayer,gc);

        TwoPlayer=new JLabel();
        TwoPlayer.setText("Two Player Game");
        TwoPlayer.setFont(f);
        TwoPlayer.setForeground(Color.white);
        TwoPlayer.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                new MainFrame2().setVisible(true);
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
                TwoPlayer.setOpaque(true);
                TwoPlayer.setBackground(new Color(0,100,135));
                TwoPlayer.setFont(new Font("AR CHRISTY",Font.PLAIN,50));
                TwoPlayer.setForeground(new Color(230,230,255));
                TwoPlayer.repaint();
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
                TwoPlayer.setOpaque(true);
                TwoPlayer.setForeground(Color.white);
                TwoPlayer.setFont(f);
                TwoPlayer.setBackground(new Color(0,102,153));
                TwoPlayer.repaint();
            }
        });
        SinglePlayer.setForeground(new Color(195,195,195));

        //gc.weighty=gc.weighty;
        gc.gridwidth=4;
        gc.weighty=1;
        //gc.gridheight=1;
        gc.gridx=0;
        gc.gridy=3;
        add(TwoPlayer,gc);

        gc.gridheight=GridBagConstraints.REMAINDER;
        //gc.weighty=1;
        gc.gridy=4;
        //gc.fill=GridBagConstraints.VERTICAL;
        add(new JLabel(" "),gc);

    }
}
