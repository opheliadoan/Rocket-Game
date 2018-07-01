import java.awt.*;

public class BulletPlayer  {

    public Vector2D position;
    public Renderer renderer;
    public Vector2D velocity;

    public BulletPlayer() {
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/star.png", 7, 7);
    }

    public void render(Graphics graphics) {
        this.renderer.render(graphics, this.position);
    }

    public void run() {
        this.position.addUp(this.velocity);
    }

}
