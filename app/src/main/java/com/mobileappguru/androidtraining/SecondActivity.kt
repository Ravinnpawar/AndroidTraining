package com.mobileappguru.androidtraining

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        Log.i("Method Called","From Activity Two onCreate")
    }
    override fun onStart() {
        super.onStart()
        Log.i("Method Called","From Activity Two onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Method Called","From Activity Two onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Method Called","From Activity Two onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Method Called","From Activity Two onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("Method Called","From Activity Two onRestart")
    }

    override fun onDestroy() {
        Log.i("Method Called","From Activity Two onDestroy")
        super.onDestroy()

    }

    fun clickToFinish(view :View){
        finish()
    }
}