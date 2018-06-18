/**
 * Name: Ophelia Doan
 * Date: 170618
 */

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameWindow extends JFrame {

    GameCanvas gameCanvas;
    long lastTime = 0;

    public GameWindow() {
        //Set up sizes
        this.setSize(1024, 600);

        //pass the Canvas into the gameWindow
        this.gameCanvas = new GameCanvas();
        this.add(this.gameCanvas);

        //Read the movement from the keyboard to move the player
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    gameCanvas.positionXPlayer -= 8;
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    gameCanvas.positionXPlayer += 8;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //System.out.println("keyReleased");
            }
        });

        //Exit when push red x
       this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });

        this.setVisible(true);
    }

    //Make the imgaes of thebackground move
    //Delay the speed of the star so it is visible
    public void gameLoop() {
        while(true) {
            //unix time
            long currTime = System.nanoTime();
            if (currTime - this.lastTime >= 17_000_000) {
                //Move the star
                this.gameCanvas.positionXStar -= 3;

                //Move the enemy
                this.gameCanvas.positionYEnemy -= 4;

                //Move the player
                //this.gameCanvas.positionXPlayer -= 4;

                this.gameCanvas.renderAll();
                this.lastTime = currTime;
            }
        }
    }
}
