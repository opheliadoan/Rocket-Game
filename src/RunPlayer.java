import java.awt.*;
import java.util.Random;

public class RunPlayer extends GameObject{
    private Player player;
    private PlayerAttack playerAttack;
    private Random random;

    public RunPlayer(Player player) {
        this.player = player;
        this.playerAttack = new PlayerShoot();
        this.random = new Random();
    }

    @Override
    public void run() {
        super.run();
        this.player.position.addUp(this.player.velocity);
        ((PolygonRenderer) this.player.renderer).angle = this.player.angle;
        this.playerAttack.run(this.player);
        this.backtoScreen();
    }


    private void backtoScreen() {
        if (this.player.position.x < 0) this.player.position.set(1024, this.random.nextInt(600));

        if (this.player.position.x > 1024) this.player.position.set(0, this.random.nextInt(600));

        if (this.player.position.y < 0) this.player.position.set(this.random.nextInt(1024), 600);

        if (this.player.position.y > 600) this.player.position.set(this.random.nextInt(1024), 0);
    }

    @Override
    public void render(Graphics graphics) {
        super.run();
        this.player.render(graphics);
    }
}
