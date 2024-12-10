package com.innoveworkshop.gametest.engine

import android.graphics.Canvas

abstract class GameObject {
    var position: Vector

    protected var gameSurface: GameSurface? = null
    var bounce: Boolean = false
        protected set

    constructor(position: Vector) {
        this.position = position
    }

    @JvmOverloads
    constructor(x: Float = 0f, y: Float = 0f) {
        position = Vector(x, y)
    }

    fun setPosition(x: Float, y: Float) {
        position.x = x
        position.y = y
    }

    fun bounce() {
        //gameSurface!!.removeGameObject(this)
        bounce = true
    }

    open fun onStart(surface: GameSurface?) {
        this.gameSurface = surface
    }

    open fun onFixedUpdate() {
        if (bounce) {
            setPosition(100f, 100f)
        }
    }

    open fun onDraw(canvas: Canvas?) {}
}
