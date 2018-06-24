import java.awt.*;
//import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Player {

    public Vector2D position;
    private List<Vector2D> vertices;
    private Polygon polygon;


    public Player() {
        this.position = new Vector2D();
        this.vertices = Arrays.asList(
                new Vector2D(),
                new Vector2D(0, 16),
                new Vector2D(20, 8)
        );
        this.polygon = new Polygon();
    }


    public void renderPlayer(Graphics graphics) {
        this.polygon.reset();

        Vector2D center = this.vertices
                .stream()
                .reduce(new Vector2D(), (v1, v2) -> v1.add(v2))  //v1 = first element of the list, v2 moves from the second, return v1 to Vector2D
                .multiply(1/this.vertices.size());

        Vector2D translation = this.position.subtract(center);

//        List<Vector2D> list = new ArrayList<>();
//        this.vertices.forEach(vertex -> list.add(vertex.add(translation)));
        this.vertices.
                stream()
                .map(vertex -> vertex.add(translation))
                .forEach(vertex -> polygon.addPoint((int)vertex.x, (int)vertex.y));  //map creates a new list, then goes thru the original
                                                                        // list and return the final to the new list



        graphics.setColor(Color.GREEN);
        graphics.fillPolygon(polygon);
//Ver1
//        graphics.drawImage(image, (int)this.position.x, (int)this.position.y,
//                30, 30, null);

    }

    public void runPlayer(){}

//    //Ver1
//    public int relocateXPlayer() {
//        if(this.position.x < 0) {
//            return 1023;
//        }
//
//        if(this.position.x > 1024) {
//            return 0;
//        }
//
//        return (int)this.position.x;
//    }
}
