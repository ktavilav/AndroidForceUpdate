package com.example.lanzardados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

public class DidesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dides)

        val btnLanzar: Button = findViewById(R.id.btnLanzar)

        btnLanzar.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice(){
        var numero: Int = lanzar(6)
        val txtResult: TextView = findViewById(R.id.textResultado)
        txtResult.text = numero.toString()
        //Toast.makeText(this, numero.toString(), Toast.LENGTH_LONG).show()



    }
    private fun lanzar(max: Int): Int {
        return (1..max).random()
    }


}

