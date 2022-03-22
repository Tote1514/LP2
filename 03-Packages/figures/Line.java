package figures;

import java.awt.*;
import javax.swing.*;

public class Line extends Figures{

    int x2, y2;

    public Line(int x1, int y1, int x2, int y2,int r1, int g1, int b1){
        super(x1, y1, r1, g1, b1);
        this.x2 = x2;
        this.y2 = y2;
    }
    public void print() {
        System.out.format("Linha que vai das coordenadas (%d,%d) até a coordenada (%d,%d)\n",
                super.x, super.y , this.x2, this.y2);
    }
    public void addX(float x) {
        super.x += x;
        this.x2 += x;
    }

    public void addY(float y) {
        super.y += y;
        this.y2 += y;
    }
    public boolean contains(int x, int y){
        return x>= super.x && x<= this.x2 && y >= super.y-2 && y <= super.y+2;
    }
    public void changeColor(int r, int g, int b){
        super.r1 = r;
        super.g1 = g;
        super.b1 = b1;
    }
    public void changeBackGroundColor(int r, int g, int b){
        //Não faz nada.
    }
    public void paint(Graphics g) {
        Graphics g2d =(Graphics2D) g;
        g2d.setColor(new Color(super.r1, super.g1, super.b1));
        g2d.drawLine(super.x, super.y, this.x2, this.y2);
    }
}
