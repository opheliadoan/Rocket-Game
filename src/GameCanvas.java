/**
 * Name: Doan Phuong Anh
 * Date: 170618
 */

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

//Used to add details to the window
public class GameCanvas extends JPanel {

    BufferedImage starImage;
    BufferedImage enemyImage;
    BufferedImage playerImage;
    Random rand = new Random();

    //BackBuffered
    BufferedImage backBuffered;
    Graphics graphics;

    public ArrayList<Integer> listXStar = new ArrayList<>();
    public ArrayList<Integer> listYStar = new ArrayList<>();
    public ArrayList<Integer> listSpeedStar = new ArrayList<Integer>();


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

    //Get the random positions of eight stars
    public void setPositionStar() {
        for(int i = 0; i < 8; i++) {
            listXStar.add(rand.nextInt(1024));
            listYStar.add(rand.nextInt(600));
            listSpeedStar.add(rand.nextInt(15));
        }
    }

    public void renderAll() {
        //super.paintComponent(g);
        //Color color = new Color(): according to RB

        //Draw the background
        this.graphics.setColor(Color.BLACK);
        //draw a rectangular
        this.graphics.fillRect(0,0,1024,600);

        setPositionStar();

        //Add the details
        for(int i = 0; i < 8; i++) {
            this.graphics.drawImage(this.starImage, this.listXStar.get(i), this.listYStar.get(i), 5, 5, null);
        }

        this.graphics.drawImage(this.enemyImage, this.positionXEnemy, this.positionYEnemy, 20, 20, null);
        this.graphics.drawImage(this.playerImage, this.positionXPlayer, this.positionYPlayer, 20, 20, null);

        this.repaint();
    }

}
