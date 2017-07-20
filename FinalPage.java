/**
 * Created by dhairyathakkar on 02-05-2017.
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FinalPage {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FinalPage window = new FinalPage();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public FinalPage() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(SystemColor.activeCaption);
        frame.setBounds(100, 100, 588, 482);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNimGame = new JLabel("Nim Game");
        lblNimGame.setForeground(Color.WHITE);
        lblNimGame.setBounds(25, 122, 119, 35);
        lblNimGame.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                new IntroWindowFrame().setVisible(true);

            }
        });
        frame.getContentPane().add(lblNimGame);

        JLabel lblZeroMoveNim = new JLabel("Zero Move Nim");
        lblZeroMoveNim.setForeground(Color.WHITE);
        lblZeroMoveNim.setBounds(25, 149, 131, 35);
        lblZeroMoveNim.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                new ZMIntroWindowFrame().setVisible(true);

            }
        });
        frame.getContentPane().add(lblZeroMoveNim);

        JLabel lblNewLabel = new JLabel("Dots");
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setBounds(25, 184, 98, 29);
        frame.getContentPane().add(lblNewLabel);
        lblNewLabel.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                new Dots1().setVisible(true);

            }
        });

        JLabel lblGameFolderOf = new JLabel("Game Folder Of Strategy Games");
        lblGameFolderOf.setFont(new Font("Tahoma", Font.BOLD, 22));
        lblGameFolderOf.setForeground(Color.WHITE);
        lblGameFolderOf.setBounds(90, 27, 403, 65);
        frame.getContentPane().add(lblGameFolderOf);
    }
}

