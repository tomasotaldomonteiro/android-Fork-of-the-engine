package com.innoveworkshop.gametest.engine

import android.graphics.Canvas
import android.graphics.Paint

class Circle(x: Float, y: Float, var radius: Float, color: Int) : GameObject(x, y), Caged {
    var rigidbody: Rigidbody = Rigidbody()
    var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)

    init {
        paint.color = color
        paint.style = Paint.Style.FILL
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas!!.drawCircle(position.x, position.y, radius, paint)
    }

    override fun hitLeftWall(): Boolean {
        return (position.x - radius) <= gameSurface!!.width
    }

    override fun hitRightWall(): Boolean {
        return (position.x + radius) >= gameSurface!!.width
    }

    override val isFloored: Boolean
        get() = (position.y + radius) >= gameSurface!!.height

    fun hitCeiling(): Boolean {
        return (position.y - radius) <= 0
    }

    fun updatePhysics(deltatime: Float) {
        rigidbody.update(deltatime)
        position.x += rigidbody.velocity.x * deltatime
        position.y += rigidbody.velocity.y * deltatime

        if (hitLeftWall() || hitRightWall()) {
            rigidbody.velocity.x = -rigidbody.velocity.x
        }
        if (hitCeiling() || isFloored) {
            rigidbody.velocity.y = -rigidbody.velocity.y
        }
    }
}