package com.example.sharepreferenceapplication.simpleLogin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.sharepreferenceapplication.R


class RegisterActivity : AppCompatActivity() {
    lateinit var name: EditText
    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var mobilenumber: EditText
    lateinit var address: EditText
    lateinit var confirmpass:EditText
    lateinit var register: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        name = findViewById(R.id.etNewName)
        password = findViewById(R.id.etNewPassword)
        email = findViewById(R.id.etNewEmail)
        mobilenumber = findViewById(R.id.etNewMobileNumber)
        address = findViewById(R.id.etNewAddress)
        register = findViewById(R.id.btnNewRegister)

        register.setOnClickListener {

            val pref = getSharedPreferences("MYPREFS", Context.MODE_PRIVATE)
            val editor = pref.edit()

            val Name: String = name.getText().toString()
            val Password = password.getText().toString()
            val Email = email.getText().toString()
            val Mobilenumber = mobilenumber.getText().toString()
            val address = address.getText().toString()





            editor.putString("name", Name)
            editor.putString("email", Email)
            editor.putString("mobile",Mobilenumber)
            editor.putString("password",Password)
            editor.putString("address",address)

            editor.apply()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}