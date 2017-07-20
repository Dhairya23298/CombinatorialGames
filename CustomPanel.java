import sun.text.normalizer.CharTrie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.IllegalFormatException;
import java.util.Random;

/**
 * Created by dhairyathakkar on 13-02-2017.
 */
public class CustomPanel extends JPanel{
    public JLabel heading;
    public JLabel FirstPlayer ;
    public JTextField firstpltxt;
    public JLabel pileno;
    public JTextField pilenotxt;
    public JLabel noofcoins;
    public JTextField noofcoinstxt;
    public JButton submit;
    private int pilen;
    private int noofc;



    ImageIcon nim= new ImageIcon("E:\\Dhairya\\Sem 4\\MiniProject\\Nim+5.png");
    public CustomPanel(){
        heading=new JLabel();
        //heading.setText("Welcome To The NIM Game !! ");
        GridBagLayout g =new GridBagLayout();
        setLayout(g);
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        heading.setFont(new Font("Calibri",Font.BOLD+Font.ITALIC,30));


        GridBagConstraints gc=new GridBagConstraints();
        gc.ipady=40;
        gc.gridwidth=4;
        gc.gridx=0;
        gc.gridy=0;
        add(heading,gc);


        FirstPlayer=new JLabel();
        FirstPlayer.setText("Current Player? : ");
        FirstPlayer.setFont(new Font("Calibri",Font.BOLD+Font.ITALIC,14));
        gc.fill=GridBagConstraints.HORIZONTAL;
        gc.ipady=0;
        gc.gridwidth=2;
        gc.gridx=0;
        gc.gridy=1;
        add(FirstPlayer,gc);


        firstpltxt=new JTextField();
        Random r=new Random();
        int result=r.nextInt(2);
        if(result==0){
            firstpltxt.setText("You");
        }
        else if(result==1) {
            firstpltxt.setText("Machine");
        }
        gc.gridx=2;
        gc.gridy=1;
        firstpltxt.setEditable(false);
        add(firstpltxt,gc);

        pileno = new JLabel();
        pileno.setFont(new Font("Calibri",Font.BOLD+Font.ITALIC,14));
        pileno.setText("Enter Pile no :");
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.ipady = 0;
        gc.gridwidth = 2;
        gc.gridx = 0;
        gc.gridy = 2;
        add(pileno, gc);

        pilenotxt = new JTextField();
        gc.ipady = 0;
        gc.gridx = 2;
        gc.gridy = 2;
        add(pilenotxt, gc);

        noofcoins = new JLabel();
        noofcoins.setFont(new Font("Calibri",Font.BOLD+Font.ITALIC,14));
        noofcoins.setText("Enter the no of coins? ");
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.ipady = 0;
        gc.gridwidth = 2;
        gc.gridx = 0;
        gc.gridy = 3;
        add(noofcoins, gc);

        noofcoinstxt = new JTextField();
        gc.gridx = 2;
        gc.gridy = 3;
        add(noofcoinstxt, gc);


            gc.gridx=3;
            gc.gridwidth=1;
            gc.gridy=7;

            submit=new JButton("Make The Move");
            add(submit,gc);
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(nim.getImage(),0,0,null);
    }

    /*public void setButtonListener(ButtonListener listener){
        this.b=listener;
    }*/

    public String getPilen() {
        return pilenotxt.getText();
    }



    public String getNoofc() {
        return noofcoinstxt.getText();
    }

    public void addActionListener(ActionListener a){
        submit.addActionListener(a);
    }

    public String getSource(){
        return submit.getActionCommand();
    }



    /*@Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource()==submit){
            try{
                pilen=Integer.parseInt(pilenotxt.getText());
                noofc=Integer.parseInt(noofcoinstxt.getText());
            }
            catch (Exception e){
                JOptionPane.showMessageDialog(this,"Invalid Input");
            }
        }
    }*/

}
