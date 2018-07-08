package GameCharacter.Player;

import Base.GameObject;
import Base.Vector2D;
import Renderer.PolygonRenderer;

import java.awt.*;

public class Player extends GameObject {

    public double angle = 0.0;
    public Vector2D velocity = new Vector2D();

    public Player() {
        this.renderer = new PolygonRenderer(
                Color.RED,
                new Vector2D(),
                new Vector2D(0, 16),
                new Vector2D(20, 8)
        );

        this.attributes.add(new PlayerShoot());
        this.attributes.add(new PlayerMove());
    }

    @Override
    public void run() {
        super.run();
        ((PolygonRenderer) this.renderer).angle = this.angle;

    }

}