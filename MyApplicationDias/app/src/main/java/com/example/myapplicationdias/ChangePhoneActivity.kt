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
import kotlinx.android.synthetic.main.activity_change_password.*
import kotlinx.android.synthetic.main.activity_change_password.btn_reg
import kotlinx.android.synthetic.main.activity_change_phone.*
import java.util.concurrent.TimeUnit

class ChangePhoneActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_phone)

        val context = this
        val db = DataBaseHandler(context)

        sharedPreferences =getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        editTextTextPersonName2.setText(db.readPhone(sharedPreferences.getString("username", "").toString()))


        btn_reg.setOnClickListener {


                db.updatePhone(editTextTextPersonName2.text.toString(), sharedPreferences.getString("username", "").toString())
                Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()

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