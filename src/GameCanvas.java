import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

//Used to add details to the window
public class GameCanvas extends JPanel {

    BufferedImage starImage;
    BufferedImage enemyImage;
    BufferedImage playerImage;

    //BackBuffered
    BufferedImage backBuffered;
    Graphics graphics;

    public int positionXStar = 400;
    public int positionYStar = 150;

    public int positionXEnemy = 1000; //col
    public int positionYEnemy = 500;  //row

    public int positionXPlayer = 500;
    public int positionYPlayer = 300;

    public GameCanvas() {
        //Set up the Canvas
        this.setSize(1024, 600);

        this.backBuffered = new BufferedImage(1024, 600, BufferedImage.TYPE_4BYTE_ABGR);
        //get the graphics from the backBuffered
        this.graphics = this.backBuffered.getGraphics();

        //Load the star image
        try {
            this.starImage = ImageIO.read(new File("resources/images/star.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            this.enemyImage = ImageIO.read(new File("resources/images/circle.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            this.playerImage = ImageIO.read(new File("resources/images/circle.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }


        this.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        //Draw the images on the backBuffered
        g.drawImage(this.backBuffered, 0, 0,null);

    }

    public void renderAll() {
        //super.paintComponent(g);
        //Color color = new Color(): according to RB

        //Draw the background
        this.graphics.setColor(Color.BLACK);
        //draw a rectangular
        this.graphics.fillRect(0,0,1024,600);

        //Add the details
        this.graphics.drawImage(this.starImage, this.positionXStar, this.positionYStar, 5, 5,null);
        this.graphics.drawImage(this.enemyImage, this.positionXEnemy, this.positionYEnemy, 20, 20, null);
        this.graphics.drawImage(this.playerImage, this.positionXPlayer, this.positionYPlayer, 20, 20, null);

        this.repaint();
    }

}
