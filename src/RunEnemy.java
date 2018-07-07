import java.util.Random;

public class RunEnemy extends GameObject{
    public Enemy enemy;
    public EnemyAttack enemyAttack;
    private Random random;

    public RunEnemy() {
        this.enemy = new Enemy();
        this.enemyAttack = new EnemyShoot();
        this.random = new Random();
    }

    public void run() {
        super.run();
        this.enemy.run();
        this.enemyAttack.run(this.enemy);
        this.backtoScreen();
    }

    private void backtoScreen() {
        if (enemy.position.x < 0) {
            enemy.position.set(1024, (float)this.random.nextInt(600));
        }

        if (enemy.position.x > 1024) {
            enemy.position.set(0, (float)this.random.nextInt(600));
        }

        if (enemy.position.y < 0) {
            enemy.position.set((float)this.random.nextInt(1024), 600);
        }

        if (enemy.position.y > 1024) {
            enemy.position.set((float)this.random.nextInt(1024), 0);
        }
    }
}
