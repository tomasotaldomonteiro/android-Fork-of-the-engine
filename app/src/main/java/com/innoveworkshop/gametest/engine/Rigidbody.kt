package com.innoveworkshop.gametest.engine

import android.graphics.PointF

class Rigidbody {
    var velocity: PointF= PointF(0f, 0f)
    var acceleration: PointF= PointF(0f, 0f)
    var damping: Float = 1f

    fun applyForce(force: PointF) {
        acceleration.x += force.x
        acceleration.y += force.y
    }

    fun update(deltaTime: Float) {
        velocity.x += acceleration.x * deltaTime
        velocity.y += acceleration.y * deltaTime

        velocity.x *= damping
        velocity.y *= damping

        acceleration.set(0f,0f)
    }
}