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
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_registration.*
import kotlinx.android.synthetic.main.activity_registration.editTextTextPersonUserName
import java.util.concurrent.TimeUnit

class AddCardActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addcard)
        val context = this
        val db = DataBaseHandler(context)
        btn_add.setOnClickListener {

            if (owner_txt.text.toString().isNotEmpty() &&
                cardnum_txt.text.toString().isNotEmpty() &&
                exp_txt.text.toString().isNotEmpty() &&
                code_txt.text.toString().isNotEmpty()
                    ) {

                sharedPreferences =getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                editor.putString("cardnum", cardnum_txt.text.toString())
                editor.putString("owner", owner_txt.text.toString())
                editor.apply()
                Toast.makeText(context, "Saved", Toast.LENGTH_SHORT).show()
                clearField()
            }
            else {
                Toast.makeText(context, "Please Fill All Data's", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun clearField() {
        owner_txt.text.clear()
        cardnum_txt.text.clear()
        exp_txt.text.clear()
        code_txt.text.clear()
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