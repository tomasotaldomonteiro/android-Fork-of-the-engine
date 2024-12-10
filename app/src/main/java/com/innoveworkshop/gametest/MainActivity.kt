package com.innoveworkshop.gametest

import android.graphics.Color
import android.graphics.PointF
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.innoveworkshop.gametest.assets.Bin
import com.innoveworkshop.gametest.engine.Circle
import com.innoveworkshop.gametest.engine.GameObject
import com.innoveworkshop.gametest.engine.GameSurface
import com.innoveworkshop.gametest.engine.Rigidbody

import com.innoveworkshop.gametest.engine.Vector

class MainActivity : AppCompatActivity() {
    protected var gameSurface: GameSurface? = null
    protected var upButton: Button? = null
    var rigidbody: Rigidbody? = null
    protected var game: Game? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gameSurface = findViewById<View>(R.id.gameSurface) as GameSurface
        game = Game()
        gameSurface!!.setRootGameObject(game)

        setupControls()
    }

    private fun setupControls() {
        upButton = findViewById<View>(R.id.up_button) as Button
        upButton!!.setOnClickListener { game!!.circle!!.rigidbody.applyForce(PointF(0f, -700f)) }

    }

    inner class Game : GameObject() {
        var circle: Circle? = null
        var bin: Bin? = null
        override fun onStart(surface: GameSurface?) {
            super.onStart(surface)

            //val bin = Bin(100f, 100f, 20f, 20f)
            //surface!!.addGameObject(bin)
            circle = Circle(
                (surface!!.width / 2).toFloat(),
                (surface.height / 2).toFloat(),
                30f,
                Color.RED
            )

            surface.addGameObject(circle!!)

             //Initialize the bin
            val binX = (surface.width / 5).toFloat() // Centered horizontally
            val binY = (surface.height / 4).toFloat()           // Positioned at the bottom
            bin = Bin(binX, binY, 300f, 200f)

        }


        override fun onFixedUpdate() {
            super.onFixedUpdate()

            val deltaTime = 7.5f / 30f
//            circle!!.rigidbody.applyForce(PointF(0f, 9.8f))
//            circle!!.updatePhysics(deltaTime)
//
//
//            circle!!.position.x += circle!!.rigidbody.velocity.x * deltaTime
//            circle!!.position.y += circle!!.rigidbody.velocity.y * deltaTime
//
//            if (circle!!.hitLeftWall() || circle!!.hitRightWall()) {
//                circle!!.rigidbody.velocity.x = -circle!!.rigidbody.velocity.x
//            }
//            if (circle!!.hitCeiling() || circle!!.isFloored) {
//                circle!!.rigidbody.velocity.y = -circle!!.rigidbody.velocity.y
//            }
//

        }
    }
}