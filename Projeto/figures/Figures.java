package figures;
import java.awt.*;

public abstract class Figures {
    //Primeira coordenada
    public int x, y;
    //Cor de contorno
    int r1, g1, b1;

    Figures(int x, int y, int r1, int g1, int b1){
        this.x = x;
        this.y = y;
        this.r1 = r1;
        this.g1 = g1;
        this.b1 = b1;
    }
    public abstract void changeColor(Color new_color);
    public abstract void changeBackGroundColor(Color new_color);
    public abstract void print();
    public abstract void addX(float x);
    public abstract void addY(float y);
    public abstract void paint (Graphics g);
    public abstract boolean contains(int x, int y);
}
