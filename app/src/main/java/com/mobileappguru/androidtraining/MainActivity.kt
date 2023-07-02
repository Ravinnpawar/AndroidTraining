package com.mobileappguru.androidtraining

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.mobileappguru.MyApp
import com.mobileappguru.data.MyDataParser
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var myDataParser: MyDataParser

    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (applicationContext as MyApp).appComponent.inject(this)
        val myDataList = myDataParser.parseData()
        Log.i("Method Called","From Activity Main onCreate"+myDataList.size)


        //Coroutines Example --
        // Example 1: Global Scope
        GlobalScope.launch {
            delay(1000)
            println("Task 1 completed")
        }

        // Example 2: Coroutine Scope
        runBlocking {
            launch {
                delay(2000)
                println("Task 2 completed")
            }

            delay(500)
            println("Task 3 completed")
        }

        // Example 3: Coroutine Context
        runBlocking {
            launch(Dispatchers.IO) {
                delay(1500)
                println("Task 4 completed on IO Dispatcher")
            }

            launch(Dispatchers.Default) {
                delay(1000)
                println("Task 5 completed on Default Dispatcher")
            }

            delay(500)
            println("Task 6 completed on Main Dispatcher")
        }

        // Example 4: Coroutine Builders
        runBlocking {
            launch {
                delay(1000)
                println("Task 7 completed")
            }

            async{
                delay(1500)
                println("Task 8 completed asynchronously")
            }.await()


            println("All tasks completed")
        }
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
        val intent=Intent(this,WelcomeActivity::class.java)
        startActivity(intent)
    }
}