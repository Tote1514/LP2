package figures;
import java.awt.Graphics;

public abstract class Figures {
    //Cor de contorno
    int r1, g1, b1;
    //Cor de fundo
    int r2, g2, b2;
    Figures(int r1, int g1, int b1, int r2, int g2, int b2){
        this.r1 = r1;
        this.g1 = g1;
        this.b1 = b1;
        this.g2 = g2;
        this.r2 = r2;
        this.b2 = b2;
    }
    public abstract void print();
    public abstract void paint (Graphics g);
}
