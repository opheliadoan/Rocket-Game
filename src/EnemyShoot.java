import java.util.ArrayList;
import java.util.List;

public class EnemyShoot implements EnemyAttack {
    public List<BulletEnemy> bulletEnemies;
    private FrameCounter frameCounter;

    public EnemyShoot() {
        this.bulletEnemies = new ArrayList<>();
        this.frameCounter = new FrameCounter(30);
    }

    @Override
    public void run(Enemy enemy) {

        if (this.frameCounter.run()) {

            for (double angle = 0.0; angle < 360.0; angle += 360.0 / 10.0) {
                BulletEnemy bulletEnemy = new BulletEnemy();
                bulletEnemy.position.set(enemy.position);
                bulletEnemy.velocity.set(
                        (new Vector2D(3.0f, 0.0f)).rotate(angle)
                );
                this.bulletEnemies.add(bulletEnemy);
            }

            this.frameCounter.reset();
        }

        this.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.run());

    }

}
