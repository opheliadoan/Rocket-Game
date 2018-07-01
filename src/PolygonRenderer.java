import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class PolygonRenderer implements Renderer {

    private List<Vector2D> vertices;
    private Polygon polygon;
    public double angle = 0.0;
    private Color color;

    //... declare list, written in the end only, used only once in the param
    public PolygonRenderer(Color color, Vector2D... vertices) {
        this.color = color;
        this.vertices = Arrays.asList(vertices);
        this.polygon = new Polygon();
    }

    public void render(Graphics graphics, Vector2D position) {
        this.polygon.reset();

        Vector2D center = this.vertices
                .stream()
                .reduce(new Vector2D(), (v1, v2) -> v1.add(v2))
                .multiply(1.0f/(float)this.vertices.size())
                .rotate(this.angle);

        Vector2D translation = position.subtract(center);
        this.vertices
                .stream()
                .map(vertex -> vertex.rotate(angle))
                .map(vertex -> vertex.add(translation))
                .forEach(vertex -> polygon.addPoint((int)vertex.x, (int)vertex.y));

        graphics.setColor(this.color);
        graphics.fillPolygon(this.polygon);

    }
}
