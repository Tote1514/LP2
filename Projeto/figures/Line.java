package figures;

import java.awt.*;
import javax.swing.*;

public class Line extends Figures{

    Color contorno;
    int x2, y2;

    public Line(int x1, int y1, int x2, int y2,int r1, int g1, int b1){
        super(x1, y1, r1, g1, b1);
        this.x2 = x2;
        this.y2 = y2;
        this.contorno = new Color (super.r1, super.g1, super.b1);
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
    public void changeColor(Color new_color){
        contorno = new_color;
    }
    public void changeBackGroundColor(Color new_color){
        //Não faz nada.
    }
    public boolean pontosY(int x, int y){
        return false;
    }
    public void addHeight(float dy){
        //Não faz nada
    }
    public boolean pontosX (int x, int y){
        return (x <= super.x+4 && x >= super.x && y <= super.y +2 && y >= super.y-2);
    }
    public void addWidth(float dx){
        super.x += dx;
    }
    public void paint(Graphics g) {
        Graphics g2d =(Graphics2D) g;
        g2d.setColor(contorno);
        g2d.drawLine(super.x, super.y, this.x2, this.y2);
    }
}
