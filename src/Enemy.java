import java.awt.*;
import java.awt.image.BufferedImage;

public class Enemy {

    public int positionXEnemy;
    public int positionYEnemy;
    public BufferedImage image;
    public int speedXEnemy;
    public int speedYEnemy;
    public int velocityXEnemy;
    public int velocityYEnemy;

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
//        velocityXEnemy = xPlayer - this.positionXEnemy;
//        velocityYEnemy = yPlayer - this.positionYEnemy;
//        double norm = Math.sqrt(velocityXEnemy*velocityXEnemy + velocityYEnemy*velocityYEnemy);
//
//        if(norm == 0) {
//            //Player and Enemy meet
//            System.out.println("Game Over");
//        } else {
//            velocityXEnemy *= this.speedXEnemy/norm;
//            velocityYEnemy *= this.speedYEnemy/norm;
//        }
//
//        this.positionXEnemy += velocityXEnemy;
//        this.positionYEnemy += velocityYEnemy;
//
//        if (this.positionXEnemy < 0 || this.positionXEnemy > 1024 - 40)
//            this.velocityXEnemy = -this.velocityYEnemy;
//
//        if (this.positionYEnemy < 0 || this.positionYEnemy > 600 - 40)
//            this.velocityYEnemy = -this.velocityXEnemy;
//    }

    public void runEnemy() {
        this.positionXEnemy += this.speedXEnemy;
        this.positionYEnemy += this.speedYEnemy;

        if (this.positionXEnemy < 0 || this.positionXEnemy > 1024 - 20)
            this.speedXEnemy = -this.speedXEnemy;

        if (this.positionYEnemy < 0 || this.positionYEnemy > 600 - 20)
            this.speedYEnemy = -this.speedYEnemy;
    }

}
