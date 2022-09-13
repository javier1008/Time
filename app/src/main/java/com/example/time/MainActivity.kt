package com.example.time

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TimePicker
import java.util.*

class MainActivity : AppCompatActivity() {

    var txtHora: EditText?=null
    var btnHora: Button?=null
    var tpHora: TimePicker?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtHora= findViewById(R.id.txtHora)
        btnHora= findViewById(R.id.btnHora)
        tpHora=findViewById(R.id.tpHora)

        txtHora?.setText(getHoraTimePicker())
        tpHora?.setOnClickListener{
        tpHora-> txtHora?.setText(getHoraTimePicker())
            tpHora?.visibility=View.GONE
        }
    }
       fun getHoraTimePicker():String{
            var hora=tpHora?.currentHour.toString().padStart(2,'0')
            var minutos=tpHora?.currentMinute.toString().padStart(2,'0')
            return hora+":"+minutos+" hrs"
    }

    fun mostrarReloj(view: View) {
        tpHora?.visibility=View.VISIBLE
    }

    fun fnVerCalendario(view: View) {
        val windowCalendar: Intent = Intent(this,calendario::class.java)
        startActivity(windowCalendar)
    }
}