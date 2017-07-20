import javax.swing.*;
import java.awt.*;

/**
 * Created by dhairyathakkar on 25-03-2017.
 */
public class BlocksPanel2 extends JPanel{
    private ImageIcon simpleblock=new ImageIcon("E:\\Dhairya\\Sem 4\\MiniProject\\Blocksimple.png");
    private ImageIcon blocks[]=new ImageIcon[7];
    private ImageIcon blank=new ImageIcon("E:\\Dhairya\\Sem 4\\MiniProject\\Blank.png");
    private JLabel labels[][]=new JLabel[4][7];
    private JLabel labels2[][]=new JLabel[4][7];
    int midl=3,midg=3;
    public int noofcleft[]=new int[4];

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

    public BlocksPanel2(){
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

    public String removeblocks(JTextField p1,JTextField n1,int f){
        String p=p1.getText();
        String n=n1.getText();
        int pilen,noofc;
        try {
            pilen = Integer.parseInt(p);
            noofc = Integer.parseInt(n);
            pilen--;
            int mid=3;
            int maxcoins = noofcleft[pilen];
            if (pilen > 3 || noofc > maxcoins) {
                JOptionPane.showMessageDialog(this, "Invalid Input");
                if(f==1){
                    return "Player1";
                }
                else{
                    return "Player2";
                }
            }
            mid=mid+pilen-noofcleft[pilen]+1;
            for (int i = mid; i < mid+noofc ; i++) {
                System.out.println(pilen+","+i);
                labels[pilen][i].setBorder(null);
                labels[pilen][i].setIcon(blank);
                noofcleft[pilen]--;
                validate();
            }
            if(isempty(noofcleft)){
                if(f==1) {
                    JOptionPane.showMessageDialog(this, "Player1 Won !!");
                }
                else{
                    JOptionPane.showMessageDialog(this, "Player2 Won !!");
                }
            }
            if(f==1){
                return "Player2";
            }
            else{
                return "Player1";
            }
            /*p1.setEditable(false);
            n1.setEditable(false);
            p1.setText("");
            n1.setText("");*/
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(this,"Invalid Input");
            if(f==1){
                return "Player1";
            }
            else{
                return "Player2";
            }
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
    /*public void machinemove(JTextField p,JTextField n){
        int x=xor();
        if(x==0){
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
        if(isempty(noofcleft)){
            JOptionPane.showMessageDialog(this,"You Lost !!");
        }
        p.setEditable(true);
        n.setEditable(true);
        p.setText("");
        n.setText("");

    }
    public int xor(){
        int x=noofcleft[0];
        for (int i = 1; i < noofcleft.length; i++) {
            x=x^noofcleft[i];
        }
        return x;
    }

    public void setButtonListener(ButtonListener listener){
        this.b=listener;
    }*/
}
