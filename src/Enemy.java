
import java.awt.*;
import java.awt.image.BufferedImage;


public class Enemy {

    public Vector2D position;
    public BufferedImage image;
    public Vector2D velocity;


    public Enemy() {
        this.position = new Vector2D();
        this.velocity = new Vector2D();

    }

    public void renderEnemy(Graphics graphics) {
        graphics.drawImage(image, (int)this.position.x, (int)this.position.y,
                20, 20, null);

    }

    //Ver2
    public void run() {
        this.position.addUp(this.velocity);
    }

}
