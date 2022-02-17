import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

class RectEllipseApp {
    public static void main (String[] args) {
        RectEllipseFrame frame = new RectEllipseFrame();
        frame.setVisible(true);
    }
}

class RectEllipseFrame extends JFrame {
    Rect r1;
    Ellipse e1, e2, e3;

    RectEllipseFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Rect + Ellipse");
        this.setSize(600,600);
        this.e1 = new Ellipse(50,50, 100,30,0,0,0,255,117,24);
        this.e2 = new Ellipse(100,200,250,100,255,0,0,253,233,16);
        this.e3 = new Ellipse(200,350,100,200,128,0,0,0,191,255);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.e1.paint(g);
        this.e2.paint(g);
        this.e3.paint(g);
    }
}

class Rect {
    int x, y;
    int w, h;
    //Cor de contorno
    int r1, g1, b1;
    //Cor de fundo
    int r2, g2, b2;

    Rect (int x, int y, int w, int h,int r1, int g1, int b1, int r2, int g2, int b2) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.r1 = r1;
        this.g1 = g1;
        this.b1 = b1;
        this.g2 = g2;
        this.r2 = r2;
        this.b2 = b2;
    }

    void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(this.r1, this.g1, this.b1));
        g2d.drawRect(this.x,this.y, this.w,this.h);
        g2d.setColor(new Color(this.r2, this.g2, this.b2));
        g2d.fillRect(this.x,this.y, this.w,this.h);
    }
}

class Ellipse {
    int x, y;
    int w, h;
    //Cor de contorno
    int r1, g1, b1;
    //Cor de fundo
    int r2, g2, b2;

    Ellipse (int x, int y, int w, int h,int r1, int g1, int b1, int r2, int g2, int b2) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.r1 = r1;
        this.g1 = g1;
        this.b1 = b1;
        this.g2 = g2;
        this.r2 = r2;
        this.b2 = b2;
    }

    void print () {
        System.out.format("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(this.r1, this.g1, this.b1));
        g2d.drawOval(this.x,this.y, this.w,this.h);
        g2d.setColor(new Color(this.r2, this.g2, this.b2));
        g2d.fillOval(this.x,this.y, this.w,this.h);
    }
}
