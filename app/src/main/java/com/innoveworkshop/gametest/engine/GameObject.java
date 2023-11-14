package com.innoveworkshop.gametest.engine;

import android.graphics.Canvas;
import android.view.SurfaceView;

public abstract class GameObject {
    public Vector position;

    protected GameSurface gameSurface = null;

    public GameObject() {
        this(0, 0);
    }

    public GameObject(Vector position) {
        this.position = position;
    }

    public GameObject(float x, float y) {
        position = new Vector(x, y);
    }

    public void setPosition(float x, float y) {
        position.x = x;
        position.y = y;
    }

    public void onStart(GameSurface surface) {
        this.gameSurface = surface;
    }

    public void onFixedUpdate() {}

    public void onDraw(Canvas canvas) {}
}
