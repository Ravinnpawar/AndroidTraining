package com.mobileappguru.androidtraining

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

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

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
        Toast.makeText(this, "First Name: "+firstNameTextInputEditText.text+"\nLast Name: "+lastNameTextInputEditText.text+"\nPhone Number: "+phoneTextInputEditText.text, Toast.LENGTH_SHORT).show()
    }
}