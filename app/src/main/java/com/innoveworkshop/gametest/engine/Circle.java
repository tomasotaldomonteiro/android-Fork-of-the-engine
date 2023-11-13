package com.innoveworkshop.gametest.engine;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Circle extends GameObject {
    public float radius;
    public Paint paint;

    public Circle(float x, float y, float radius, int color) {
        super(x, y);
        this.radius = radius;

        // Set up the paint.
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(color);
        paint.setStyle(Paint.Style.FILL);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(position.x, position.y, radius, paint);
    }
}
