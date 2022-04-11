import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import figures.*;

class ProjetoApp {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame{

    ArrayList<Figures> figs = new ArrayList<Figures>();
	Rect redButton = new Rect(10,35,125,30,0,0,0,131,111,255);
	Rect blueButton = new Rect(10,65,125,30,0,0,0,65,105,225);
	int cont = 0; // Numero de figuras na lista
	int i = 0;// indice da figura para mudar o foco com tabs
	boolean selection = false;// Indica se a figura em foco foi selecionada ou é a última figura da lista
	Figures focus = null;//Armanzena a figura em foco
	int lastest_x;//A coordenada x da última vez que foi apertado o mouse
	int lastest_y;// A coordenada y da última vez que foi apertado o mouse
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
                    Point p = MouseInfo.getPointerInfo().getLocation();
					int x = p.x - getLocation().x;
				   	int y = p.y - getLocation().y;
                    int w = 50;
                    int h = 50;
                    int r1 = 0;
                    int g1 = 0;
                    int b1 = 0;
                    int r2 = 255;
                    int g2 = 255;
                    int b2 = 255;
					if (!redButton.clicked(x,y) && !blueButton.clicked(x,y) && x>0) {
						switch (evt.getKeyChar()) {
							case 'e':
							figs.add(new Ellipse(x,y, w,h,r1,g1,b1,r2,g2,b2));
							cont++;
							selection = false;
							focus = figs.get(cont-1);
							break;
							case 'r':
							figs.add(new Rect(x,y, w,h,r1,g1,b1,r2,g2,b2));
							cont++;
							selection = false;
							focus = figs.get(cont-1);
							break;
							case 't':
							int x2 = x + 50;
							int y2 = y + 50;
							int x3 = x - 50;
							int y3=  y + 50;
							figs.add(new Triangle(x,x2,x3,y,y2,y3,r1,g1,b1, r2, b2, g2));
							cont++;
							selection = false;
							focus = figs.get(cont-1);
							break;
							case 'l':
							int x_2 = x + 75;
							int y_2 = y;
							figs.add(new Line(x, y, x_2, y_2, r1, g1, b1));
							cont++;
							selection = false;
							focus = figs.get(cont-1);
							break;
						}

					}
					if (focus != null) {
						switch (evt.getKeyCode()) {
							case 8:
								figs.remove(focus);
								focus = null;
								i = 0;
								cont--;
								break;
							case 37:
								focus.addX(-2);
								break;
							case 38:
								focus.addY(-2);
								break;
							case 39:
								focus.addX(2);
								break;
							case 40:
								focus.addY(2);
								break;
							case 32:
								if (cont > 0) {
									focus = figs.get(i);
									i++;
								}
								if (i >= cont) {
									i = 0;
								}
								break;
						}

					}
                    repaint();  // outer.repaint()

                }
            }
        );
		this.addMouseMotionListener(
			new MouseMotionAdapter() {
				public void mouseDragged(MouseEvent evt){
					int dx = evt.getX() - lastest_x;
					int dy = evt.getY() - lastest_y;
					if (focus != null) {
						if (focus.pontos(lastest_x,lastest_y)) {
							if (focus instanceof Line) {
								focus.addWidth(dx);
								lastest_x += dx;
							}else{
								focus.addWidth(dx);
								focus.addHeight(dy);
								lastest_y += dy;
								lastest_x += dx;
							}
						}
						if (focus.clicked(lastest_x,lastest_y)) {
							focus.addX(dx);
							focus.addY(dy);
							lastest_x += dx;
							lastest_y += dy;

						}
						repaint();
					}

				}
			}
		);
        this.addMouseListener(
			new MouseAdapter(){
				public void mousePressed(MouseEvent evt){
					lastest_x = evt.getX();
					lastest_y = evt.getY();

					for (int j = figs.size()-1; j>=0 ;j--) {
						Figures  fig = figs.get(j);
						if (focus != null) {
							if (fig.clicked(lastest_x,lastest_y) && !(focus.pontos(lastest_x,lastest_y))) {
								focus = fig;
								selection = true;
								figs.remove(focus);
								figs.add(focus);
								i = 0;
								break;
							}
						}else {
							if (fig.clicked(lastest_x,lastest_y)) {
								focus = fig;
								selection = true;
								figs.remove(focus);
								figs.add(focus);
								i = 0;
								break;
							}
						}

					}
					if(redButton.clicked(lastest_x,lastest_y) && focus != null && cont > 0) {
						JColorChooser colorChooser = new JColorChooser();

						Color color = JColorChooser.showDialog(null, "Escolha a cor do contoro", Color.black);
						focus.changeColor(color);
					}
					if (blueButton.clicked(lastest_x,lastest_y) && focus != null && cont > 0) {
						JColorChooser colorChooser = new JColorChooser();

						Color color = JColorChooser.showDialog(null, "Escolha a cor do fundo:", Color.black);
						focus.changeBackGroundColor(color);
					}
					repaint();
				}

			}
		);
        this.setTitle("Projeto");
        this.setSize(600, 600);

    }

    public void paint (Graphics g) {
        super.paint(g);
		redButton.paint(g);
		g.setColor(Color.black);
		g.setFont(new Font("Ink Free",Font.BOLD,12));
		g.drawString("COR DE CONTORNO",12,45);
		blueButton.paint(g);
		g.setColor(Color.black);
		g.drawString("COR DE FUNDO", 17,78);
        for (Figures f : this.figs) {
            f.paint(g);
        }
		g.setColor(Color.red);
		if (focus != null) {
			g.drawRect(focus.x, focus.y, focus.w, focus.h);
            g.drawOval((focus.x+focus.w), (focus.y+focus.h),10,10);

		}
    }
}
