import java.awt.*;

public class Player extends GameObject{


    public Vector2D velocity;
    public double angle = 0.0;
    public PlayerAttack playerAttack;


    public Player() {
        this.renderer = new PolygonRenderer(Color.RED,
                new Vector2D(),
                new Vector2D(0, 16),
                new Vector2D(20, 8));
        this.velocity = new Vector2D(3.5f, 0);
        this.playerAttack = new PlayerShoot();
    }

    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        //The object remains the same, just the type changes from Renderer to PolygonRenderer
        ((PolygonRenderer) this.renderer).angle = this.angle;
        this.playerAttack.run(this);
    }

    public void render(Graphics graphics) {
       super.run();
        ((PlayerShoot)this.playerAttack).bulletPlayers.forEach(bulletPlayer -> bulletPlayer.render(graphics));
    }
}
