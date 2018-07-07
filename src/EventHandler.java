import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EventHandler implements KeyListener {
    private Player player;

    public EventHandler(Player player) {
        this.player = player;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.player.angle += 5.0;
        }

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.player.angle -= 5.0;
        }

        this.player.velocity.set(
                (new Vector2D(3.5f, 0.0f)).rotate(this.player.angle));
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
