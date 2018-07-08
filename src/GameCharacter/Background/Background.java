package GameCharacter.Background;

import Base.GameObject;
import Renderer.BackgroundRenderer;

import java.awt.*;

public class Background extends GameObject {
    public Background() {
        this.renderer = new BackgroundRenderer(
                Color.BLACK,
                1024,
                600
        );
    }
}