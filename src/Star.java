
public class Star extends GameObject{

    public Vector2D velocity;

    //call to father class first
    public Star() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/star.png", 5, 5);
    }

    //Father Class already has it
//    public void render(Graphics graphics) {
//        this.renderer.render(graphics, this.position);
//    }

    @Override
    public void run() {
        //Run father method
        super.run();
        this.position.addUp(this.velocity);
    }
}
