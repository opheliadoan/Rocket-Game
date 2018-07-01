import java.awt.*;

public class BulletEnemy {

    public Vector2D position;
    public Renderer renderer;
    public Vector2D velocity;

    public BulletEnemy() {
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/circle.png", 7, 7);
    }

    public void render(Graphics graphics) {
        this.renderer.render(graphics, this.position);
    }

    public void run() {
        this.position.addUp(this.velocity);
    }

}
