package com.example.database

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import androidx.core.content.contentValuesOf

class DBHelper (contaxt :Context?,): SQLiteOpenHelper(contaxt,"MyData.db",null,1) {
    private  val TAG = "DBHelper"
    val TABLE_NAME = "Students"

    override fun onCreate(p0: SQLiteDatabase?) {
        var sQl = "CREATE TABLE $TABLE_NAME(id INTIGER PRIMARY KEY AUTOINCREMENT ,name TEXT,surname TEXT)"
        p0?.execSQL(sQl)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
    }
    fun addstudents(studentdata : StudentModel) {
        var db = writableDatabase
        var values = contentValuesOf().apply {
            put("name",studentdata.name)
            put("surname",studentdata.surname)
        }
        var iss = db.insert(TABLE_NAME,null,values)
        if (iss.toInt()==-1){
            Log.e(TAG,"addstudents:================== Data Is Not Insert")
        }else{
            Log.e(TAG,"addstudents:================== Data  Insert.............")

        }

    }

    fun getstudents ():ArrayList<StudentModel>{
        var Studentlist = ArrayList<StudentModel>()
        var db = readableDatabase
        var sql = "Select *From $TABLE_NAME"
        var cursor:Cursor = db.rawQuery(sql, null)
        cursor.moveToFirst()




for (i in 0 ..cursor.count-1){
    var id = cursor.getInt(0)
    var name=cursor.getString(1)
    var surname = cursor.getString(2)
    var model = StudentModel(id,name,surname)
    Studentlist.add(model)
    cursor.moveToNext()
}
        return Studentlist


    }
}