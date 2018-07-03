
import java.awt.*;
import java.util.*;

public class Enemy extends GameObject{

    public Vector2D velocity;
    public EnemyAttack enemyAttack;
    private Random random;

    public Enemy() {
        this.renderer = new ImageRenderer("resources/images/circle.png", 20, 20);
        this.velocity = new Vector2D();
        this.enemyAttack = new EnemyShoot();
        this.random = new Random();

    }

    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.enemyAttack.run(this);
        this.backtoScreen();
    }


    private void backtoScreen() {
        if (this.position.x < 0) this.position.set(1024, this.random.nextInt(600));

        if (this.position.x > 1024) this.position.set(0, this.random.nextInt(600));

        if (this.position.y < 0) this.position.set(this.random.nextInt(1024), 600);

        if (this.position.y > 600) this.position.set(this.random.nextInt(1024), 0);
    }

    @Override
    public void render(Graphics graphics) {
        super.render(graphics);
        ((EnemyShoot)this.enemyAttack)
                .bulletEnemies.forEach(bulletEnemy -> bulletEnemy.render(graphics));
    }
}
