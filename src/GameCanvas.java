
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameCanvas extends JPanel {

    BufferedImage backBuffered;
    Graphics graphics;

    public CreateStar createStar = new CreateStar();
    public RunEnemy runEnemy = new RunEnemy();

    Background background;

    public Player player = new Player();
    public Enemy enemy = new Enemy();


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
        this.setupPlayer();
        this.setupEnemy();
    }

    private void setupPlayer() {
        this.player.position.set(100, 200);
    }

    private void setupEnemy() {
        this.runEnemy.enemy.position.set(800, 400);
        this.enemy.position.set(500, 200);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {
        this.background.render(this.graphics);
        this.createStar.stars.forEach(star -> star.render(this.graphics));
        this.player.render(this.graphics);
        this.enemy.render(this.graphics);
        this.runEnemy.enemy.render(this.graphics);
        ((EnemyShoot)this.runEnemy.enemyAttack).bulletEnemies.forEach(bulletEnemy -> bulletEnemy.render(this.graphics));

        this.repaint();
    }

    public void runAll() {
        this.createStar.run();
        this.runEnemy();
        this.player.run();
    }

    private void runEnemy() {
        Vector2D velocity1 = this.player.position
                .subtract(this.runEnemy.enemy.position)
                .normalize()
                .multiply(1.5f);
        this.runEnemy.enemy.velocity.set(velocity1);
        this.runEnemy.run();

        Vector2D velocity2 = this.player.position
                .subtract(this.enemy.position)
                .normalize()
                .multiply(2.2f);
        this.enemy.velocity.set(velocity2);
        this.enemy.run();
    }
}