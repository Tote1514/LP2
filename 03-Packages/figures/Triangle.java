package figures;

import java.awt.*;
import javax.swing.*;

public class Triangle{
    //Coordenadas x's
    private int[] x = new int[3];
    //Coordenadas y's
    private int[] y = new int[3];
    //Cor de contorno
    private int r1, g1, b1;
    //Cor de fundo
    private int r2, g2, b2;

    public Triangle(int x1, int x2, int x3, int y1, int y2, int y3,int r1, int g1, int b1, int r2, int g2, int b2){
        this.x[0] = x1;
        this.x[1] = x2;
        this.x[2] = x3;
        this.y[0] = y1;
        this.y[1] = y2;
        this.y[2] = y3;
        this.r1 = r1;
        this.g1 = g1;
        this.b1 = b1;
        this.g2 = g2;
        this.r2 = r2;
        this.b2 = b2;

    }
    public void print(){
        System.out.format("Triângulo com os vertices nas posições:(%d,%d),(%d,%d),(%d,%d)",
            this.x[0],this.y[0], this.x[1], this.y[1], this.x[2],this.y[2]);
    }
    public void paint(Graphics g){
        Graphics g2d =(Graphics2D) g;
        g2d.setColor(new Color(this.r1, this.g1, this.b1));
        g2d.drawPolygon(this.x, this.y, 3);
        g2d.setColor(new Color(this.r2, this.g2, this.b2));
        g2d.fillPolygon(this.x, this.y, 3);
    }
}
