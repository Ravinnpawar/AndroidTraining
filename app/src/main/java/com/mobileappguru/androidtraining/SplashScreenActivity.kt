package com.mobileappguru.androidtraining

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Log.i(localClassName,"On Splash Screen")
        Handler().postDelayed({
            startActivity(Intent(this,WelcomeActivity::class.java))
            Log.i(localClassName,"" +
                    "Running Handler")
            finish()
        },2000)
    }
}