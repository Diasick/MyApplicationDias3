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
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences
    private var txtregistr: TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtregistr=findViewById<View>(R.id.textRegistr) as TextView

    }

    fun signCode(view: View){
        val context = this
        val db = DataBaseHandler(context)
        val dataPass = db.readCode(editTextTextPersonUserName.text.toString())

        sharedPreferences =getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        if(!dataPass.isEmpty() ){
            Toast.makeText(context, "Excellent", Toast.LENGTH_SHORT).show()
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("username", db.readName(editTextTextPersonUserName.text.toString()))
            editor.apply()
            Toast.makeText(context, db.readName(editTextTextPersonUserName.text.toString()), Toast.LENGTH_SHORT).show()
            val go_to_reg = Intent(this, MenuActivity::class.java)
            startActivity(go_to_reg)
        }
        else{
            Toast.makeText(context, "Failed code", Toast.LENGTH_SHORT).show()
        }
    }


    fun sign(view: View){

        val context = this
        val db = DataBaseHandler(context)
        val dataPass = db.readPass(editTextTextPersonUserName.text.toString())

        sharedPreferences =getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        if(editTextTextPassword.text.toString() == dataPass) {
            Toast.makeText(context, "Excellent", Toast.LENGTH_SHORT).show()
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("username", editTextTextPersonUserName.text.toString())
            editor.apply()
            val go_to_reg = Intent(this, MenuActivity::class.java)
            startActivity(go_to_reg)
        }
        else{
            Toast.makeText(context, "Failed username or password", Toast.LENGTH_SHORT).show()
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