package GameCharacter.Player;

import Base.GameObject;
import Base.GameObjectManager;
import Base.Vector2D;
import GameCharacter.Enemy.Enemy;
import Renderer.ImageRenderer;
import physics.BoxCollider;

public class BulletPlayer extends GameObject {

    public Vector2D velocity;
    public BoxCollider boxCollider;

    public BulletPlayer() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/circle.png", 7, 7);
        this.boxCollider = new BoxCollider(7, 7);
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);

        this.boxCollider.position.set(this.position.x - 4, this.position.y - 4);
        Enemy enemy = GameObjectManager.instance.checkCollision(this);
        if (enemy != null) {
            System.out.println("One Enemy Killed!!!");
            enemy.isAlive = false;
            this.isAlive = false;
        }
    }

}
