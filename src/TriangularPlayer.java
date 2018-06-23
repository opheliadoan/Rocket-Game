import java.awt.*;

public class TriangularPlayer {
    public int[] xPoints = {300, 320, 340};
    public int[] yPoints = {340, 300, 340};

    public TriangularPlayer() {}


    public void renderTriangularPlayer(Graphics graphics) {
        graphics.setColor(Color.GREEN);
        graphics.drawPolygon(xPoints, yPoints, 3);
    }
}
