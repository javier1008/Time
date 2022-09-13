package com.example.time

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.EditText
import android.widget.ImageButton
import androidx.annotation.RequiresApi

class calendario : AppCompatActivity() {
    var txtFecha: EditText?=null
    var btnFecha: ImageButton?=null
    var dpFecha: DatePicker?=null

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendario)

        txtFecha = findViewById(R.id.txtFecha)
        btnFecha=findViewById(R.id.btnFecha)
        dpFecha=findViewById(R.id.dpFecha)

        txtFecha?.setText(getDate())

        dpFecha?.setOnDateChangedListener{
            dpFecha,year, mes, dia->
            txtFecha?.setText(getDate())
            dpFecha?.visibility=View.GONE
        }
    }
    fun getDate():String{
        var dia=dpFecha?.dayOfMonth.toString().padStart(2,'0') // Se van a tener dos caracterecs y que si se va a tener solo uno que ponga un CERO
        var mes=(dpFecha!!.month+1).toString().padStart(2,'0')
        var year=dpFecha?.year.toString().padStart(2,'0')
        return dia +"/"+ mes+ "/" +year
    }

    fun fnVerCalendar(view: View) {
        dpFecha?.visibility=View.VISIBLE
    }
}