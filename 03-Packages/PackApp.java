import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.awt.geom.*;



import figures.*;

class PackApp {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame{

    ArrayList<Figures> figs = new ArrayList<Figures>();
	int cont = 0; // Numero de figuras na lista
	boolean selection = false;

	Figures focus = null;// Por enquanto, vai armazenar a última figura
	int lastest_x;
	int lastest_y;
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
                    int x = lastest_x;
                    int y = lastest_y;
                    int w = 50;
                    int h = 50;
                    int r1 = random.nextInt(COLOR);
                    int g1 = random.nextInt(COLOR);
                    int b1 = random.nextInt(COLOR);
                    int r2 = random.nextInt(COLOR);
                    int g2 = random.nextInt(COLOR);
                    int b2 = random.nextInt(COLOR);
                    switch (evt.getKeyChar()) {
                        case 'e':
                            figs.add(new Ellipse(x,y, w,h,r1,g1,b1,r2,g2,b2));
							cont++;
							selection = false;
                            break;
                        case 'r':
                            figs.add(new Rect(x,y, w,h,r1,g1,b1,r2,g2,b2));
							cont++;
							selection = false;
                            break;
                        case 't':
                            int x2 = x + 50;
                            int y2 = y + 50;
                            int x3 = x - 50;
                            int y3=  y + 50;
                            figs.add(new Triangle(x,x2,x3,y,y2,y3,r1,g1,b1, r2, b2, g2));
							cont++;
							selection = false;
                            break;
                        case 'w':
                            int x_2 = x + 75;
                            int y_2 = y;
                            figs.add(new Line(x, y, x_2, y_2, r1, g1, b1));
							cont++;
							selection = false;
                            break;
                    }

					if (cont >0 &&!selection) {
						focus = figs.get(cont-1);
					}else if(!selection){
						focus = null;
					}
					if (focus != null) {
						switch (evt.getKeyCode()) {
							case 8:
								figs.remove(focus);
								cont--;
								break;
							case 37:
								focus.addX(-1);
								break;
							case 38:
								focus.addY(-1);
								break;
							case 39:
								focus.addX(1);
								break;
							case 40:
								focus.addY(1);
								break;
						}

					}
                    repaint();  // outer.repaint()
                }
            }
        );
        this.addMouseListener(
			new MouseAdapter(){
				public void mousePressed(MouseEvent evt){

					lastest_x = evt.getX();
					lastest_y = evt.getY();

					for (Figures fig : figs) {
						if (fig.contains(lastest_x,lastest_y)) {
							focus = fig;
							selection = true;
							focus.print();
							Collections.swap(figs,figs.indexOf(focus),figs.size()-1);
						}
					}
				}

			}
		);
        this.setTitle("Projeto");
        this.setSize(600, 600);

    }

    public void paint (Graphics g) {
        super.paint(g);
        for (Figures f : this.figs) {
            f.paint(g);
        }
    }
}
