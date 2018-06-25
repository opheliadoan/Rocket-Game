import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Star {

    public Vector2D position;
    public BufferedImage image;
    public Vector2D velocity;
    private Random random;

    public Star() {
        this.random = new Random();
       this.position = new Vector2D();
       this.velocity = new Vector2D();
    }

    public void renderStar(Graphics graphics) {
        graphics.drawImage(this.image, (int)this.position.x, (int)this.position.y, 5, 5, null);
    }

    public void run() {
        this.position.addUp(this.velocity);
    }
}
