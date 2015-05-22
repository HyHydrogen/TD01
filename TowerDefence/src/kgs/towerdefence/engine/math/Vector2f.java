package kgs.towerdefence.engine.math;

public abstract class Vector2f {

    // x, y
    abstract float setX(float x);
    abstract float setY(float y);

    abstract float set(Vector2f vec);
    abstract float add(Vector2f vec);

    abstract float getX();
    abstract float getY();
    abstract float magnitude();

    abstract Vector2f copy();

}
