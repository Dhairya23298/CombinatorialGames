/**
 * Created by dhairyathakkar on 27-03-2017.
 */
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class BoxSprite1 extends Sprite1 {


    ConnectionSprite[] horizontalConnections;
    ConnectionSprite[] verticalConnections;

    int player;

    public BoxSprite1() {
        super();

        color=Color.WHITE;

        horizontalConnections=new ConnectionSprite[2];
        verticalConnections=new ConnectionSprite[2];

        width=Dots1.Dot_gap;
        height=Dots1.Dot_gap;

        my.addPoint(-width/2, -height/2);
        my.addPoint(-width/2, height/2);
        my.addPoint(width/2, height/2);
        my.addPoint(width/2, -height/2);
    }

    public boolean isBoxed() {
        boolean boxed=true;

        for(int i=0; i<2; i++) {
            if(!horizontalConnections[i].connectionMade || !verticalConnections[i].connectionMade) {
                boxed=false;
            }
        }

        return boxed;
    }

    public static BoxSprite1 createBox(int x, int y, ConnectionSprite[] horizontalConnections, ConnectionSprite[] verticalConnections) {
        BoxSprite1 box=new BoxSprite1();
        box.player=0;
        box.x=x;
        box.y=y;
        box.horizontalConnections=horizontalConnections;
        box.verticalConnections=verticalConnections;
        return box;
    }
}