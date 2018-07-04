import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateStar{
    public List<Star> stars;
    private Random random;
    private int countStar;

    public CreateStar() {
        this.stars = new ArrayList<>();
        this.random = new Random();
    }

    public void run() {
        if (countStar == 10) {
            Star star = new Star();
            star.position.set(1023, (float)random.nextInt(600));
            star.velocity.set(-(this.random.nextInt(5)+1), 0);
            this.stars.add(star);
            this.countStar = 0;
        } else {
            this.countStar += 1;
        }

        this.stars.forEach(star -> star.run());
    }
}
