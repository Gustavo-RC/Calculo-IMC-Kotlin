package br.com.gustavo.calculadoraimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_what.*

class WhatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_what)

        btnQuero.setOnClickListener {
            //Abrindo a MainActivity
            val mIntent = Intent(this, MainActivity::class.java)
            startActivity(mIntent)
        }
    }
}