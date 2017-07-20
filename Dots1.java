/**
 * Created by dhairyathakkar on 26-03-2017.
 */
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class  Dots1 extends JFrame implements MouseMotionListener, MouseListener {

    public static final int Dot_num=10;
    public static final int Dot_gap=24;
    public static final int Dot_size=4;

    public static final int PLAYER_ONE=1;
    public static final int PLAYER_TWO=2;




    private Sprite1[] Dots1;

    private Dimension dim;

    private int clickx;
    private int clicky;

    public static final Color PLAYER_ONE_COLOR=Color.RED;
    public static final Color PLAYER_TWO_COLOR=Color.MAGENTA;

    private int mousex;
    private int mousey;

    private ConnectionSprite[] horizontalConnections;
    private ConnectionSprite[] verticalConnections;
    private int centerx;
    private int centery;

    private BoxSprite1[] boxes;
    private int side;
    private int space;

    private int activePlayer;

    public Dots1() {
        super("Connect the Dots1");
        setSize(500, 600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addMouseListener(this);
        addMouseMotionListener(this);

        loadProperties();
        loadDots1();

        startNewGame();

        setVisible(true);
    }

    private void loadProperties() {


        clickx=0;
        clicky=0;
        mousex=0;
        mousey=0;

        dim=getSize();
        centerx=dim.width/2;
        centery=(dim.height - 100) /2;

        side=Dot_num * Dot_size + (Dot_num - 1) * Dot_gap;
        space=Dot_size + Dot_gap;
    }





    private void loadDots1() {



        Dots1=new Sprite1[Dot_num * Dot_num];
        for(int rows=0; rows<Dot_num; rows++) {
            for(int cols=0; cols<Dot_num; cols++) {
                Sprite1 dot=new Sprite1();
                dot.width=Dot_size;
                dot.height=Dot_size;
                dot.x=centerx - side/2 + cols * space;
                dot.y=centery - side/2 + rows * space;
                dot.my.addPoint(-Dot_size/2, -Dot_size/2);
                dot.my.addPoint(-Dot_size/2, Dot_size/2);
                dot.my.addPoint(Dot_size/2, Dot_size/2);
                dot.my.addPoint(Dot_size/2, -Dot_size/2);
                int index=rows * Dot_num + cols;
                Dots1[index]=dot;
            }
        }
    }

    private void startNewGame() {
        activePlayer=PLAYER_ONE;
        loadConnections();
        loadBoxes();
    }
    private void loadConnections() {

        horizontalConnections=new ConnectionSprite[(Dot_num-1) * Dot_num];
        verticalConnections=new ConnectionSprite[(Dot_num-1) * Dot_num];



        for(int i=0; i<horizontalConnections.length; i++) {
            int colx=i % (Dot_num-1);
            int rowx=i / (Dot_num-1);
            int horx=centerx - side / 2 + Dot_size + colx * space;
            int hory=centery - side / 2 + rowx * space;
            horizontalConnections[i]=ConnectionSprite.createConnection(ConnectionSprite.HORZ_CONN, horx, hory);

            int coly=i % Dot_num;
            int rowy=i / Dot_num;
            int vertx=centerx - side / 2 + coly * space;
            int verty=centery - side / 2 + Dot_size + rowy * space;
            verticalConnections[i]=ConnectionSprite.createConnection(ConnectionSprite.VERT_CONN, vertx, verty);
        }
    }
    @SuppressWarnings("unused")
    private void loadBoxes() {



        boxes=new BoxSprite1[(Dot_num-1) * (Dot_num-1)];

        for(int i=0; i<boxes.length; i++) {
            int cols=i % (Dot_num-1);
            int rows=i / (Dot_num-1);

            int boxx=centerx - side / 2 + Dot_size + cols * space;
            int boxy=centery - side / 2 + Dot_size + rows * space;

            ConnectionSprite[] horConn=new ConnectionSprite[2];
            horConn[0]=horizontalConnections[i];
            horConn[1]=horizontalConnections[i + (Dot_num - 1)];

            ConnectionSprite[] verConn=new ConnectionSprite[2];
            verConn[0]=verticalConnections[i + rows];
            verConn[1]=verticalConnections[i + rows + 1];

            boxes[i]=BoxSprite1.createBox(boxx, boxy, horConn, verConn);
        }
    }
    private ConnectionSprite getConnection(int x, int y) {



        for(int i=0; i<horizontalConnections.length; i++) {
            if(horizontalConnections[i].containsPoint(x, y)) {
                return horizontalConnections[i];
            }
        }

        for(int i=0; i<verticalConnections.length; i++) {
            if(verticalConnections[i].containsPoint(x, y)) {
                return verticalConnections[i];
            }
        }

        return null;
    }

    private boolean[] getBoxStatus() {
        boolean[] status=new boolean[boxes.length];

        for(int i=0; i<status.length; i++) {
            status[i]=boxes[i].isBoxed();
        }

        return status;
    }
    private boolean makeConnection(ConnectionSprite connection) {
        boolean newBox=false;

        boolean[] boxStatusBeforeConnection=getBoxStatus();

        connection.connectionMade=true;

        boolean[] boxStatusAfterConnection=getBoxStatus();

        for(int i=0; i<boxes.length; i++) {
            if(boxStatusAfterConnection[i]!=boxStatusBeforeConnection[i]) {
                newBox=true;
                boxes[i].player=activePlayer;
            }
        }

        if(!newBox) {
            if(activePlayer==PLAYER_ONE)
                activePlayer=PLAYER_TWO;
            else
                activePlayer=PLAYER_ONE;
        }

        checkForGameOver();

        return newBox;
    }

    private int[] calculateScores() {
        int[] scores={0, 0};

        for(int i=0; i<boxes.length; i++) {
            if(boxes[i].isBoxed() && boxes[i].player!=0) {
                scores[boxes[i].player - 1]++;
            }
        }

        return scores;
    }
    private void checkForGameOver() {
        int[] scores=calculateScores();
        if((scores[0] + scores[1])==((Dot_num - 1) * (Dot_num - 1))) {
            JOptionPane.showMessageDialog(this, "Player1: " + scores[0] + "\nPlayer2: " + scores[1], "Game Over", JOptionPane.PLAIN_MESSAGE);
            startNewGame();
            repaint();
        }
    }


    private void handleClick() {
        ConnectionSprite connection=getConnection(clickx, clicky);
        if(connection==null)
            return;

        if(!connection.connectionMade) {
            makeConnection(connection);

        }

        repaint();
    }
    public void mouseMoved(MouseEvent event) {
        mousex=event.getX();
        mousey=event.getY();
        repaint();
    }
    public void mouseDragged(MouseEvent event) {
        mouseMoved(event);
    }

    public void mouseClicked(MouseEvent event) {
        clickx=event.getX();
        clicky=event.getY();

        handleClick();


    }

    public void mouseEntered(MouseEvent event) {
    }

    public void mouseExited(MouseEvent event) {
    }

    public void mousePressed(MouseEvent event) {
    }

    public void mouseReleased(MouseEvent event) {
    }

    private void paintBackground(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, dim.width, dim.height);
    }

    private void paintDots1(Graphics g) {
        for(int i=0; i<Dots1.length; i++) {
            Dots1[i].paint(g);
        }
    }

    public void paintBoxes(Graphics g) {
        for(int i=0; i<boxes.length; i++) {
            if(boxes[i].isBoxed()) {
                if(boxes[i].player==PLAYER_ONE) {
                    boxes[i].color=PLAYER_ONE_COLOR;
                } else if(boxes[i].player==PLAYER_TWO) {
                    boxes[i].color=PLAYER_TWO_COLOR;
                }
            } else {
                boxes[i].color=Color.GREEN;
            }

            boxes[i].paint(g);
        }
    }




    private void paintConnections(Graphics g) {
        for(int i=0; i<horizontalConnections.length; i++) {

            if(!horizontalConnections[i].connectionMade) {
                if(horizontalConnections[i].containsPoint(mousex, mousey)) {
                    horizontalConnections[i].color=Color.RED;
                } else {
                    horizontalConnections[i].color=Color.WHITE;
                }
            } else {
                horizontalConnections[i].color=Color.BLUE;
            }

            horizontalConnections[i].paint(g);
        }

        for(int i=0; i<verticalConnections.length; i++) {

            if(!verticalConnections[i].connectionMade) {
                if(verticalConnections[i].containsPoint(mousex, mousey)) {
                    verticalConnections[i].color=Color.RED;
                } else {
                    verticalConnections[i].color=Color.WHITE;
                }
            } else {
                verticalConnections[i].color=Color.BLUE;
            }

            verticalConnections[i].paint(g);
        }
    }
    public void paintStatus(Graphics g) {
        int[] scores=calculateScores();
        String status="It is player" + activePlayer + "'s turn";
        String status2="Player 1: " + scores[0];
        String status3="Player 2: " + scores[1];

        Color currentColor=(activePlayer==PLAYER_ONE) ? PLAYER_ONE_COLOR : PLAYER_TWO_COLOR ;
        g.setColor(currentColor);
        g.setColor(Color.BLACK);
        g.drawString(status, 10, dim.height-50);

        g.setColor(PLAYER_ONE_COLOR);
        g.drawString(status2, 10, dim.height-35);

        g.setColor(PLAYER_TWO_COLOR);
        g.drawString(status3, 10, dim.height-20);
    }
    public void update(Graphics g) {
        paint(g);
    }

    public void paint(Graphics g) {


        Image bufferImage=createImage(dim.width, dim.height);
        Graphics bufferGraphics=bufferImage.getGraphics();

        paintBackground(bufferGraphics);
        paintDots1(bufferGraphics);
        paintConnections(bufferGraphics);
        paintBoxes(bufferGraphics);
        paintStatus(bufferGraphics);

        g.drawImage(bufferImage, 0, 0, null);
    }

    public static void main(String[] args) {
        new Dots1();
    }
}
