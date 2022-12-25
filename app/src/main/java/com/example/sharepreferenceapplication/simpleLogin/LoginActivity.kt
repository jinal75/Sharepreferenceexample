package com.example.sharepreferenceapplication.simpleLogin

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.sharepreferenceapplication.R
import com.google.android.material.button.MaterialButton


class LoginActivity : AppCompatActivity() {
    lateinit var display: MaterialButton
    lateinit var Register: Button
    lateinit var etEmail: EditText
    lateinit var etPassword: EditText


    //  lateinit var mobile:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        //   mobile=findViewById(R.id.etNewMobileNumber)
        display = findViewById(R.id.btnLogin)
        Register = findViewById(R.id.btnRegister)

        val pref = getSharedPreferences("MYPREFS", Context.MODE_PRIVATE)


        var strEmail = pref.getString("email", null)
        var strPas = pref.getString("password", null)
        etEmail.setText(strEmail)
        etPassword.setText(strPas)

        display.setOnClickListener {

                val displayScreen = Intent(this, DisplayActivity::class.java)
                startActivity(displayScreen)
            }
            Register.setOnClickListener {
                val registerScreen = Intent(this, RegisterActivity::class.java)
                startActivity(registerScreen)
            }
        }

    }





