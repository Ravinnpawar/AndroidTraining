package com.mobileappguru.androidtraining

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.Window
import android.view.WindowManager
import kotlinx.coroutines.delay

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,0)
        setContentView(R.layout.activity_splash_screen)

        Log.i(localClassName,"On Splash Screen")
        startActivity(Intent(this,MainActivity::class.java))

       /* Handler().postDelayed({
            startActivity(Intent(this,MainActivity::class.java))
            Log.i(localClassName,"" +
                    "Running Handler")
            finish()
        },2000)*/
        /*Runnable {
            startActivity(Intent(this,MainActivity::class.java))
            Log.i(localClassName,"" +
                    "Running Handler")
            finish()
        }
        val runnable= Runnable {
            println("running in thread")

        }
        runnable.run()*/
    }
}