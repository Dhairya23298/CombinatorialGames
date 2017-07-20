import javax.swing.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
/**
 * Created by dhairyathakkar on 08-04-2017.
 */
public class ZMBlocksPanel extends JPanel{
    private ImageIcon simpleblock=new ImageIcon("E:\\Dhairya\\Sem 4\\MiniProject\\Blocksimple.png");
    private ImageIcon blocks[]=new ImageIcon[7];
    private ImageIcon blank=new ImageIcon("E:\\Dhairya\\Sem 4\\MiniProject\\Blank.png");
    private JLabel labels[][]=new JLabel[4][7];
    private JLabel labels2[][]=new JLabel[4][7];
    int midl=3,midg=3;
    public int noofcleft[]=new int[4];
    public int zmflag[]=new int[4];

    public JLabel[][] getLabels() {
        return labels;
    }


    public ImageIcon getSimpleblock() {
        return simpleblock;
    }

    public ImageIcon[] getBlocks() {
        return blocks;
    }

    public ImageIcon getBlank() {
        return blank;
    }

    public ZMBlocksPanel(){
        for (int i = 0; i < 4; i++) {
            noofcleft[i]=2*i+1;
        }
        setLayout(new GridLayout(4,7));
        int f;
        for (int i = 0; i < 7 ; i++) {
            f=i+1;
            blocks[i]=new ImageIcon("E:\\Dhairya\\Sem 4\\MiniProject\\Block_"+f+".png");
        }

        for(int i=0;i<4;i++){
            for(int j=0;j<7;j++){
                if(j>=midl && j<=midg) {
                    labels[i][j] = new JLabel(blocks[j-midl]);
                    labels[i][j].setBorder(BorderFactory.createEtchedBorder());
                    add(labels[i][j]);
                }
                else{
                    labels[i][j] = new JLabel(blank);
                    setBackground(new Color(0xFFC90D));
                    //labels[i][j].setBorder(BorderFactory.createEtchedBorder());
                    add(labels[i][j]);
                }
            }
            midl--;
            midg++;
        }
    }

    public String removeblocks(String p,String n,JTextField p1,JTextField n1){
        int pilen,noofc;
        try {
            pilen = Integer.parseInt(p);
            noofc = Integer.parseInt(n);
            pilen--;
            int mid=3;
            int maxcoins = noofcleft[pilen];
            if (pilen > 3 || noofc > maxcoins ) {
                JOptionPane.showMessageDialog(this, "Invalid Input I am in ZM");
                return "You";
            }
            else if(noofc==0 && zmflag[pilen]==1){
                JOptionPane.showMessageDialog(this, "Invalid Input I am in ZM");
                return "You";
            }
            if(noofc==0){
                zmflag[pilen]=1;
                return "Machine";
            }
            mid=mid+pilen-noofcleft[pilen]+1;
            for (int i = mid; i < mid+noofc ; i++) {
                System.out.println(pilen+","+i);
                labels[pilen][i].setBorder(null);
                labels[pilen][i].setIcon(blank);
                noofcleft[pilen]--;
                validate();
            }
            for (int i = 0; i < noofcleft.length; i++) {
                System.out.println(noofcleft[i]+" ");
            }
            if(isempty(noofcleft)){
                JOptionPane.showMessageDialog(this,"You Won !!");
            }
            /*p1.setEditable(false);
            n1.setEditable(false);
            p1.setText("");
            n1.setText("");*/
            return "Machine";
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(this,"Invalid Input");
            return "You";
        }
    }
    public boolean isempty(int a[]){
        for (int i = 0; i < a.length; i++) {
            if(a[i]!=0){
                return false;
            }
        }
        return true;
    }
    public void machinemove(JTextField p,JTextField n){
        int x=xor();
        System.out.println("X is "+x);
        if(x==-1 && isempty(noofcleft)){
            JOptionPane.showMessageDialog(this,"You Lost !!");
            return;
        }
        int max=maxnc();
        if(x>7) {
            x -= 8;
        }
        else if(x>max){
            x=max;
        }
        if(x==0 || x==-1){
            int f1=0;
            for (int i = 0; i < noofcleft.length; i++) {
                if(noofcleft[i]!=0 && zmflag[i]==0){
                    int y=i+1;
                    p.setText(""+y);
                    n.setText(""+0);
                    Object row[]={"Machine",p.getText()+","+n.getText()};
                    validate();
                    f1=1;
                    zmflag[i]=1;
                    break;
                }
            }
            if(f1==0){
                for (int i = 0; i < noofcleft.length; i++) {
                    if(noofcleft[i]!=0){
                        int mid=3;
                        mid=mid+i-noofcleft[i]+1;
                        labels[i][mid].setBorder(null);
                        labels[i][mid].setIcon(blank);
                        noofcleft[i]--;
                        int f=i+1;
                        p.setText(""+f);
                        n.setText(""+1);
                        Object row[]={"Machine",p.getText()+","+n.getText()};
                        validate();
                        break;
                    }
                }
            }
        }
        else {
            for (int i = 0; i < noofcleft.length ; i++) {
                if(noofcleft[i]>=x){
                    int mid=3;
                    mid=mid+i-noofcleft[i]+1;
                    for (int j = mid; j <mid+x ; j++) {
                        labels[i][j].setBorder(null);
                        labels[i][j].setIcon(blank);
                        noofcleft[i]--;
                        validate();
                    }
                    int f=i+1;
                    p.setText(""+f);
                    n.setText(""+x);
                    break;
                }
            }
        }
        for (int i = 0; i < noofcleft.length; i++) {
            System.out.println(noofcleft[i]+" ");
        }
        if(isempty(noofcleft)){
            JOptionPane.showMessageDialog(this,"You Lost !!");
            //gifadder();
        }
        /*p.setEditable(true);
        n.setEditable(true);
        p.setText("");
        n.setText("");*/
    }
    public static void gifadder(){
        try {
            URL url = new URL("");
            Icon icon = new ImageIcon(url);
            JLabel label = new JLabel(icon);

            JFrame f = new JFrame("Animation");
            f.getContentPane().add(label);
            f.setPreferredSize(new Dimension(1500,800));
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.pack();
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public int xor(){
        int x=-1;
        int h=0;
        for(int i=0;i<noofcleft.length;i++){
            if(noofcleft[i]!=0){
                if(noofcleft[i]%2==0){
                    x = noofcleft[i]-1;
                    h=i+1;
                    //System.out.println("h is "+h);
                    break;
                }
                else{
                    x = noofcleft[i]+1;
                    h=i+1;
                    //System.out.println("h is "+h);
                    break;
                }
            }
        }
        if(x==-1){
            return -1;
        }
        for (int i = h; i < noofcleft.length; i++) {
            if(noofcleft[i]!=0 && noofcleft[i]%2==0){
                x=x^(noofcleft[i]-1);
                //System.out.println("x in "+i+" is "+x);
            }
            else if(noofcleft[i]!=0){
                x=x^(noofcleft[i]+1);
                //System.out.println("x in "+i+" is "+x);
            }
        }
        return x;
    }
    public int maxnc(){
        int max = noofcleft[0];
        for (int i = 1; i <noofcleft.length ; i++) {
            if(noofcleft[i]>max)
                max=noofcleft[i];
        }
        return max;
    }

    /*public void setButtonListener(ButtonListener listener){
        this.b=listener;
    }*/
}
