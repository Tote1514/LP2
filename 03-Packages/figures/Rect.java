package figures;

import java.awt.*;

public class Rect extends Figures{
    int w, h;
    //Cor de fundo
    int r2, g2, b2;
    public Rect (int x, int y, int w, int h,int r1, int g1, int b1, int r2, int g2, int b2) {
        super(x, y, r1, g1, b1);
        this.w = w;
        this.h = h;
        this.r2 = r2;
        this.g2 = g2;
        this.b2 = b2;
    }

    public void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
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
    public void changeColor(int r, int g, int b){
        super.r1 = r;
        super.g1 = g;
        super.b1 = b;
    }
    public void changeBackGroundColor(int r, int g, int b){
        this.r2 = r;
        this.g2 = g;
        this.b2 = b;
    }
    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(super.r1, super.g1, super.b1));
        g2d.setStroke(new BasicStroke(2));
        g2d.drawRect(super.x,super.y, this.w,this.h);
        g2d.setColor(new Color(this.r2, this.g2, this.b2));
        g2d.fillRect(super.x,super.y, this.w,this.h);
    }
}
