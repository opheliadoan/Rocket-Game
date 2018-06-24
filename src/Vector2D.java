public class Vector2D {
    //x-y coord
    public float x;
    public float y;

    public Vector2D() {
        this.x = 0;
        this.y = 0;
    }

    public Vector2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D set(float x, float y) {
        this.x = x;
        this.y = y;
        return this;
    }

    public Vector2D set(Vector2D vector2D) {
        return this.set(vector2D.x, vector2D.y);
    }

    public Vector2D addUp(float x, float y) {
        this.x += x;
        this.y += y;
        return this;
    }

    public Vector2D addUp(Vector2D vector2D) {
        return this.addUp(vector2D.x, vector2D.y);
    }

    public Vector2D add(float x, float y) {
        return new Vector2D(this.x + x, this.y + y);
    }

    public Vector2D add(Vector2D vector2D) {
        return this.add(vector2D.x, vector2D.y);
    }

    public Vector2D subtractBy(float x, float y) {
        this.x -= x;
        this.y -= y;
        return this;
    }

    public Vector2D subtractBy(Vector2D vector2D) {
        return subtractBy(vector2D.x, vector2D.y);
    }

    public Vector2D subtract (float x, float y) {
        return new Vector2D(this.x - x, this.y - y);
    }

    public Vector2D subtract(Vector2D vector2D) {
        return this.subtract(vector2D.x, vector2D.y);
    }

    public Vector2D multiply(float multiplier) {
        this.x *= multiplier;
        this.y *= multiplier;
        return this;
    }

    public float length() {
        float length = (float) Math.sqrt(this.x*this.x + this.y*this.y);
        return length;
    }

    public Vector2D copy() {
        return new Vector2D(this.x, this.y);
    }

    public Vector2D normalize() {
        return new Vector2D(this.x/this.length(), this.y/this.length());
    }

    public Vector2D rotate(double angle) {
        float rotateX = (float) ((this.x * Math.cos(angle)) - (this.y * Math.sin(angle)));
        float rotateY = (float) ((this.x * Math.sin(angle)) + (this.y * Math.cos(angle)));
        return new Vector2D(rotateX, rotateY);
    }
}
