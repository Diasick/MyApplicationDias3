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
import android.util.Log
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_registration.*
import java.util.concurrent.TimeUnit

class RegActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        val context = this
        val db = DataBaseHandler(context)
        btn_reg.setOnClickListener {
            if (editTextTextPersonUserName.text.toString().isNotEmpty() &&
                editTextTextPassword.text.toString().isNotEmpty() && editTextTextPassword.text.toString() == editTextTextPassword2.text.toString()
            ) {
                    val user = User(editTextTextPersonUserName.text.toString(), editTextTextPersonName2.text.toString(), editTextTextPassword.text.toString(), editTextTextPersonUserName2.text.toString())

                    db.insertData(user)
                    clearField()
            }
            else {
                Toast.makeText(context, "Please Fill All Data's", Toast.LENGTH_SHORT).show()
            }
        }


    }
    private fun clearField() {
        editTextTextPersonUserName.text.clear()
        editTextTextPassword.text.clear()
        editTextTextPersonName2.text.clear()
        editTextTextPassword2.text.clear()
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