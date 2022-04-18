package figures;

import java.awt.*;
import javax.swing.*;

public class Line extends Figures{

    private Color contorno;
    private int x2, y2, x1, y1;

    public Line(int x1, int y1, int x2, int y2,int r1, int g1, int b1){
        super(x1-1, y1-4, 76, 8, r1, g1, b1);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.contorno = new Color (super.r1, super.g1, super.b1);
    }
    public void print() {
        System.out.format("Linha que vai das coordenadas (%d,%d) até a coordenada (%d,%d)\n",
                this.x1, this.y1 , this.x2, this.y2);
    }
    public void addX(float x) {
        super.x += x;
        this.x1 += x;
        this.x2 += x;
    }

    public void addY(float y) {
        super.y += y;
        this.y1 += y;
        this.y2 += y;
    }
    public boolean clicked(int x, int y){
        return x>= this.x1 && x<= this.x2 && y >= this.y1-2 && y <= this.y1+2;
    }
    public void changeColor(Color new_color){
        contorno = new_color;
    }
    public void changeBackGroundColor(Color new_color){
        //Não faz nada.
    }
    public void addHeight(float dy){
        //Não faz nada
    }
    public boolean pontos(int x, int y){
        return x >= (super.x + super.w) && x <= (super.x + super.w + 10) && y <= (super.y + super.h+10) && y >=(super.y + super.h);
    }
    public void addWidth(float dx){
        if (super.w >=0) {
            this.x2 += dx;
            super.w += dx;
        }else if (dx >0) {
            this.x2 += dx;
            super.w += dx;
        }else{
            this.x2 = this.x1;
            super.w = 0;
        }

    }
    public void paint(Graphics g) {
        Graphics g2d =(Graphics2D) g;
        g2d.setColor(contorno);
        g2d.drawLine(this.x1, this.y1, this.x2, this.y2);
    }
}
