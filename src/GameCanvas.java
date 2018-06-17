import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

//Used to add details to the window
public class GameCanvas extends JPanel {

    BufferedImage starImage;

    public GameCanvas() {
        //Set up the Canvas
        this.setSize(1024, 600);

        //Load the star image
        try {
            this.starImage = ImageIO.read(new File("resources/images/star.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        //super.paintComponent(g);
        //Color color = new Color() : according to RB

        //Draw the background
        g.setColor(Color.BLACK);
        //draw a rectangular
        g.fillRect(0,0,1024,600);

        //Add the details
        g.drawImage(this.starImage, 400, 200, null);
    }

}
