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
    String enemyDirection = "upward";

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
                enemyMove();

                //Move the player
                //this.gameCanvas.positionXPlayer -= 4;

                this.gameCanvas.renderAll();
                this.lastTime = currTime;
            }
        }
    }

    /**
     * Enemy Move Diagonally
     * Its location are accordingly substracted
     */
    public void enemyMoveDiagonal() {
        this.gameCanvas.positionXEnemy -= 3;
        this.gameCanvas.positionYEnemy -= 3;
    }

    /**
     * Enemy reverses when it hit the wall
     * Its locations are accordingly added
     */
    public void enemyMoveReverseDiagonal() {
        this.gameCanvas.positionXEnemy += 3;
        this.gameCanvas.positionYEnemy += 3;
    }

    public void enemyMove() {
        if (this.gameCanvas.positionXEnemy > 1024 || this.gameCanvas.positionYEnemy > 600) {
            enemyMoveDiagonal();
            enemyDirection = "upward";
        }

        if (this.gameCanvas.positionXEnemy < 0 || this.gameCanvas.positionYEnemy < 0) {
            enemyMoveReverseDiagonal();
            enemyDirection = "downward";
        }

        switch(enemyDirection) {
            case "downward":
                enemyMoveReverseDiagonal();
                break;
            case "upward":
                enemyMoveDiagonal();
                break;
        }
    }
}
