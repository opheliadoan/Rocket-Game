package GameCharacter.Player;

import Base.GameObject;
import Base.Vector2D;
import Renderer.ImageRenderer;

public class BulletPlayer extends GameObject {

    public Vector2D velocity;

    public BulletPlayer() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/circle.png", 7, 7);
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
    }

}
