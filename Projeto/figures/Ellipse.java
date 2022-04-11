package figures;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

public class Ellipse extends Figures{
    //Cor de fundo
    int r2, g2, b2;
    Color contorno;
    Color fundo;

    public Ellipse (int x, int y, int w, int h,int r1, int g1, int b1, int r2, int g2, int b2) {
        super(x, y, w, h, r1, g1, b1);
        this.r2 = r2;
        this.g2 = g2;
        this.b2 = b2;
        this.contorno = new Color (super.r1, super.g1, super.b1);
        this.fundo = new Color (this.r2, this.g2, this.b2);
    }

    public void print () {
        System.out.format("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
            super.w, super.h, super.x, super.y);
    }
    public void addX(float x) {
        super.x += x;
    }

    public void addY(float y) {
        super.y += y;
    }
    public boolean clicked(int x, int y){
        return x<=super.x+super.w && x>=super.x && y>=super.y && y<=super.y+super.h;
    }
    public void changeColor(Color new_color){
        contorno = new_color;
    }
    public void changeBackGroundColor(Color new_color){
        fundo = new_color;
    }
    public boolean pontos(int x, int y){
        return x >= (super.x + super.w) && x <= (super.x + super.w + 10) && y <= (super.y + super.h+10) && y >=(super.y + super.h);
    }
    public void addHeight(float dy){
        super.h += dy;
    }
    public void addWidth(float dx){
        super.w += dx;
    }
    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(contorno);
        g2d.setStroke(new BasicStroke(2));
        g2d.drawOval(super.x,super.y, super.w,super.h);
        g2d.setColor(fundo);
        g2d.fillOval(super.x,super.y, super.w,super.h);
    }
}
