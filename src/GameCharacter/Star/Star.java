package GameCharacter.Star;

import Base.GameObject;
import Base.Vector2D;
import Renderer.ImageRenderer;

public class Star extends GameObject {

    public Vector2D velocity;

    //call to father class first
    public Star() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/star.png", 5, 5);
    }

    @Override
    public void run() {
        //Run father method
        super.run();
        this.position.addUp(this.velocity);
    }
}
