package com.example.database.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.database.R
import com.example.database.StudentModel

class StudentAdapter (list:ArrayList<StudentModel>):RecyclerView.Adapter<StudentAdapter.StudentHolder>(){
    var list = list
    class StudentHolder (itemview :View):ViewHolder(itemview){
        var id= itemview.findViewById<TextView>(R.id.edtid)
        var name = itemview.findViewById<TextView>(R.id.edtname)
        var surname = itemview.findViewById<TextView>(R.id.edtsurname)


    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentHolder {
     var view = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return StudentHolder(view)

    }




    override fun onBindViewHolder(holder: StudentAdapter.StudentHolder, position: Int) {
        holder.id.text = list.get(position).id.toString()
        holder.name.text = list.get(position).name.toString()
        holder.surname.text = list.get(position).surname.toString()


    }
    override fun getItemCount(): Int {
        return list.size



    }
    fun update(students:ArrayList<StudentModel>){
        list = students
        notifyDataSetChanged()
    }


}

