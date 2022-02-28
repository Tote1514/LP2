import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

import figures.*;

class PackApp {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    ArrayList<Rect> rectangulos = new ArrayList<Rect>();
    ArrayList<Ellipse> elipses = new ArrayList<Ellipse>();
    Random random = new Random();
    final int COLOR = 256;//Parametro para passar de argumento para gerar uma cor aleatoria


    ListFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.addKeyListener (
            new KeyAdapter() {
                public void keyPressed (KeyEvent evt) {
                    if (evt.getKeyChar() == 'e') {
                        int x = random.nextInt(600);
                        int y = random.nextInt(600);
                        int w = random.nextInt(50)+1;//Somar um para não dar um largura de zero
                        int h = random.nextInt(50)+1;//Somar um para não dar um altura de zero
                        int r1 = random.nextInt(COLOR);
                        int g1 = random.nextInt(COLOR);
                        int b1 = random.nextInt(COLOR);
                        int r2 = random.nextInt(COLOR);
                        int g2 = random.nextInt(COLOR);
                        int b2 = random.nextInt(COLOR);
                        elipses.add(new Ellipse(x,y, w,h,r1,g1,b1,r2,g2,b2));
                        repaint();  // outer.repaint()
                    }
                }
            }
        );
        this.setTitle("Lista de Elipses e Rectangulos");
        this.setSize(600, 600);

    }

    public void paint (Graphics g) {
        super.paint(g);
        for (Ellipse e : this.elipses) {
            e.paint(g);
        }
    }
}
