package kgs.towerdefence.engine.math;

public class Vector2f {
    private float x, y;

    // x, y
    public Vector2f(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void set(Vector2f vec) {
        setX(vec.getX());
        setY(vec.getY());
    }

    public void add(Vector2f vec) {
        setX(getX() + vec.getX());
        setY(getY() + vec.getY());
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float magnitude() {
        return (float) Math.abs(Math.sqrt((getX() * getX()) + (getY() * getY())));
    }

    public Vector2f copy() {
        return new Vector2f(getX(), getY());
    }

}
