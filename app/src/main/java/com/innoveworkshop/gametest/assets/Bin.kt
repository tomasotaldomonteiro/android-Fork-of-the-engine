package com.innoveworkshop.gametest.assets

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.innoveworkshop.gametest.engine.GameSurface
import com.innoveworkshop.gametest.engine.Rectangle
import com.innoveworkshop.gametest.engine.Vector

class Bin(
    private val leftWallX: Float,
    private val bottomWallY: Float,
    private val width: Float,
    private val height: Float,
    private val thickness: Float = 20f // Wall thickness
) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.BLUE
        style = Paint.Style.FILL
    }

     //Positions of walls (calculated based on inputs)
    private val leftWall = Wall(leftWallX, bottomWallY - height, leftWallX + thickness, bottomWallY)
    private val rightWall = Wall(leftWallX + width - thickness, bottomWallY - height, leftWallX + width, bottomWallY)
    private val bottomWall = Wall(leftWallX + thickness, bottomWallY - thickness, leftWallX + width - thickness, bottomWallY)


    // Draw the bin walls
    fun CreateBin(surface: GameSurface) {
        val bin = Rectangle(Vector(surface.width.toFloat()/2, surface.height.toFloat()/2),50f, 20f, Color.RED)
        surface.addGameObject(bin)
    }

    // Check if a circle collides with any of the walls
    fun checkCollision(circleX: Float, circleY: Float, radius: Float): Boolean {
        return (
                leftWall.checkCollision(circleX, circleY, radius) ||
                        rightWall.checkCollision(circleX, circleY, radius) ||
                        bottomWall.checkCollision(circleX, circleY, radius)
                )
    }

    // Wall class for simpler handling
    class Wall(val left: Float, val top: Float, val right: Float, val bottom: Float) {
        fun draw(canvas: Canvas, paint: Paint) {
            canvas.drawRect(left, top, right, bottom, paint)
        }

        //        // Circle-rectangle collision detection
        fun checkCollision(circleX: Float, circleY: Float, radius: Float): Boolean {
            // Find the closest point on the wall to the circle's center
            val closestX = circleX.coerceIn(left, right)
            val closestY = circleY.coerceIn(top, bottom)

            // Calculate the distance between the circle's center and this closest point
            val distanceX = circleX - closestX
            val distanceY = circleY - closestY

            // Check if the distance is less than the radius
            return (distanceX * distanceX + distanceY * distanceY) < (radius * radius)
        }
    }
}