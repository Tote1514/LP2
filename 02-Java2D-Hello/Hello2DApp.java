import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class Hello2DApp {
    public static void main (String[] args) {
        Hello2DFrame frame = new Hello2DFrame();
    }
}

class Hello2DFrame extends JFrame {

    BufferedImage img;

    public Hello2DFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Java2D - Hello World!");
        this.getContentPane().setBackground(Color.blue);
        this.setLocationRelativeTo(null);
        this.setSize(500, 600);
        this.setVisible(true);
        try {
            img = ImageIO.read(new File("Happy_smiley_face.png"));
        } catch (IOException e) {
        }
    }

    public void paint (Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        //Desenho da casa
        g2d.setPaint(Color.red);
        g2d.fillRect(100,375,200,200);
        g2d.setPaint(Color.black);
        g2d.drawRect(100,375,200,200);
        //Caracteristicas da palavra
        g2d.setPaint(Color.magenta);
        g2d.setFont(new Font("Ink Free",Font.BOLD,50));
        g2d.drawString("This is my house",50,120);

        //Desenho do sol
        g2d.setPaint(Color.yellow);
        g2d.fillOval(100,150,75,75);
        g2d.setPaint(Color.black);
        g2d.drawOval(100,150,75,75);

        //Desenho da grama
        g2d.setPaint(Color.green);
        g2d.fillRect(0,575,500,25);

        //Desenho do teto da casa
        g2d.setPaint(Color.black);
        Polygon poly = new Polygon();
        poly.addPoint(100,375);
        poly.addPoint(300,375);
        poly.addPoint(200,300);
        g2d.drawPolygon(poly);
        g2d.fillPolygon(poly);

        //Desenho da porta
        g2d.fillRect(175,525,50,50);

        g2d.setStroke(new BasicStroke(5));
        g2d.drawLine(0,575,500,575);

        //Imagem
        g2d.drawImage(img,425,75,50,50,null);

    }
}
