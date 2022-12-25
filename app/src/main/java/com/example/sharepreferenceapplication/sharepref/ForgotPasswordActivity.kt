package com.example.sharepreferenceapplication.sharepref

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.sharepreferenceapplication.R
import com.example.shareprefernce.sharepref.PreferenceHelper
import com.example.shareprefernce.sharepref.PreferenceHelper.set

class ForgotPasswordActivity : AppCompatActivity() {
    lateinit var sharPre: SharedPreferences
    lateinit var newpass:TextView
    lateinit var confirmnewpass:TextView
    lateinit var Reset:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        newpass=findViewById(R.id.edtNewPass)
        confirmnewpass=findViewById(R.id.edtNewPass)
        Reset=findViewById(R.id.btnReset)
        sharPre= PreferenceHelper.customPrefs(this)
        intiview()
    }

    private fun intiview() {
        Reset.setOnClickListener {
            if (newpass.text.toString().isEmpty()) {
                newpass.error = "CANT BLANK"
            }else if(confirmnewpass.text.toString().isEmpty()) {
               confirmnewpass.error = "CANT BLANK"
            }else if (confirmnewpass.text.toString()==newpass.text.toString()){
                sharPre[USER_NEWPASS]=newpass.text.toString().trim()
                sharPre[USER_CONFNEWPASS]=confirmnewpass.text.toString().trim()
                startActivity(Intent(this,SingInActivity::class.java))
            } else{
                Toast.makeText(this, "verifiy password", Toast.LENGTH_SHORT).show()
            }
        }

    }
}