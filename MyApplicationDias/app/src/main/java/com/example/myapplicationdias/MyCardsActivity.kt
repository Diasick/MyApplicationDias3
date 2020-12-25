package com.example.myapplicationdias

import DataBaseHandler
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.media.MediaPlayer
import android.os.Handler
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_addcard.*
import kotlinx.android.synthetic.main.activity_mycards.*
import java.util.concurrent.TimeUnit

class MyCardsActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mycards)

        val context = this
        val db = DataBaseHandler(context)
        sharedPreferences =getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        if(sharedPreferences.getString("owner", "").toString()!=""){
            var name=sharedPreferences.getString("owner", "").toString()
            var num=sharedPreferences.getString("cardnum", "").toString()
            //Toast.makeText(context, "qwerty", Toast.LENGTH_SHORT).show()
            textView5.setText(name)
            textView6.setText(num)
        }

        button5.setOnClickListener {
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("cardnum", "NULL")
            editor.putString("owner", "NULL")
            editor.apply()
            textView5.setText("NULL")
            textView6.setText("NULL")
        }

    }

    fun reg(view: View){
        val go_to_reg=Intent(this, RegActivity::class.java)
        startActivity(go_to_reg)
    }
    fun forgot(view: View){
        val go_to_reg=Intent(this, CodeActivity::class.java)
        startActivity(go_to_reg)
    }
    fun mycards(view: View){
        val go_to_reg=Intent(this, MyCardsActivity::class.java)
        startActivity(go_to_reg)
    }
    fun settings(view: View){
        val go_to_reg=Intent(this, SettingActivity::class.java)
        startActivity(go_to_reg)
    }
    fun logout(view: View){
        val go_to_reg=Intent(this, MainActivity::class.java)
        startActivity(go_to_reg)
    }
    fun menu(view: View){
        val go_to_reg=Intent(this, MenuActivity::class.java)
        startActivity(go_to_reg)
    }
    fun addcard(view: View){
        val go_to_reg=Intent(this, AddCardActivity::class.java)
        startActivity(go_to_reg)
    }

}