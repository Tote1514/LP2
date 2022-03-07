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

    ArrayList<Figures> figs = new ArrayList<Figures>();
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
                    if (evt.getKeyChar() == 'e') {
                        figs.add(new Ellipse(x,y, w,h,r1,g1,b1,r2,g2,b2));
                    }else if (evt.getKeyChar() == 'r') {
                        figs.add(new Rect(x,y, w,h,r1,g1,b1,r2,g2,b2));
                    }else if (evt.getKeyChar() == 't') {
                        int x1 = random.nextInt(600);
                        int y1 = random.nextInt(600);
                        // Para fazer triangulos que sejam regulares e não muito grandes
                        int coordenadax  = random.nextInt(50)+1;
                        int coordenaday = random.nextInt(50)+1;
                        int x2 = x1 + coordenadax;
                        int y2 = y1 + coordenaday;
                        int x3 = x1 - coordenadax;
                        int y3=  y1 + coordenaday;
                        int r_Triangle1 = random.nextInt(COLOR);
                        int g_Triangle1= random.nextInt(COLOR);
                        int b_Triangle1 = random.nextInt(COLOR);
                        int r_Triangle2 = random.nextInt(COLOR);
                        int g_Triangle2 = random.nextInt(COLOR);
                        int b_Triangle2 = random.nextInt(COLOR);
                        figs.add(new Triangle(x1,x2,x3,y1,y2,y3,
                            r_Triangle1,g_Triangle1,b_Triangle1,r_Triangle2,g_Triangle2,b_Triangle2));
                    }
                    repaint();  // outer.repaint()
                }
            }
        );
        this.setTitle("Lista de Elipses e Rectangulos");
        this.setSize(600, 600);

    }

    public void paint (Graphics g) {
        super.paint(g);
        for (Figures f : this.figs) {
            f.paint(g);
        }
    }
}
