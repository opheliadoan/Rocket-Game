import javax.swing.*;

public class GameWindow extends JFrame {

    GameCanvas gameCanvas;

    public GameWindow() {
        //Set up sizes
        this.setSize(1024, 600);

        //pass the Canvas into the game window
        this.gameCanvas = new GameCanvas();
        this.add(this.gameCanvas);

        this.setVisible(true);
    }
}
