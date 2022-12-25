package com.example.sharepreferenceapplication



import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sharepreferenceapplication.sharepref.EducationAdapter
import com.example.sharepreferenceapplication.sharepref.EducationModal
import com.example.sharepreferenceapplication.sharepref.Sharepreference
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class MainActivity : AppCompatActivity() {
   lateinit var session:Sharepreference
    var mExampleList: ArrayList<EducationModal>? = null
    private var mRecyclerView: RecyclerView? = null
    private var mAdapter: EducationAdapter? = null
    private var mLayoutManager: RecyclerView.LayoutManager? = null
    lateinit var Clear: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       Clear = findViewById(R.id.button_Clear)
        session= Sharepreference(this)

        loadData()
        buildRecyclerView()
        setInsertButton()
        val buttonSave: Button = findViewById(R.id.button_save)
        buttonSave.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                saveData()
            }
        })
    }

    private fun saveData() {
        val sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val gson = Gson()
        val json = gson.toJson(mExampleList)
        editor.putString("task list", json)
        editor.apply()
    }

    private fun loadData() {
        val sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE)
        val gson = Gson()
        val json = sharedPreferences.getString("task list", null)
        val type = object : TypeToken<ArrayList<EducationModal?>?>() {}.type
        mExampleList = gson.fromJson(json, type)
        if (mExampleList == null) {
            mExampleList = ArrayList()
        }
    }

    private fun buildRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerview)
        mRecyclerView?.setHasFixedSize(true)
        mLayoutManager = LinearLayoutManager(this)
      //  mAdapter = EducationAdapter(mExampleList!!)
        mRecyclerView?.setLayoutManager(mLayoutManager)
        mRecyclerView?.setAdapter(mAdapter)
    }

    private fun setInsertButton() {
        val buttonInsert: Button = findViewById(R.id.button_insert)
        buttonInsert.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val line1 = findViewById<EditText>(R.id.edittext_line_1)
                val line2 = findViewById<EditText>(R.id.edittext_line_2)
                insertItem(line1.text.toString(), line2.text.toString())
            }
        })
    }

    private fun insertItem(line1: String, line2: String) {
        mExampleList!!.add(EducationModal(line1, line2))
        mAdapter!!.notifyItemInserted(mExampleList!!.size)

        Clear.setOnClickListener {

            val AlertDialogBuilder = AlertDialog.Builder(this)
            AlertDialogBuilder.setTitle("Clear Data")
            AlertDialogBuilder.setIcon(R.drawable.ic_baseline_alternate_email_24)
            AlertDialogBuilder.setMessage("Are You sure")
            AlertDialogBuilder.setCancelable(false)
            AlertDialogBuilder.setPositiveButton("Yes") { _, _, ->
                finish()
            }
            AlertDialogBuilder.setNeutralButton("No") { _, _, ->
                Toast.makeText(this, "Click no", Toast.LENGTH_SHORT).show()
            }
            AlertDialogBuilder.setNegativeButton("Cancel") { _, _, ->
                Toast.makeText(this, "Click Cancel", Toast.LENGTH_SHORT).show()
            }
            val AlertDialog = AlertDialogBuilder.create()
            AlertDialog.show()

        }
    }
}