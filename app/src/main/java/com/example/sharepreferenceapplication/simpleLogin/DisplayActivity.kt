package com.example.sharepreferenceapplication.simpleLogin

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.sharepreferenceapplication.R


class DisplayActivity : AppCompatActivity() {
    lateinit var userName: TextView
    lateinit var emailId:TextView
    lateinit var passWord:TextView
    lateinit var mobileNumber:TextView
    lateinit var address:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)
        userName=findViewById(R.id.txt_name)
        emailId=findViewById(R.id.txtEmail)
        passWord=findViewById(R.id.txtpassword)
        mobileNumber=findViewById(R.id.txtMobilenumber)
        address=findViewById(R.id.txtaddress)
        val pref = getSharedPreferences("MYPREFS", MODE_PRIVATE)
        val display = pref.getString("display", "")




        userName.text = pref.getString("name","")
        emailId.text = pref.getString("email","")
        passWord.text = pref.getString("password","")
        mobileNumber.text = pref.getString("mobile","")
        address.text = pref.getString("address","")
    }

}