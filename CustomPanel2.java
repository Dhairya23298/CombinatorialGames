import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Created by dhairyathakkar on 25-03-2017.
 */
public class CustomPanel2 extends JPanel{
    public JLabel heading;
    public JLabel FirstPlayer ;
    public JLabel SecondPlayer;
    public JLabel Startwith;
    public JTextField Startwithtxt;
    public JTextField firstpltxt;
    public JTextField secondpltxt;
    public JLabel pileno;
    public JLabel pileno2;
    public JTextField pilenotxt;
    public JTextField pilenotxt2;
    public JLabel noofcoins;
    public JLabel noofcoins2;
    public JTextField noofcoinstxt;
    public JTextField noofcoinstxt2;
    public JButton submit;
    public JButton submit2;
    private int pilen;
    private int noofc;



    ImageIcon nim= new ImageIcon("E:\\Dhairya\\Sem 4\\MiniProject\\Nim+5.png");
    public CustomPanel2(){
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
        FirstPlayer.setText("First Player? : ");
        FirstPlayer.setFont(new Font("Calibri",Font.BOLD+Font.ITALIC,14));
        gc.fill=GridBagConstraints.HORIZONTAL;
        gc.ipady=0;
        gc.gridwidth=2;
        gc.gridx=0;
        gc.gridy=1;
        gc.insets=new Insets(0,20,0,20);
        add(FirstPlayer,gc);


        firstpltxt=new JTextField();
        firstpltxt.setText("Player1");
        gc.gridx=2;
        gc.gridy=1;
        firstpltxt.setEditable(false);
        add(firstpltxt,gc);

        gc.gridwidth=3;
        gc.gridx=3;
        gc.gridy=2;
        add(new JLabel(""),gc);

        Startwith=new JLabel();
        Startwith.setText("Start with :");
        Startwith.setBorder(new EmptyBorder(0,10,0,0));
        Startwith.setFont(new Font("Calibri",Font.BOLD+Font.ITALIC,14));
        gc.gridwidth=1;
        gc.gridx=7;
        gc.gridy=2;
        add(Startwith,gc);

        Startwithtxt=new JTextField();
        Random r=new Random();
        int result=r.nextInt(2);
        if(result==0){
            Startwithtxt.setText("Player1");
        }
        else if(result==1) {
            Startwithtxt.setText("Player2");
        }
        gc.gridx=8;
        gc.gridy=2;
        Startwithtxt.setEditable(false);
        add(Startwithtxt,gc);

        SecondPlayer=new JLabel();
        SecondPlayer.setText("Second Player? : ");
        SecondPlayer.setBorder(new EmptyBorder(0,10,0,0));
        SecondPlayer.setFont(new Font("Calibri",Font.BOLD+Font.ITALIC,14));
        gc.gridwidth=1;
        gc.ipady=0;
        gc.gridx=10;
        gc.gridy=1;
        add(SecondPlayer,gc);

        secondpltxt=new JTextField();
        secondpltxt.setText("Player2");
        gc.gridx=11;
        gc.gridy=1;
        secondpltxt.setEditable(false);
        add(secondpltxt,gc);


        gc.gridwidth=3;
        gc.gridx=3;
        gc.gridy=2;
        add(new JLabel(""),gc);


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

        pileno2 = new JLabel();
        pileno2.setFont(new Font("Calibri",Font.BOLD+Font.ITALIC,14));
        pileno2.setText("Enter Pile no:");
        gc.ipady = 0;
        gc.gridwidth = 1;
        gc.gridx = 10;
        gc.gridy = 2;
        add(pileno2, gc);

        pilenotxt2 = new JTextField();
        gc.ipady = 0;
        gc.gridx = 11;
        gc.gridy = 2;
        add(pilenotxt2, gc);

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

        noofcoins2 = new JLabel();
        noofcoins2.setFont(new Font("Calibri",Font.BOLD+Font.ITALIC,14));
        noofcoins2.setText("Enter the no of coins? ");
        gc.ipady = 0;
        gc.gridwidth = 1;
        gc.gridx = 10;
        gc.gridy = 3;
        add(noofcoins2, gc);

        noofcoinstxt2 = new JTextField();
        gc.gridx = 11;
        gc.gridy = 3;
        add(noofcoinstxt2, gc);


        gc.gridx=3;
        gc.gridwidth=1;
        gc.gridy=7;
        submit=new JButton("Make The Move");
        add(submit,gc);

        gc.gridx=11;
        gc.gridwidth=1;
        gc.gridy=7;
        submit2=new JButton("Make The Move");
        add(submit2,gc);

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
        submit2.addActionListener(a);
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
