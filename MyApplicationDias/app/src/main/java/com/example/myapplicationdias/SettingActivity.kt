package com.example.myapplicationdias

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
import kotlinx.android.synthetic.main.activity_settings.*
import java.util.concurrent.TimeUnit

class SettingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        btn_reg.setOnClickListener {
            val go_to_reg=Intent(this, ChangePhoneActivity::class.java)
            startActivity(go_to_reg)

        }
        button3.setOnClickListener {
            val go_to_reg=Intent(this, ChangePasswordActivity::class.java)
            startActivity(go_to_reg)

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