import java.awt.*;
import java.awt.image.BufferedImage;

public class Enemy {

    public int positionXEnemy;
    public int positionYEnemy;
    public BufferedImage image;
    public int speedXEnemy;
    public int speedYEnemy;
    public float difXEnemy;
    public float difYEnemy;

    public Enemy(int positionXEnemy, int positionYEnemy, BufferedImage image, int speedXEnemy, int speedYEnemy) {
        this.positionXEnemy = positionXEnemy;
        this.positionYEnemy = positionYEnemy;
        this.image = image;
        this.speedXEnemy = speedXEnemy;
        this.speedYEnemy = speedYEnemy;
    }

    public void renderEnemy(Graphics graphics) {
        graphics.drawImage(image, this.positionXEnemy, this.positionYEnemy,
                20, 20, null);
    }

//    public void runEnemy(int xPlayer, int yPlayer) {
//        difXEnemy = (float) (xPlayer - this.positionXEnemy);
//        difYEnemy = (float) (yPlayer - this.positionYEnemy);
//        float norm = Math.sqrt(difXEnemy*difXEnemy + difYEnemy*difYEnemy);
//
//        if(norm == 0) {
//            //Player and Enemy meet
//            System.out.println("Game Over");
//        } else {
//            this.positionXEnemy += this.difXEnemy/norm;
//            this.positionYEnemy += this.difYEnemy/norm;
//        }
//    }

    //Ver1
//    public void runEnemy() {
//        this.positionXEnemy += this.speedXEnemy;
//        this.positionYEnemy += this.speedYEnemy;
//
//        if (this.positionXEnemy < 0 || this.positionXEnemy > 1024 - 20)
//            this.speedXEnemy = -this.speedXEnemy;
//
//        if (this.positionYEnemy < 0 || this.positionYEnemy > 600 - 20)
//            this.speedYEnemy = -this.speedYEnemy;
//    }

}
