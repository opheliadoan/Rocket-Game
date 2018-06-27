
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class EnemyAttack {
    public Vector2D position;
    public BufferedImage image;
    public Vector2D velocity;


    public EnemyAttack() {
        this.position = new Vector2D();
        this.velocity = new Vector2D();
    }

    public void renderEnemyAttack(Graphics graphics) {
        graphics.drawImage(image, (int)this.position.x, (int)this.position.y,
                20, 20, null);
    }

    public void runAttack() {
        this.position.addUp(this.velocity);
    }

}
