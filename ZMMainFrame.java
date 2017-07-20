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
 * Created by dhairyathakkar on 23-04-2017.
 */
public class ZMMainFrame extends JFrame{
    private JSplitPane spRight;
    private JSplitPane spLeft;
    private JSplitPane sp;
    private ZMCustomPanel toprightpanel;
    private ZMBlocksPanel bottomrightpanel;
    private viPanel topleftpanel;
    private JPanel bottomleftpanel;

    public ZMMainFrame(){
        topleftpanel=new viPanel();
        bottomleftpanel=new JPanel();
        toprightpanel=new ZMCustomPanel();
        bottomrightpanel=new ZMBlocksPanel();

        //if(toprightpanel.firstpltxt.getText()=="You") {
        toprightpanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(toprightpanel.firstpltxt.getText().equals("You")) {
                    String s=bottomrightpanel.removeblocks(toprightpanel.getPilen(), toprightpanel.getNoofc(),toprightpanel.pilenotxt,toprightpanel.noofcoinstxt);
                    String s1=toprightpanel.getPilen();
                    String s2=toprightpanel.getNoofc();
                    if(s=="Machine") {
                        topleftpanel.addrow("You", s1 + "," + s2);
                    }
                    toprightpanel.firstpltxt.setText(s);
                }
                else{
                    bottomrightpanel.machinemove(toprightpanel.pilenotxt,toprightpanel.noofcoinstxt);
                    String s1=toprightpanel.getPilen();
                    String s2=toprightpanel.getNoofc();
                    topleftpanel.addrow("Machine",s1+","+s2);
                    toprightpanel.firstpltxt.setText("You");
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
                    Desktop.getDesktop().open(new File("Result_ZMNimSinglePlayer.txt"));
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
                new MainFrame().setVisible(true);
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
