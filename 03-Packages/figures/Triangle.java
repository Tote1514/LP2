package figures;

import java.awt.*;
import javax.swing.*;

public class Triangle extends Figures{
    //Coordenadas x's
    int x2, x3;
    //Coordenadas y's
    int y2, y3;
    //Cor de fundo
    int r2, g2, b2;
    Color contorno;
    Color fundo;

    public Triangle(int x, int x2, int x3, int y, int y2, int y3,int r1, int g1, int b1, int r2, int g2, int b2){
        super(x, y, r1, g1, b1);
        this.x2 = x2;
        this.x3 = x3;
        this.y2 = y2;
        this.y3 = y3;
        this.r2 = r2;
        this.g2 = g2;
        this.b2 = b2;
        this.contorno = new Color (super.r1, super.g1, super.b1);
        this.fundo = new Color (this.r2, this.g2, this.b2);
    }
    public void print(){
        System.out.format("Triângulo com os vertices nas posições:(%d,%d),(%d,%d),(%d,%d)\n",
            super.x, super.y, this.x2, this.y2, this.x3,this.y3);
    }
    public void addX(float x) {
        super.x += x;
        this.x2 += x;
        this.x3 += x;
    }

    public void addY(float y) {
        super.y += y;
        this.y2 += y;
        this.y3 += y;
    }
    public boolean contains(int x, int y){
        return x<=super.x+50 && x>=super.x-50 && y>=super.y && y<=super.y+50;
    }
    public void changeColor(Color new_color){
        contorno = new_color;
    }
    public void changeBackGroundColor(Color new_color){
        fundo = new_color;
    }
    public void paint(Graphics g){
        Graphics g2d =(Graphics2D) g;
        g2d.setColor(contorno);
        Polygon poly = new Polygon();
        poly.addPoint(super.x, super.y);
        poly.addPoint(this.x2, this.y2);
        poly.addPoint(this.x3, this.y3);
        g2d.drawPolygon(poly);
        g2d.setColor(fundo);
        g2d.fillPolygon(poly);
    }
}
