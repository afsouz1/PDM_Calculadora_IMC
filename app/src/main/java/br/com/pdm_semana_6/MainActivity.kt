package br.com.pdm_semana_6

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val pesoEditText = findViewById<EditText>(R.id.editTextPeso)
        val alturaEditText = findViewById<EditText>(R.id.editTextAltura)
        val button = findViewById<Button>(R.id.botCalcular)
        val resultadoText = findViewById<TextView>(R.id.textResultado)

        pesoEditText.setOnClickListener {
            pesoEditText.text.clear()
        }

        alturaEditText.setOnClickListener {
            alturaEditText.text.clear()
        }


        button.setOnClickListener {
            try {
                val peso = pesoEditText.text.toString().toDouble()
                val altura = alturaEditText.text.toString().toDouble()

                if (altura <= 0) {
                    resultadoText.text = "Erro: Altura deve ser maior que zero"
                    return@setOnClickListener
                }

                val imc = peso / (altura * altura)

                val resultadoFormatado = String.format("Resultado: %.2f \n App Criado por: Alan Souza / ADS6", imc)
                resultadoText.text = resultadoFormatado

            } catch (e: NumberFormatException) {
                resultadoText.text = "Erro: Por favor, insira valores válidos"

            }
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}