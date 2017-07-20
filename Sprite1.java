/**
 * Created by dhairyathakkar on 26-03-2017.
 */
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Sprite1 {


    Polygon my;
    Color color;
    int width;
    int height;
    int x;
    int y;

    public Sprite1() {

        my=new Polygon();
        width=0;
        height=0;
        x=0;
        y=0;
        color=Color.BLACK;
    }

    public void paint(Graphics g) {


        g.setColor(color);

        Polygon d=new Polygon();
        for(int i=0; i<my.npoints; i++) {
            int x1=my.xpoints[i] + x + width / 2;
            int y1=my.ypoints[i] + y + height / 2;
            d.addPoint(x1, y1);
        }
        g.fillPolygon(d);
    }

    public boolean containsPoint(int x, int y) {


        return my.contains(x - this.x - width /2, y - this.y - height /2);
    }
}