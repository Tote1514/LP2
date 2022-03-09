package figures;

import java.awt.*;

public class Rect extends Figures{
    int x, y;
    int w, h;
    public Rect (int x, int y, int w, int h,int r1, int g1, int b1, int r2, int g2, int b2) {
        super(r1, g1, b1, r2, g2, b2);
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(this.r1, this.g1, this.b1));
        g2d.setStroke(new BasicStroke(2));
        g2d.drawRect(this.x,this.y, this.w,this.h);
        g2d.setColor(new Color(this.r2, this.g2, this.b2));
        g2d.fillRect(this.x,this.y, this.w,this.h);
    }
}
