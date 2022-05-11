import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.io.*;

import figures.*;

class ProjetoApp {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame{

    ArrayList<Figures> figs = new ArrayList<Figures>();
	ArrayList<Button> buts = new ArrayList<Button>();
	Button focus_but = null;
	Rect redButton = new Rect(13,35,55,25,0,0,0,169,169,169);
	Rect blueButton = new Rect(13,60,55,25,0,0,0,169,169,169);
	int i = 0;// indice da figura para mudar o foco com tabs
	boolean selection = false;// Indica se a figura em foco foi selecionada ou é a última figura da lista
	Figures focus = null;//Armanzena a figura em foco
	int lastest_x;//A coordenada x da última vez que foi apertado o mouse
	int lastest_y;// A coordenada y da última vez que foi apertado o mouse

    ListFrame () {
		try {
			FileInputStream f = new FileInputStream("proj.bin");
			ObjectInputStream o = new ObjectInputStream(f);
			this.figs = (ArrayList<Figures>) o.readObject();
			o.close();
		}catch (Exception x) {
			System.out.println("Error!");
		}
		buts.add(new Button(0, new Ellipse(25,90,30,30,0,0,0,255,255,255)));
		buts.add(new Button(1, new Rect(25,130,30,30,0,0,0,255,255,255)));
		buts.add(new Button(2, new Triangle(40,55,25,170,200,200,0,0,0,255,255,255)));
		buts.add(new Button(3, new Line(25,225,55,225,0,0,0)));
		buts.add(new Button(4, new Rect(25,250,30,30,255,0,0,255,99,71)));

        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
					try {
						FileOutputStream f = new FileOutputStream("proj.bin");
						ObjectOutputStream o = new ObjectOutputStream(f);
						o.writeObject(figs);
						o.flush();
						o.close();
					} catch(Exception x) {
					}
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
								selection = false;
								focus = figs.get(figs.size()-1);
								break;
							case 'r':
								figs.add(new Rect(x,y, w,h,r1,g1,b1,r2,g2,b2));
								selection = false;
								focus = figs.get(figs.size()-1);
								break;
							case 't':
								int x2 = x + 50;
								int y2 = y + 50;
								int x3 = x - 50;
								int y3=  y + 50;
								figs.add(new Triangle(x,x2,x3,y,y2,y3,r1,g1,b1, r2, b2, g2));
								selection = false;
								focus = figs.get(figs.size()-1);
								break;
							case 'l':
								int x_2 = x + 75;
								int y_2 = y;
								figs.add(new Line(x, y, x_2, y_2, r1, g1, b1));
								selection = false;
								focus = figs.get(figs.size()-1);
								break;
						}

					}
					if (focus != null) {
						switch (evt.getKeyCode()) {
							case 8:
								figs.remove(focus);
								focus = null;
								i = 0;
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
								if (figs.size() > 0) {
									focus = figs.get(i);
									i++;
								}
								if (i >= figs.size()) {
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
					int w = 50;
					int h = 50;
					int r1 = 0;
					int g1 = 0;
					int b1 = 0;
					int r2 = 255;
					int g2 = 255;
					int b2 = 255;
					boolean touched = false;
					for (int j = figs.size()-1; j>=0 ;j--) {
						touched = false;
						Figures  fig = figs.get(j);
						if (focus != null) {
							if (fig.clicked(lastest_x,lastest_y) && !(focus.pontos(lastest_x,lastest_y))) {
								focus = fig;
								selection = true;
								figs.remove(focus);
								figs.add(focus);
								i = 0;
								touched = true;
								break;
							}
						}else {
							if (fig.clicked(lastest_x,lastest_y)) {
								focus = fig;
								selection = true;
								figs.remove(focus);
								figs.add(focus);
								i = 0;
								touched = true;
								break;
							}
						}

					}
					if (focus != null) {
						if (focus.pontos(lastest_x,lastest_y)) {
							touched = true;
						}
					}
					for (Button but : buts) {
						if (but.clicked(lastest_x,lastest_y)) {
							if (focus_but == but) {
								focus_but = null;
								break;
							}else {
								focus_but = but;
								touched = true;
								break;
							}
						}
					}
					if (focus != null) {
						if (focus_but != null) {
							if (focus_but.idx == 4) {
								figs.remove(focus);
								focus = null;
								i = 0;
								focus_but = null;
							}
						}
					}
					if (focus_but != null && !touched &&!redButton.clicked(lastest_x,lastest_y) && !blueButton.clicked(lastest_x,lastest_y)) {
						switch (focus_but.idx) {
							case 0:
								figs.add(new Ellipse(lastest_x,lastest_y, w,h,r1,g1,b1,r2,g2,b2));
								selection = false;
								focus = figs.get(figs.size()-1);
								break;
							case 1:
								figs.add(new Rect(lastest_x,lastest_y, w,h,r1,g1,b1,r2,g2,b2));
								selection = false;
								focus = figs.get(figs.size()-1);
								break;
							case 2:
								int x2 = lastest_x + 50;
								int y2 = lastest_y + 50;
								int x3 = lastest_x - 50;
								int y3=  lastest_y + 50;
								figs.add(new Triangle(lastest_x,x2,x3,lastest_y,y2,y3,r1,g1,b1, r2, b2, g2));
								selection = false;
								focus = figs.get(figs.size()-1);
								break;
							case 3:
								int x_2 = lastest_x + 75;
								int y_2 = lastest_y;
								figs.add(new Line(lastest_x, lastest_y, x_2, y_2, r1, g1, b1));
								selection = false;
								focus = figs.get(figs.size()-1);
								break;
						}
					}
					if(redButton.clicked(lastest_x,lastest_y) && focus != null && figs.size() > 0) {
						JColorChooser colorChooser = new JColorChooser();

						Color color = JColorChooser.showDialog(null, "Escolha a cor do contoro", Color.black);
						focus.changeColor(color);
					}
					if (blueButton.clicked(lastest_x,lastest_y) && focus != null && figs.size() > 0) {
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
		for (Button but :this.buts) {
			but.paint(g, but==focus_but);
		}
		redButton.paint(g, false);
		g.setColor(Color.black);
		g.setFont(new Font("Ink Free",Font.BOLD,10));
		g.drawString("CONTORNO",12,45);
		blueButton.paint(g, false);
		g.setColor(Color.black);
		g.drawString("FUNDO", 17,70);
		g.setFont(new Font("Serif",Font.PLAIN, 20));
		g.drawString("X",32,272);
		for (Figures f : this.figs) {
			f.paint(g, f == focus);
		}

    }
}
