package com.mobileappguru.androidtraining

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.android.material.textfield.TextInputEditText
import com.mobileappguru.androidtraining.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityProfileBinding
    private lateinit var firstNameTextInputEditText: TextInputEditText
    private lateinit var lastNameTextInputEditText: TextInputEditText
    private lateinit var phoneTextInputEditText: TextInputEditText
    private lateinit var sharedPref:SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPref=getSharedPreferences("MyPreferences",Context.MODE_PRIVATE)
        //setSupportActionBar(binding.toolbar)

        firstNameTextInputEditText=findViewById(R.id.firstname)
        lastNameTextInputEditText=findViewById(R.id.lastname)
        phoneTextInputEditText=findViewById(R.id.phone_number)
        /*val navController = findNavController(R.id.nav_host_fragment_content_profile)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)*/

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAnchorView(R.id.fab)
                .setAction("Action", null).show()
        }
    }

    fun saveInfo(view: View) {
        //Toast.makeText(this, "First Name: "+firstNameTextInputEditText.text+"\nLast Name: "+lastNameTextInputEditText.text+"\nPhone Number: "+phoneTextInputEditText.text, Toast.LENGTH_SHORT).show()
        val editor=sharedPref.edit()
        editor.putString("firstName",firstNameTextInputEditText.text.toString())
        editor.putString("lastName",lastNameTextInputEditText.text.toString())
        editor.putString("phoneNumber",phoneTextInputEditText.text.toString())
        editor.apply()

        if (!firstNameTextInputEditText.text.isNullOrEmpty()){

            val intent=Intent(this,WelcomeActivity::class.java)
            startActivity(intent)
        }
        else{
            Toast.makeText(this, "Enter First Name", Toast.LENGTH_SHORT).show()
        }
    }
}