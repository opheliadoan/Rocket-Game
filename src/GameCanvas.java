import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class GameCanvas extends JPanel {

    BufferedImage backBuffered;
    Graphics graphics;

    Background background;

    int countStar = 0;

    ArrayList<Star> stars;
    ArrayList<Bullet> enemyBullets = new ArrayList<>();
    ArrayList<Bullet> playerBullets = new ArrayList<>();

    public Player player = new Player();
    public Enemy enemy = new Enemy();
    public EnemyAttack enemyAttack = new EnemyAttack();

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
        this.setupEnemyAttack();

    }

    private void setupPlayer() {
        this.player.position.set(100, 200);
    }

    private void setupEnemy() {
        this.enemy.position.set(800, 400);
        this.enemy.image = this.loadImage("resources/images/circle.png");
    }

    private void setupEnemyAttack() {
        this.enemyAttack.position.set(200, 100);
        this.enemyAttack.image = this.loadImage("resources/images/circle.png");
    }

    private void setupStar() {
        if (this.countStar == 10) {
            Star star = new Star();
            star.position.set(1024, (float) this.random.nextInt(600));
            this.stars.add(star);

            this.countStar = 0;
        } else {
            this.countStar += 1;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {
        this.background.render(this.graphics);
        this.stars.forEach(star -> star.render(graphics));

//        this.star.renderStar(this.graphics);
        this.player.render(this.graphics);
        this.enemy.renderEnemy(this.graphics);

        this.enemyAttack.render(this.graphics);

        this.enemyBullets.forEach(bullet -> bullet.renderBullet(graphics));
        this.playerBullets.forEach(bullet -> bullet.renderBullet(graphics));

        this.repaint();
    }

    public void runAll() {
        this.setupStar();
        this.runStar();

        this.runEnemy();

        this.runEnemyAttack();

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

    private void runEnemyAttack() {
        Vector2D velocity = this.player.position
                .subtract(this.enemyAttack.position)
                .normalize()
                .multiply(1.5f);
        this.enemyAttack.velocity.set(velocity);
        this.enemyAttack.run();
    }

    private void runStar() {
        Vector2D velocity = new Vector2D(-(float)this.random.nextInt(8) + 1, 0);
        this.stars.forEach(star -> star.velocity.set(velocity));
        this.stars.forEach(star -> star.run());
    }

    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            return null;
        }
    }
}