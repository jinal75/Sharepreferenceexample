package com.example.sharepreferenceapplication.sharepref

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import com.example.sharepreferenceapplication.R
import com.example.shareprefernce.sharepref.PreferenceHelper
import com.example.shareprefernce.sharepref.PreferenceHelper.get
import com.example.shareprefernce.sharepref.PreferenceHelper.set

class RegistrationActivity : AppCompatActivity() {
    lateinit var sharePre: SharedPreferences
    lateinit var btnSignup:Button
    lateinit var edtPassReg:EditText
    lateinit var edtConfirmPass:EditText
    lateinit var edtID:EditText
    lateinit var edtName:EditText
    lateinit var edtEmailReg:EditText
    lateinit var edtNumber:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        btnSignup=findViewById(R.id.btnSignup)
        edtID=findViewById(R.id.edtID)
        edtName=findViewById(R.id.edtName)
        edtEmailReg=findViewById(R.id.edtEmailReg)
        edtNumber=findViewById(R.id.edtNumber)
        edtConfirmPass=findViewById(R.id.edtConfirmPass)
        edtPassReg=findViewById(R.id.edtPassReg)
        sharePre= PreferenceHelper.customPrefs(this)
        intiview()
    }

    private fun intiview() {
        btnSignup.setOnClickListener {
            val password=edtPassReg.text.toString()
            val confirmpassword=edtConfirmPass.text.toString()
            if (edtID.text.toString().isEmpty()) {
                edtID.error = "CANT BLANK"
            }else if (edtName.text.toString().isEmpty()){
                edtName.error="CANT BLANK"
            }else if (edtEmailReg.text.toString().isEmpty()){
                edtEmailReg.error="CANT BLANK"
            }else if (!Patterns.EMAIL_ADDRESS.matcher(edtEmailReg.text.toString()).matches()){
                edtEmailReg.error="VALID EMAIL"
            }else if (edtNumber.text.toString().isEmpty()) {
                edtNumber.error = "CANT BLANK"
            }else if (edtNumber.text.length<=10){
                edtNumber.error="MINIMUM 10 DIGIT"
            }else if (edtPassReg.text.toString().isEmpty()) {
                edtPassReg.error = "CANT BLANK"
            } else if (edtConfirmPass.text.toString().isEmpty()) {
                edtConfirmPass.error = "CANT BLANK"
            }else if (!confirmpassword.equals(password)){
                edtConfirmPass.error="VALID PASSWORD"
            }else {
                sharePre[USER_ID] = edtID.text.toString().trim()
                sharePre[USER_NAME] = edtName.text.toString().trim()
                sharePre[USER_EMAIL] = edtEmailReg.text.toString().trim()
                sharePre[USER_NUMBER] = edtNumber.text.toString().trim()
                sharePre[USER_PASS] = edtPassReg.text.toString().trim()
                sharePre[USER_CONFPASSWORD] = edtConfirmPass.text.toString().trim()
                sharePre["IS_LOGIN"] = false
                startActivity(Intent(this, SingInActivity::class.java))
                finish()
            }

        }

    }
}