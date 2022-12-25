package com.example.sharepreferenceapplication.sharepref

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.sharepreferenceapplication.MainActivity
import com.example.sharepreferenceapplication.R
import com.example.shareprefernce.sharepref.PreferenceHelper
import com.example.shareprefernce.sharepref.PreferenceHelper.get
import com.example.shareprefernce.sharepref.PreferenceHelper.set

class SingInActivity : AppCompatActivity() , View.OnClickListener {
    lateinit var sharPre: SharedPreferences
    var id = ""
    var name = ""
    var email = ""
    var number = ""
    var password = ""
    var resetpassword = ""
    lateinit var btnLogin: Button
    lateinit var registration: TextView
    lateinit var edtId: EditText
    lateinit var edtEmailLogin: EditText
    lateinit var edtPasswordLogin: EditText
    lateinit var ForgotPass: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sing_in)

        edtEmailLogin = findViewById(R.id.edtEmailLogin)
        edtPasswordLogin = findViewById(R.id.edtPasswordLogin)
        btnLogin = findViewById(R.id.btnLogin)
        ForgotPass = findViewById(R.id.txtForgetPassword)
        registration = findViewById(R.id.txt_sing_Up)

        sharPre = PreferenceHelper.customPrefs(this)
        btnLogin.setOnClickListener(this)
      ForgotPass.setOnClickListener(this)
        registration.setOnClickListener(this)
        ForgotPass.setOnClickListener(this)
        getIntentData()
    }

    private fun getIntentData() {
        id = sharPre[USER_ID, ""]!!
        name = sharPre[USER_NAME, ""]!!
        email = sharPre[USER_EMAIL, ""]!!
        number = sharPre[USER_NUMBER, ""]!!
        password = sharPre[USER_CONFNEWPASS, ""]!!

    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btnLogin -> {
                val email = edtEmailLogin.text.toString().trim()
                val password = edtPasswordLogin.text.toString().trim()

                if (edtEmailLogin.text.toString().isEmpty()) {
                    edtEmailLogin.error = "CANT BLANK"
                    edtEmailLogin.requestFocus()

                } else if (!Patterns.EMAIL_ADDRESS.matcher(edtEmailLogin.text.toString())
                        .matches()
                ) {
                    edtEmailLogin.error = "VALID EMAIL"
                } else if (edtPasswordLogin.text.toString().isEmpty()) {
                    edtPasswordLogin.error = "CANT BLANK"
                    edtPasswordLogin.requestFocus()
                } else if (edtEmailLogin.text.toString()
                        .contentEquals(email) && edtPasswordLogin.text.toString()
                        .contentEquals(password)
                ) {
                    Toast.makeText(this, "Sucessfully Login", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, ViewDataActivity::class.java))
                    sharPre["IS_LOGIN"] = true
                    finish()

                } else {
                    Toast.makeText(this, "First Registration ", Toast.LENGTH_SHORT).show()

                }
            }


            R.id.txt_sing_Up -> {
                startActivity(Intent(this, RegistrationActivity::class.java))
            }
            R.id.txtForgetPassword -> {
                startActivity(Intent(this, ForgotPasswordActivity::class.java))
            }
        }

    }
}

