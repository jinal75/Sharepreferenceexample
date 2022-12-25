package com.example.sharepreferenceapplication.sharepref

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sharepreferenceapplication.R
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ViewDataActivity : AppCompatActivity() {


    private var mLayoutManager: RecyclerView.LayoutManager? = null
    lateinit var session: Sharepreference
    lateinit var Education: EditText
    lateinit var Result: EditText
    lateinit var Add: Button
    lateinit var Clear: Button
    lateinit var insert: Button
    lateinit var RecyclerView: RecyclerView
    lateinit var adapter: EducationAdapter
   lateinit var  EducationList: ArrayList<String>

    lateinit var edu: TextView
    lateinit var res: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_data)
        //edu=findViewById(R.id.txtEdu)
        // res=findViewById(R.id.txtRes)

        EducationList = ArrayList()
        session = Sharepreference(this)

        Education = findViewById(R.id.edt_Education)
        Result = findViewById(R.id.edt_Result)
        Add = findViewById(R.id.btn_Add)
        Clear = findViewById(R.id.btn_Clear)
        RecyclerView = findViewById(R.id.Recyclerview)
        insert = findViewById(R.id.btn_Insert)

      //  loadData()



        Clear.setOnClickListener {
            val AlertDialogBuilder = AlertDialog.Builder(this)


            AlertDialogBuilder.setTitle("Clear Data")
            AlertDialogBuilder.setIcon(R.drawable.ic_baseline_alternate_email_24)
            AlertDialogBuilder.setMessage("Are You sure")
            AlertDialogBuilder.setCancelable(false)
            AlertDialogBuilder.setPositiveButton("Yes") { _, _, ->
                Toast.makeText(this, "clear data" , Toast.LENGTH_SHORT).show()
                session.logoutUser()
                //AlertDialog.dismiss()
            }
            AlertDialogBuilder.setNeutralButton("No") { _, _, ->
                Toast.makeText(this, "Click no", Toast.LENGTH_SHORT).show()
               // AlertDialog.dismiss()
            }
            AlertDialogBuilder.setNegativeButton("Cancel") { _, _, ->
                Toast.makeText(this, "Click Cancel", Toast.LENGTH_SHORT).show()
               // AlertDialog.dismiss()

            }
            val AlertDialog = AlertDialogBuilder.create()
         AlertDialog.show()

        }
        Add.setOnClickListener {
            val eduname=Education.text.toString()
            val result=Result.text.toString()
            EducationList.add(eduname)

        }
        insert.setOnClickListener {
            session.saveUserList(EducationList)
            buildRecyclerView()
        }

    }

    private fun buildRecyclerView() {
        RecyclerView = findViewById(R.id.Recyclerview)
        RecyclerView.setHasFixedSize(true)
        mLayoutManager = LinearLayoutManager(this)
        adapter = EducationAdapter(session.getUserList())
        RecyclerView.setLayoutManager(mLayoutManager)
        RecyclerView.setAdapter(adapter)
    }
}


