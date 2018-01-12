package com.engine.galaga;

import com.engine.framework.display.Render;
import com.engine.framework.math.Rectangle;

import java.awt.*;

public class Lazer {

    static final Color COLOR = Color.red;

    //Instance Variables
    float speed;
    Rectangle body;

    public Lazer(float s, Rectangle b) {
        speed = s;
        body = b;
    }

    public void update() {
        body.y -= speed;
    }

    public void draw(Render r) {
        r.drawRectangle(body, COLOR);
    }
}
