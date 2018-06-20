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

    public int positionXStar1 = rand.nextInt(1024);
    public int positionYStar1 = rand.nextInt(600);

    public int positionXStar2 = rand.nextInt(1024);
    public int positionYStar2 = rand.nextInt(600);

    public int positionXStar3 = rand.nextInt(1024);
    public int positionYStar3 = rand.nextInt(600);

    public int positionXStar4 = rand.nextInt(1024);
    public int positionYStar4 = rand.nextInt(600);

    public int positionXStar5 = rand.nextInt(1024);
    public int positionYStar5 = rand.nextInt(600);

    public int positionXStar6 = rand.nextInt(1024);
    public int positionYStar6 = rand.nextInt(600);

    public int positionXStar7 = rand.nextInt(1024);
    public int positionYStar7 = rand.nextInt(600);

    public int positionXStar8 = rand.nextInt(1024);
    public int positionYStar8 = rand.nextInt(600);


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

    //Get the random positions of the star
    public void setPositionStar() {
//        ArrayList<Point> list = new ArrayList<>();
//                  for (int i = 0; i < 600; i++) {
//                      for (int j = 0; j < 1024; j++) {
//                          list.add(new Point(i, j));
//                      }
//                  }
//
//                  Point point = list.remove(rand.nextInt(list.size()));
//                  this.positionXStar1 = point.y;
//                  this.positionYStar1 = point.x;
//
//                  point = list.remove(rand.nextInt(list.size()));
//                  this.positionXStar2 = point.y;
//                  this.positionYStar2 = point.x;
//
//                  point = list.remove(rand.nextInt(list.size()));
//                  this.positionXStar3 = point.y;
//                  this.positionYStar3 = point.x;



//          this.positionXStar1 = rand.nextInt(1024);
//                  this.positionYStar1 = rand.nextInt(600);
//
//                  do {
//                      this.positionXStar2 = rand.nextInt(1024);
//                      this.positionYStar2 = rand.nextInt(600);
//                  } while (this.positionXStar2 == this.positionXStar1 && this.positionYStar2 == this.positionYStar1);
//
//                  do {
//                      this.positionXStar3 = rand.nextInt(1024);
//                      this.positionYStar3 = rand.nextInt(600);
//                  } while ((this.positionXStar3 == this.positionXStar1 && this.positionYStar3 == this.positionYStar1)
//                          || (this.positionXStar3 == this.positionXStar2 && this.positionYStar3 == this.positionYStar2));

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
        this.graphics.drawImage(this.starImage, this.positionXStar1, this.positionYStar1, 5, 5,null);
        this.graphics.drawImage(this.starImage, this.positionXStar2, this.positionYStar2, 5, 5,null);
        this.graphics.drawImage(this.starImage, this.positionXStar3, this.positionYStar3, 5, 5,null);
        this.graphics.drawImage(this.starImage, this.positionXStar4, this.positionYStar4, 5, 5,null);
        this.graphics.drawImage(this.starImage, this.positionXStar5, this.positionYStar5, 5, 5,null);
        this.graphics.drawImage(this.starImage, this.positionXStar6, this.positionYStar6, 5, 5,null);
        this.graphics.drawImage(this.starImage, this.positionXStar7, this.positionYStar7, 5, 5,null);
        this.graphics.drawImage(this.starImage, this.positionXStar8, this.positionYStar8, 5, 5,null);

        this.graphics.drawImage(this.enemyImage, this.positionXEnemy, this.positionYEnemy, 20, 20, null);
        this.graphics.drawImage(this.playerImage, this.positionXPlayer, this.positionYPlayer, 20, 20, null);

        this.repaint();
    }

}
