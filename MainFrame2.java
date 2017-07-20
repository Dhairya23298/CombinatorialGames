import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by dhairyathakkar on 25-03-2017.
 */
public class MainFrame2 extends JFrame {
    private JSplitPane spRight;
    private JSplitPane spLeft;
    private JSplitPane sp;
    private CustomPanel2 toprightpanel;
    private BlocksPanel2 bottomrightpanel;
    private viPanel2 topleftpanel;
    private JPanel bottomleftpanel;

    public MainFrame2(){
        topleftpanel=new viPanel2();
        bottomleftpanel=new JPanel();
        toprightpanel=new CustomPanel2();
        bottomrightpanel=new BlocksPanel2();

        //if(toprightpanel.firstpltxt.getText()=="You") {
        toprightpanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(toprightpanel.Startwithtxt.getText().equals("Player1")) {
                    String s=bottomrightpanel.removeblocks(toprightpanel.pilenotxt,toprightpanel.noofcoinstxt,1);
                    String s1=toprightpanel.pilenotxt.getText();
                    String s2=toprightpanel.noofcoinstxt.getText();
                    if(s=="Player2") {
                        topleftpanel.addrow("Player1", s1 + "," + s2);
                    }
                    toprightpanel.Startwithtxt.setText(s);
                }
                else{
                    String s=bottomrightpanel.removeblocks(toprightpanel.pilenotxt2,toprightpanel.noofcoinstxt2,2);
                    String s1=toprightpanel.pilenotxt2.getText();
                    String s2=toprightpanel.noofcoinstxt2.getText();
                    if(s=="Player1") {
                        topleftpanel.addrow("Player2", s1 + "," + s2);
                    }
                    toprightpanel.Startwithtxt.setText(s);
                }
            }
        });
        //}

        setPreferredSize(new Dimension(1500,800));
        //getContentPane().setLayout(new BorderLayout());

        spRight=new JSplitPane(JSplitPane.VERTICAL_SPLIT,toprightpanel,bottomrightpanel);
        spRight.setDividerLocation(200);
        spRight.setContinuousLayout(true);

        spLeft=new JSplitPane(JSplitPane.VERTICAL_SPLIT,topleftpanel,bottomleftpanel);
        spLeft.setDividerLocation(500);
        spLeft.setContinuousLayout(true);

        sp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,spLeft,spRight);
        sp.setDividerLocation(200);
        sp.setContinuousLayout(false);
        sp.setOneTouchExpandable(true);

        getContentPane().add(sp,BorderLayout.CENTER);

        setJMenuBar(createmenu());
        pack();
    }

    public JMenuBar createmenu(){
        JMenuBar menubar;
        JMenu menu;
        JMenuItem opnnewgame,seehistory,howtoplay,aboutus;

        menubar=new JMenuBar();
        Font f=new Font("Calibri",Font.BOLD,16);
        UIManager.put("Menu.font",f);

        menu=new JMenu("File");
        menu.setMnemonic(KeyEvent.VK_F);
        menu.getAccessibleContext().setAccessibleDescription("File Items");
        menubar.add(menu);

        opnnewgame=new JMenuItem("New Game");
        opnnewgame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Frame noofframe[]=Frame.getFrames();
                new MainFrame().setVisible(true);
            }
        });
        menu.add(opnnewgame);

        seehistory=new JMenuItem("History");
        seehistory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    Desktop.getDesktop().open(new File("Result_NimDoublePlayer.txt"));
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        menu.add(seehistory);

        /*menu=new JMenu("Edit");
        menu.setMnemonic(KeyEvent.VK_E);
        menu.getAccessibleContext().setAccessibleDescription("Edit Items");
        menubar.add(menu);*/

        menu=new JMenu("About");
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription("About Us");
        menubar.add(menu);


        aboutus = new JMenuItem("About Us");
        aboutus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    Desktop.getDesktop().open(new File("About.txt"));
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        menu.add(aboutus);

        menu=new JMenu("Help");
        menu.setMnemonic(KeyEvent.VK_P);
        menu.getAccessibleContext().setAccessibleDescription("Help");
        menubar.add(menu);

        howtoplay=new JMenuItem("How To Play");
        howtoplay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    URL url = new URL("https://brilliant.org/wiki/nim/");
                    openWebpage(url);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        menu.add(howtoplay);


        return menubar;
    }
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame2().setVisible(true);
            }
        });
    }
    public static void openWebpage(URI uri) {
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(uri);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void openWebpage(URL url) {
        try {
            openWebpage(url.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
