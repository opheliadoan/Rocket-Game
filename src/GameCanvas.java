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

    BufferedImage backBuffered;
    Graphics graphics;

    int countStar = 0;

    ArrayList<Star> stars;

    Background background;

    public Player player = new Player();
    public Enemy enemy = new Enemy();
//    public Star star = new Star();

    private Random random = new Random();


    public GameCanvas() {
        this.setSize(1024, 600);

        this.setupBackBuffered();

        this.setupCharacter();

        this.setVisible(true);
    }

    private void setupBackBuffered() {
        this.backBuffered = new BufferedImage(1024, 600, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();
    }

    private void setupCharacter() {
        this.background = new Background();
        this.stars = new ArrayList<>();

        this.setupPlayer();
        this.setupEnemy();
    }

    private void setupPlayer() {
        this.player.position.set(100, 200);
    }

    private void setupEnemy() {
        this.enemy.position.set(800, 400);
        this.enemy.image = this.loadImage("resources/images/circle.png");
    }

    private void setupStar() {
        if (this.countStar == 10) {
            Star star = new Star();
            star.position.set(0, (float)this.random.nextInt(600));
            star.image = this.loadImage("resources/images/star.png");

            this.stars.add(star);

            this.countStar = 0;
        } else {
            this.countStar += 1;
        }

//        this.star.position.set(0, (float)this.random.nextInt(600));
//        this.star.image = this.loadImage("resources/images/star.png");

//        this.stars.add(star);
//        this.countStar = 0;
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {
        this.background.render(this.graphics);
        this.stars.forEach(star -> star.renderStar(graphics));
//        this.star.renderStar(this.graphics);
        this.player.renderPlayer(this.graphics);
        this.enemy.renderEnemy(this.graphics);

        this.repaint();
    }

    public void runAll() {
        this.setupStar();
        this.runStar();
        this.runEnemy();
        this.player.run();
    }

    private void runEnemy() {
        Vector2D velocity = this.player.position
                .subtract(this.enemy.position)
                .normalize()
                .multiply(1.5f);
        this.enemy.velocity.set(velocity);
        this.enemy.run();
    }

    private void runStar() {
        Vector2D velocity = new Vector2D((float)this.random.nextInt(8) + 1, 0);
        this.stars.forEach(star -> star.velocity.set(velocity));
        this.stars.forEach(star -> star.run());

//        Vector2D velocity = new Vector2D((float)this.random.nextInt(8) + 1, 0);
//        this.star.velocity.set(velocity);
//        this.star.run();
    }

    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            return null;
        }
    }
}