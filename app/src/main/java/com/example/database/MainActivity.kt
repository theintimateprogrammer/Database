package com.example.database

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.database.Adapter.StudentAdapter
import com.example.database.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var dbHelper: DBHelper
    lateinit var adapter: StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        dbHelper = DBHelper(this)
        binding.btn.setOnClickListener {
            var name = binding.edtname.text.toString()
            var surname = binding.edtsurname.text.toString()

            var data = StudentModel(0,name,surname)
            dbHelper.addstudents(data)

            adapter.update(dbHelper.getstudents())

        }

        var list = dbHelper.getstudents()
        adapter = StudentAdapter(list)
        binding.rcvstudentlist.layoutManager = LinearLayoutManager(this)
        binding.rcvstudentlist.adapter = adapter



    }
}