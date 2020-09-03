package br.com.gustavo.calculadoraimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnCalc.setOnClickListener {
            if (etPeso.text.toString() != "" && etAltura.text.toString() != "") {
                Toast.makeText(this, "Calculando...", Toast.LENGTH_SHORT).show()
                val imc = etPeso.text.toString().toDouble() / (etAltura.text.toString()
                    .toDouble() * etAltura.text.toString().toDouble())
                val imcResp = "IMC: " + imc.roundToInt() + "\n" + checkIMC(imc)

                //Abrindo a ResultActivity
                val mIntent = Intent(this, ResultActivity::class.java)

                //Passando informações através da Intent
                mIntent.putExtra("INTENT_IMC", imcResp)
                startActivity(mIntent)
                finish()
            } else {
                tvResp.text = "Preencha todos os campos!"
            }
        }
        btnQue.setOnClickListener {
            //Abrindo a WhatActivity
            val mIntent = Intent(this, WhatActivity::class.java)
            startActivity(mIntent)
        }
    }
    //Função para verificar o IMC
    private fun checkIMC(bd: Double): String{
        return when(bd){
            in 0.0..17.0 -> "Muito abaixo do peso."
            in 17.1..18.49 -> "Abaixo do peso."
            in 18.5..24.99 -> "Peso normal."
            in 25.0..29.99 -> "Acima do peso."
            in 30.0..34.99 -> "Obesidade I."
            in 35.0..39.99 -> "Obesidade II(severa)."
            else -> "Obesidade III(mórbida)."
        }
    }
}