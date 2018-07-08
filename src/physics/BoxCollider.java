package physics;

import Base.Vector2D;

import java.awt.*;

public class BoxCollider {

    public Vector2D position;
    private int width;
    private int height;

    public BoxCollider (int width, int height) {
        this.width = width;
        this.height = height;
        this.position = new Vector2D();
    }

    public boolean checkCollision (BoxCollider boxCollider) {
        Rectangle r1 = new Rectangle((int) this.position.x, (int) this.position.y, this.width, this.height);
        Rectangle r2 = new Rectangle((int) boxCollider.position.x, (int) boxCollider.position.y,
                boxCollider.width, boxCollider.height);

        //Method used to check collision
        return r1.intersects(r2);
    }
}
