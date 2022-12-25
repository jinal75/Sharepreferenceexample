package com.example.sharepreferenceapplication.sharepref

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sharepreferenceapplication.R

class EducationAdapter(
    private val EducationList: ArrayList<String>,
) :
    RecyclerView.Adapter<EducationAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // below line is to inflate our layout.
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_education, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // setting data to our views of recycler view.
        val eduName = EducationList[position]
        holder.EducationName.text = eduName
    }

    override fun getItemCount(): Int {
        // returning the size of array list.
        return EducationList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // creating variables for our views.
        lateinit var EducationName: TextView
        lateinit var EducationResult : TextView

        init {

            // initializing our views with their ids.
            EducationName = itemView.findViewById(R.id.txtEdu)
            EducationResult = itemView.findViewById(R.id.txtRes)
        }
    }
}