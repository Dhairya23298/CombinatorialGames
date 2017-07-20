/**
 * Created by dhairyathakkar on 26-03-2017.
 */
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public  class ConnectionSprite extends Sprite1 {



    public static final int HORZ_CONN=1;
    public static final int VERT_CONN=2;

    boolean connectionMade;

    public ConnectionSprite() {

        super();

        connectionMade=false;
        color=Color.CYAN;
    }
    public static ConnectionSprite createConnection(int type, int x, int y) {
        ConnectionSprite conn=new ConnectionSprite();

        if(type==HORZ_CONN) {
            conn.width=Dots1.Dot_gap;
            conn.height=Dots1.Dot_size;
        } else if(type==VERT_CONN) {
            conn.width=Dots1.Dot_size;
            conn.height=Dots1.Dot_gap;
        } else {
            return null;
        }

        conn.x=x;
        conn.y=y;
        conn.my.addPoint(-conn.width/2, +conn.height/2);
        conn.my.addPoint(-conn.width/2, -conn.height/2);
        conn.my.addPoint(conn.width/2, -conn.height/2);
        conn.my.addPoint(conn.width/2, conn.height/2);




        return conn;
    }

}
