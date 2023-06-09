package com.mobileappguru.androidtraining

import android.app.ActionBar.LayoutParams
import android.app.AlertDialog
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.SharedPreferences
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.PopupWindow
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.mobileappguru.receiver.PowerConnectReceiver
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


//Braodcast Receiver--
//-Static broadcast receiver
//-Dynamic BR-
//method to register BR-- registerReceiver()
//intentfilter
//
class WelcomeActivity : AppCompatActivity() {


    private lateinit var firstNameTextview: TextView
    private lateinit var lastNameTextview: TextView
    private lateinit var phoneNumber: TextView
    private lateinit var timeTextView: TextView
    private lateinit var dateTextView: TextView
    private lateinit var timeButton: Button
    private lateinit var dateButton: Button
    private lateinit var alertButton: Button
    private lateinit var popupButton: Button
    private lateinit var toastButton: Button
    private lateinit var webviewButton: Button
    private lateinit var emailButton: Button
    private lateinit var sendSMSButton: Button
    private lateinit var mapButton: Button
    private lateinit var recyclerViewButton: Button

    private val calendar=Calendar.getInstance()
    private lateinit var sharedPref:SharedPreferences

    private val powerConnectReceiver =PowerConnectReceiver()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        firstNameTextview=findViewById(R.id.firstname_text_value)
        lastNameTextview=findViewById(R.id.lastname_text_value)
        phoneNumber=findViewById(R.id.phone_text_value)

        timeTextView=findViewById(R.id.time_text)
        dateTextView=findViewById(R.id.date_text)

        timeButton=findViewById(R.id.time_button)
        dateButton=findViewById(R.id.date_button)
        alertButton=findViewById(R.id.button_alert)
        popupButton=findViewById(R.id.button_popup)
        toastButton=findViewById(R.id.button_toast)
        webviewButton=findViewById(R.id.button_webview)
        emailButton=findViewById(R.id.button_email)
        sendSMSButton=findViewById(R.id.button_text)
        mapButton=findViewById(R.id.button_map)
        recyclerViewButton=findViewById(R.id.button_recycleview)


        timeButton.setOnClickListener {
            showtimePickerDialog()
        }

        alertButton.setOnClickListener{
            showAlertDialog()
        }

        val anchorView= findViewById<Button>(R.id.button_popup)
        anchorView.setOnClickListener{
            showPopupDialog(it)
        }
        
        toastButton.setOnClickListener{
            showToastMessage()
        }

        webviewButton.setOnClickListener{
            val intent=Intent(this,WebViewActivity :: class.java)
            startActivity(intent)
        }
        emailButton.setOnClickListener{
            var intent=Intent(Intent.ACTION_SENDTO).apply {
                data= Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, arrayOf("ajay@gmail.com"))
                putExtra(Intent.EXTRA_SUBJECT,"Email Example to send")
            }
            val packgemanager=this.packageManager
            intent.setPackage("com.google.android.gm")
            //intent= packgemanager.getLaunchIntentForPackage("com.google.android.gm")!!
            if (intent!=null){
                startActivity(intent)
            }else {
                Toast.makeText(this, "No Email Application", Toast.LENGTH_SHORT).show()
            }
        }

        sendSMSButton.setOnClickListener{
            val intent=Intent(Intent.ACTION_SENDTO).apply {
                data=Uri.parse("smsto:1234567890")
                putExtra("sms_body", "Hello This is SMS Example")
            }
            startActivity(intent)
        }
        mapButton.setOnClickListener{
            val uri=Uri.parse("geo:37.7749,122.4194?q=San Fransisco")
            val intent=Intent(Intent.ACTION_VIEW,uri)

            startActivity(intent)

        }
        recyclerViewButton.setOnClickListener{
            val intent=Intent(this,RecyclerViewActivity::class.java)
            startActivity(intent)
        }

        sharedPref=getSharedPreferences("MyPreferences",Context.MODE_PRIVATE)
        firstNameTextview.text=sharedPref.getString("firstName","")
        lastNameTextview.text=sharedPref.getString("lastName","")
        phoneNumber.text=sharedPref.getString("phoneNumber","")

        val intentFilter =IntentFilter()
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED)
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED)
        registerReceiver(powerConnectReceiver,intentFilter)

    }

    private fun showToastMessage() {
        Toast.makeText(this, "This is example of Toast Message", Toast.LENGTH_SHORT).show()
    }

    private fun showPopupDialog(anchorView: View) {
        val inflater =getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popupView=inflater.inflate(R.layout.popup_layout, null)

        val popupWindow=PopupWindow(popupView,LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT)
        popupWindow.isOutsideTouchable=true
        popupWindow.isFocusable=true

        val closeButton=popupView.findViewById<Button>(R.id.close_button)
        closeButton.setOnClickListener{
            popupWindow.dismiss()
        }
        popupWindow.showAsDropDown(anchorView)

    }

    private fun showAlertDialog() {
        val alertDialog=AlertDialog.Builder(this)
        alertDialog.setTitle("Alert Dialog")
        alertDialog.setMessage("This is a example of AlertDialog")
        alertDialog.setPositiveButton("OK"){ alertDialog,which->
            alertDialog.dismiss()
        }

        alertDialog.setNegativeButton("Cancel"){
            alertDialog,which->
            alertDialog.dismiss()
        }
        alertDialog.setCancelable(false)
        alertDialog.show()
    }

    private fun showtimePickerDialog() {
        val timePickerDialog=TimePickerDialog(this,TimePickerDialog.OnTimeSetListener{
            _,hourOfDay,minute ->
            calendar.set(Calendar.HOUR_OF_DAY,hourOfDay)
            calendar.set(Calendar.MINUTE,minute)
            updateTimeTextView()
        },
        calendar.get(Calendar.HOUR_OF_DAY),
        calendar.get(Calendar.MINUTE),
        false)
        timePickerDialog.show()
    }

    private fun updateTimeTextView() {
        val timeFormat=SimpleDateFormat("hh:mm a", Locale.getDefault())
        val formattedTime=timeFormat.format(calendar.time)
        timeTextView.text=formattedTime
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu1 ->{
                Toast.makeText(this, "Selected Settings", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.menu2 -> {
                Toast.makeText(this, "Selected Exit", Toast.LENGTH_SHORT).show()
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        super.onDestroy()

        unregisterReceiver(powerConnectReceiver)
    }
}