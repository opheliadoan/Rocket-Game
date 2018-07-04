
import java.awt.*;

public class Enemy extends GameObject{

    public Vector2D velocity;
    public EnemyAttack enemyAttack;

    public Enemy() {
        this.renderer = new ImageRenderer("resources/images/circle.png", 20, 20);
        this.velocity = new Vector2D();
        this.enemyAttack = new EnemyShoot();
    }

    public void run() {
        super.run();
        this.position.addUp(this.velocity);
    }

    @Override
    public void render(Graphics graphics) {
        super.render(graphics);
    }
}
