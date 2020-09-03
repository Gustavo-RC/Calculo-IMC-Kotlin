package br.com.gustavo.calculadoraimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        //Recuperando o imc passado por meio da Intent
        val imc = intent.getStringExtra("INTENT_IMC")

        //Exibir os dados recuperados na tela
        txvResultImc.text = imc

        //Executando o botão Recalcular
        btnResultRecalcular.setOnClickListener {
            //Criando um alerta
            AlertDialog.Builder(this)
                .setTitle("Atenção!")
                .setMessage("Você realmente deseja recalcular?")
                .setPositiveButton("Sim"){_,_ ->
                    //executando o clique do botão SIM
                    val mIntent = Intent(this, MainActivity::class.java)
                    startActivity(mIntent)
                    finishAffinity()
                }
                .setNeutralButton("Cancelar"){_,_ ->}
                //Para que o usuário não saia do alerta quando clicar fora da caixa de diálogo
                .setCancelable(false)
                .create()
                .show()
        }
    }
}
