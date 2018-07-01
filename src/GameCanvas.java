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
    ArrayList<Bullet> bullets = new ArrayList<>();
    int countBullet = 0;


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
            star.position.set(0, (float) this.random.nextInt(600));
//            star.image = this.loadImage("resources/images/star.png");
            this.stars.add(star);

            this.countStar = 0;
        } else {
            this.countStar += 1;
        }
    }

    private void setupEnemyBullet() {
        if(this.countBullet == 10) {
            Bullet bullet = new Bullet();
            bullet.position.set((this.enemyAttack.position));
            bullet.image = this.loadImage("resources/images/circle.png");

            this.enemyBullets.add(bullet);
            this.countBullet = 0;
        } else {
            this.countBullet += 1;
        }
    }

    private void setupPlayerBullet() {
        if(this.countBullet == 10) {
            Bullet bullet = new Bullet();
            bullet.position.set((this.player.position));
            bullet.image = this.loadImage("resources/images/powerup_shield.png");

            this.playerBullets.add(bullet);
            this.countBullet = 0;
        } else {
            this.countBullet += 1;
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

        this.enemyAttack.renderEnemyAttack(this.graphics);

        this.enemyBullets.forEach(bullet -> bullet.renderBullet(graphics));
        this.playerBullets.forEach(bullet -> bullet.renderBullet(graphics));

        this.repaint();
    }

    public void runAll() {
        this.setupStar();
        this.runStar();

        this.runEnemy();

        this.runEnemyAttack();

        this.setupEnemyBullet();
        this.enemyShootBullet();


        this.player.run();

        this.setupPlayerBullet();
        this.playerShootBullet();
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
        this.enemyAttack.runAttack();
    }


    private void runStar() {
        Vector2D velocity = new Vector2D((float)this.random.nextInt(8) + 1, 0);
        this.stars.forEach(star -> star.velocity.set(velocity));
        this.stars.forEach(star -> star.run());

//        Vector2D velocity = new Vector2D((float)this.random.nextInt(8) + 1, 0);
//        this.star.velocity.set(velocity);
//        this.star.run();
    }

    private void enemyShootBullet() {
        Vector2D velocity = new Vector2D(8f, 0);
//        Vector2D velocity = this.enemyAttack.velocity
//                .normalize()
//                .multiply(5);
        this.enemyBullets.forEach(bullet -> bullet.velocity.set(velocity));
        this.enemyBullets.forEach(bullet -> bullet.run());
    }

    private void playerShootBullet() {
        Vector2D velocity = new Vector2D(8f, 0);
//        Vector2D velocity = this.player.position
//                .normalize()
//                .multiply(5);
        this.playerBullets.forEach(bullet -> bullet.velocity.set(velocity));
        this.playerBullets.forEach(bullet -> bullet.run());
    }


    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            return null;
        }
    }
}