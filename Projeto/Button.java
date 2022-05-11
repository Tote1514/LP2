import ivisible.IVisible;
import java.awt.*;
import figures.Figures;

public class Button implements IVisible {
    static int SPC =85;
    static int DIM = 40;
    static int PAD = 4;
    static int LARGURA = 56;

    public  int  idx;
    private Figures fig;

    public Button (int idx, Figures fig) {
        this.idx = idx;
        this.fig = fig;
    }

    public boolean clicked (int x, int y) {
        return 12<=x && x<=12+LARGURA && SPC+this.idx*DIM<=y && y<=SPC+this.idx*DIM+DIM;
    }

    public void paint (Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(1));
        g2d.setColor(focused ? Color.GRAY : new Color(169,169,169));
        g2d.fillRect(12, SPC+this.idx*DIM, LARGURA, DIM);
        g2d.setColor(Color.BLACK);
        g2d.drawRect(12, SPC+this.idx*DIM, LARGURA, DIM);
        this.fig.paint(g, false);

    }
}
