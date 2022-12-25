package com.example.sharepreferenceapplication.sharepref

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.sharepreferenceapplication.R
import com.example.sharepreferenceapplication.simpleLogin.LoginActivity
import com.example.shareprefernce.sharepref.PreferenceHelper
import com.example.shareprefernce.sharepref.PreferenceHelper.get
import com.example.shareprefernce.sharepref.PreferenceHelper.set

class DisplayDataActivity : AppCompatActivity() {
    lateinit var sharPre: SharedPreferences
    lateinit var ID:TextView
    lateinit var Email:TextView
    lateinit var Name:TextView
    lateinit var Number:TextView
    lateinit var Password:TextView
    lateinit var ConformPass:TextView
    lateinit var Logout:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_data)
        sharPre= PreferenceHelper.customPrefs(this)
        ID=findViewById(R.id.txt_Id)
        Name=findViewById(R.id.txt_Name)
        Email=findViewById(R.id.txt_Email)
        Number=findViewById(R.id.txt_Number)
        Password=findViewById(R.id.txt_Password)
        ConformPass=findViewById(R.id.txt_ConfPassword)
        Logout=findViewById(R.id.btn_Logout)
        intiview()
    }

    private fun intiview() {
        ID.text=sharPre[USER_ID,""]
        Name.text=sharPre[USER_NAME,""]
        Email.text=sharPre[USER_EMAIL,""]
        Number.text=sharPre[USER_NUMBER,""]
        Password.text=sharPre[USER_PASS,""]
        ConformPass.text=sharPre[USER_CONFPASSWORD,""]
        Logout.setOnClickListener {
            sharPre["IS_LOGIN"]=false
            sharPre[USER_ID]=""
            sharPre[USER_NAME]=""
            sharPre[USER_EMAIL]=""
            sharPre[USER_NUMBER]=""
            sharPre[USER_PASS]=""
            sharPre[USER_CONFPASSWORD]=""

            val i = Intent(this, SingInActivity::class.java)
            startActivity(i)
            finish()
        }
    }
}
