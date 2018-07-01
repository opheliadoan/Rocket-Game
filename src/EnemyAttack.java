

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;


public class EnemyAttack {
    public Vector2D position;
    public BufferedImage image;
    public Vector2D velocity;
    private List<BulletEnemy> bulletEnemyList;
    private int count = 0;


    public EnemyAttack() {
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.bulletEnemyList = new ArrayList<>();
    }

    public void render(Graphics graphics) {
        graphics.drawImage(image, (int)this.position.x, (int)this.position.y,
                20, 20, null);
        this.bulletEnemyList.forEach(bulletEnemy -> bulletEnemy.render(graphics));
    }

    public void run() {
        this.position.addUp(this.velocity);

        if (this.count == 40) {
            for (double angle = 0.0; angle < 360.0; angle += 360.0 / 6.0) {
                BulletEnemy bulletEnemy = new BulletEnemy();
                bulletEnemy.position.set(this.position);
                bulletEnemy.velocity.set(
                        (new Vector2D(3.0f, 0.0f)).rotate(angle)
                );
                this.bulletEnemyList.add(bulletEnemy);
            }

            this.count = 0;
        } else {
            this.count += 1;
        }

        this.bulletEnemyList.forEach(bulletEnemy -> bulletEnemy.run());
    }

}
