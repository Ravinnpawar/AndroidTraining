package com.mobileappguru.androidtraining

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("Method Called","From Activity Main onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.i("Method Called","From Activity Main onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Method Called","From Activity Main onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Method Called","From Activity Main onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Method Called","From Activity Main onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("Method Called","From Activity Main onRestart")
    }

    override fun onDestroy() {
        Log.i("Method Called","From Activity Main onDestroy")
        super.onDestroy()

    }

    fun clickMe(view: View) {
        //Log.i("Method Called","From Activity Main Button Clicked")
        val intent=Intent(this,SecondActivity::class.java)
        startActivity(intent)
    }
}