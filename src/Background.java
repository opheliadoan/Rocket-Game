import java.awt.*;

public class Background extends GameObject{

    public Background() {
        this.position = new Vector2D();
        this.renderer = new BackgroundRenderer(Color.BLACK, 1024, 600);
    }
//    public void render(Graphics graphics) {
//       super.render(graphics);
//    }
}
