import java.awt.*;
import java.awt.image.BufferedImage;



public class Player {

    public int positionXPlayer;
    public int positionYPlayer;
    public BufferedImage image;


    public Player(){}

    public Player(int positionXPlayer, int positionYPlayer, BufferedImage image) {
        this.positionXPlayer = positionXPlayer;
        this.positionYPlayer = positionYPlayer;
        this.image = image;

    }


    public void renderPlayer(Graphics graphics) {

        graphics.drawImage(image, this.positionXPlayer, this.positionYPlayer,
                30, 30, null);

    }

    public int relocateXPlayer() {
        if(this.positionXPlayer < 0) {
            return 1023;
        }

        if(this.positionXPlayer > 1024) {
            return 0;
        }

        return positionXPlayer;
    }
}
