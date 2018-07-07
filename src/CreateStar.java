
import java.util.Random;

public class CreateStar extends GameObject {
    private Random random;
    private FrameCounter frameCounter;

    public CreateStar() {

        this.frameCounter = new FrameCounter(10);
        this.random = new Random();
    }

    @Override
    public void run() {
        super.run();
        if (this.frameCounter.run()) {
            Star star = new Star();
            star.position.set(1023, (float)random.nextInt(600));
            star.velocity.set(-(this.random.nextInt(5)+1), 0);
            GameObjectManager.instance.add(star);

            this.frameCounter.reset();
        }
    }
}
