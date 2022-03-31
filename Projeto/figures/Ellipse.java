package figures;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

public class Ellipse extends Figures{
    int w, h;
    //Cor de fundo
    int r2, g2, b2;
    Color contorno;
    Color fundo;

    public Ellipse (int x, int y, int w, int h,int r1, int g1, int b1, int r2, int g2, int b2) {
        super(x, y, r1, g1, b1);
        this.w = w;
        this.h = h;
        this.r2 = r2;
        this.g2 = g2;
        this.b2 = b2;
        this.contorno = new Color (super.r1, super.g1, super.b1);
        this.fundo = new Color (this.r2, this.g2, this.b2);
    }

    public void print () {
        System.out.format("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, super.x, super.y);
    }
    public void addX(float x) {
        super.x += x;
    }

    public void addY(float y) {
        super.y += y;
    }
    public boolean contains(int x, int y){
        return x<=super.x+this.w && x>=super.x && y>=super.y && y<=super.y+this.h;
    }
    public void changeColor(Color new_color){
        contorno = new_color;
    }
    public void changeBackGroundColor(Color new_color){
        fundo = new_color;
    }
    public boolean pontosY(int x, int y){
        return x <= (super.x + (w/2) +5) && x >= (super.x + (w/2) -5) && y <= (super.y + h) && y >= (super.y + h -10);
    }
    public void addHeight(float dy){
        this.h += dy;
    }
    public boolean pontosX (int x, int y){
        return x<= (super.x + w) && x >=(super.x + w -8) && y <=(super.y + (h/2) +5) && y >= (super.y +(h/2) -5);
    }
    public void addWidth(float dx){
        this.w += dx;
    }
    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(contorno);
        g2d.setStroke(new BasicStroke(2));
        g2d.drawOval(super.x,super.y, this.w,this.h);
        g2d.setColor(fundo);
        g2d.fillOval(super.x,super.y, this.w,this.h);
    }
}
