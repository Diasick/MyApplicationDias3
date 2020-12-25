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
import java.util.concurrent.TimeUnit

class ChangePasswordActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password)

        val context = this
        val db = DataBaseHandler(context)
        btn_reg.setOnClickListener {

            sharedPreferences =getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
            if (editTextTextPassword.text.toString()==db.readPass(sharedPreferences.getString("username", "").toString())){
                db.updatePass(editTextTextPassword2.text.toString(), sharedPreferences.getString("username", "").toString())
                Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(context, "Password incorrect", Toast.LENGTH_SHORT).show()
            }
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