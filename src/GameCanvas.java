/**
 * SOLID Principles: https://scotch.io/bar-talk/s-o-l-i-d-the-first-five-principles-of-object-oriented-design
 */



import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameCanvas extends JPanel {


    //BackBuffered
    BufferedImage backBuffered;
    Graphics graphics;

    List<Star> stars;
    public Player player = new Player();
    public Enemy enemy = new Enemy();

//    TriangularPlayer triangularPlayer;
    Background background;


    private Random random = new Random();
    private int count = 0;


    public GameCanvas() {
        this.setSize(1024, 600);

        this.setupBackBuffered();

        this.setupCharacter();

        this.setVisible(true);
    }

    private void setupBackBuffered() {
        this.background = new Background();
        this.backBuffered = new BufferedImage(1024, 600, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();
    }

    private void setupCharacter() {
        this.stars = new ArrayList<>();
       this.setUpPlayer();
       this.setUpEnemy();
//        this.triangularPlayer = new TriangularPlayer();
//        this.enemyImage = this.loadImage();

    }

    private void setUpPlayer() {
        this.player.position.set(100, 200);
//        this.player.image = this.loadImage("resources/images/circle.png");
    }

    private void setUpEnemy() {
        this.enemy.position.set(800, 400);
        this.enemy.image = this.loadImage("resources/images/circle.png");
    }


    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {
       this.background.render(graphics);

        this.stars.forEach(star -> star.render(graphics));
//        this.star.render(this.graphics);

        this.player.renderPlayer(graphics);
        this.enemy.renderEnemy(graphics);

//        this.triangularPlayer.renderTriangularPlayer(graphics);

        this.repaint();
    }

    public void runAll() {
        this.createStar();
        this.stars.forEach(star -> star.run());
//        this.star.run();

        this.runEnemy();
    }

    private void runEnemy() {
        Vector2D velocity = this.player.position
                .subtract(this.enemy.position)
                .normalize().multiply(1.5f);
        this.enemy.velocity.set(velocity);
        this.enemy.run();
    }

    private void createStar() {

        if (this.count == 10) {
            Star star = new Star(1024, this.random.nextInt(600),
                    this.loadImage("resources/images/star.png"),
                    -this.random.nextInt(5) +1, 0);
            this.stars.add(star);
            this.count = 0;
        } else {
            this.count += 1;
        }
    }

////    private void createEnemy() {
////        if (this.count == 100) {
////            Enemy enemy = new Enemy(this.random.nextInt(1024), this.random.nextInt(600),
////                    this.loadImage("resources/images/circle.png"),
////                    -this.random.nextInt(10) + 1, -this.random.nextInt(10) + 1);
////            this.enemies.add(enemy);
////            this.count = 0;
////        } else {
////            this.count += 1;
////        }
////    }
//
//    public void createPlayer() {
//        this.player = new Player(this.random.nextInt(1024), this.random.nextInt(600),
//                this.loadImage("resources/images/circle.png"));
//    }

    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            return null;
        }
    }

//    public void createTriangularPlayer() {
//        this.triangularPlayer = new TriangularPlayer(this.random.nextInt(1024), this.random.nextInt(600));
//    }
}