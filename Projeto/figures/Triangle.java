package figures;

import java.awt.*;
import javax.swing.*;

public class Triangle extends Figures{
    //Coordenadas x's
    private int x1, x2, x3;
    //Coordenadas y's
    private int y1, y2, y3;
    //Cor de fundo
    private int r2, g2, b2;
    private Color contorno;
    private Color fundo;

    public Triangle(int x1, int x2, int x3, int y1, int y2, int y3,int r1, int g1, int b1, int r2, int g2, int b2){
        super(x1-50, y1, 100, 50, r1, g1, b1);
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.y1 = y1;
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
            this.x1, this.y1, this.x2, this.y2, this.x3,this.y3);
    }
    public void addX(float x) {
        super.x += x;
        this.x1 += x;
        this.x2 += x;
        this.x3 += x;
    }

    public void addY(float y) {
        super.y += y;
        this.y1 += y;
        this.y2 += y;
        this.y3 += y;
    }
    public boolean clicked(int x, int y){
        return x<=this.x1+(this.x2-this.x1) && x>=this.x1-(this.x1-this.x3) && y>=this.y1 && y<=this.y1+(this.y2 - this.y1);
    }
    public void changeColor(Color new_color){
        contorno = new_color;
    }
    public void changeBackGroundColor(Color new_color){
        fundo = new_color;
    }
    public void addHeight(float dy){
        if (this.y3>=this.y1) {
            this.y3 += dy;
            this.y2 += dy;
            this.h += dy;
        }else if (dy>0){
            this.y3 += dy;
            this.y2 += dy;
            this.h += dy;
        }else {
            this.y3 = this.y1;
            this.y2 = this.y1;
            this.h = 0;
        }
    }
    public boolean pontos(int x, int y){
        return x >= (super.x + super.w) && x <= (super.x + super.w + 10) && y <= (super.y + super.h+10) && y >=(super.y + super.h);
    }
    public void addWidth(float dx){
        if (this.x2>=this.x3) {
            super.x -= dx;
            this.x3 -= dx;
            this.x2 += dx;
            this.w += 2*dx;
        }else if (dx>0){
            super.x -= dx;
            this.x3 -= dx;
            this.x2 += dx;
            this.w += 2*dx;
        }else{
            this.x3 = this.x1;
            this.x2 = this.x1;
            super.w = 0;
            super.x = this.x1;
        }
    }
    public void paint(Graphics g, boolean focused){
        Graphics g2d =(Graphics2D) g;
        g2d.setColor(contorno);
        Polygon poly = new Polygon();
        poly.addPoint(this.x1, this.y1);
        poly.addPoint(this.x2, this.y2);
        poly.addPoint(this.x3, this.y3);
        g2d.drawPolygon(poly);
        g2d.setColor(fundo);
        g2d.fillPolygon(poly);
        if (focused) {
            g.setColor(Color.red);
            g.drawRect(super.x, super.y, super.w, super.h);
            g.drawOval((super.x+super.w), (super.y+super.h),10,10);
        }
    }
}
