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
	//JButton button;
	int cont = 0; // Numero de figuras na lista
	boolean selection = false;// Indica se a figura em foco foi selecionada ou é seria a última figura da lista
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
                    int x = lastest_x;
                    int y = lastest_y;
                    int w = 50;
                    int h = 50;
                    int r1 = 0;
                    int g1 = 0;
                    int b1 = 0;
                    int r2 = 255;
                    int g2 = 255;
                    int b2 = 255;
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
							case 48:
								focus.changeColor(255,0,0);
								break;
							case 49:
								focus.changeColor(0,255,0);
								break;
							case 50:
								focus.changeColor(255,255,0);
								break;
							case 51:
								focus.changeColor(0,0,255);
								break;
							case 52:
								focus.changeColor(76,0,153);
								break;
							case 53:
								focus.changeColor(255,0,127);
								break;
							case 54:
								focus.changeColor(96,96,96);
								break;
							case 55:
								focus.changeColor(51,255,255);
								break;
							case 56:
								focus.changeColor(0,0,0);
								break;
							case 57:
								focus.changeColor(255,255,255);
								break;
							case 90:
								focus.changeBackGroundColor(0,255,0);
								break;
							case 88:
								focus.changeBackGroundColor(255,255,0);
								break;
							case 67:
								focus.changeBackGroundColor(0,0,255);
								break;
							case 86:
								focus.changeBackGroundColor(76,0,153);
								break;
							case 66:
								focus.changeBackGroundColor(255,0,127);
								break;
							case 78:
								focus.changeBackGroundColor(96,96,96);
								break;
							case 77:
								focus.changeBackGroundColor(51,255,255);
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
					if (focus.contains(lastest_x,lastest_y)) {
						focus.addX(dx);
						focus.addY(dy);
						lastest_x += dx;
						lastest_y += dy;
					}
					repaint();
				}
			}
		);
        this.addMouseListener(
			new MouseAdapter(){
				public void mousePressed(MouseEvent evt){

					lastest_x = evt.getX();
					lastest_y = evt.getY();

					for (int i = figs.size()-1; i>=0 ;i--) {
						Figures  fig = figs.get(i);
						if (fig.contains(lastest_x,lastest_y)) {
							focus = fig;
							selection = true;
							figs.remove(focus);
							figs.add(focus);
							break;
						}
					}
				}

			}
		);
		/*button = new JButton("Pick a color");
		button.setBounds(0,0,100,50);
		button.addActionListener(
			new ActionListener() {
     			public void actionPerformed(ActionEvent evt) {
					if(evt.getSource()==button) {
						JColorChooser colorChooser = new JColorChooser();

						Color color = JColorChooser.showDialog(null, "Pick a color", Color.black);

					}
     			}
			}
		);
		this.add(button);*/
        this.setTitle("Projeto");
        this.setSize(600, 600);
		this.setLayout(null);

    }

    public void paint (Graphics g) {
        super.paint(g);
        for (Figures f : this.figs) {
            f.paint(g);
        }
    }
}
