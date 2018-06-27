import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Bullet {
    public Vector2D position;
    public Vector2D velocity;
    public BufferedImage image;

    public Bullet() {
        this.position = new Vector2D();
        this.velocity = new Vector2D();
    }

    public void renderBullet(Graphics graphics) {
        graphics.drawImage(this.image, (int)this.position.x, (int)this.position.y, 10, 10, null);
    }

    public void run() {
        this.position.addUp(this.velocity);
    }


}
