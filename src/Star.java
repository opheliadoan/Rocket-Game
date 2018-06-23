import java.awt.*;
import java.awt.image.BufferedImage;

public class Star {

    public int x;
    public int y;
    public BufferedImage imgae;
    public int velocityX;
    public int velocityY;

    public Star(int x, int y, BufferedImage imgae, int velocityX, int velocityY) {
        this.x = x;
        this.y = y;
        this.imgae = imgae;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
    }

    public Star(){}

    public void render(Graphics graphics) {
        graphics.drawImage(this.imgae, this.x, this.y, 5, 5, null);
    }

    public void run() {
        this.x += this.velocityX;
        this.y += this.velocityY;
    }
}
