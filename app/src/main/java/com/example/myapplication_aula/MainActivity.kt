package com.example.myapplication_aula

import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private var counter = 0 // Variável para armazenar o contador

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Encontrar e configurar o TextView
        val olaMundoTextView: TextView = findViewById(R.id.hello)
        olaMundoTextView.text = "Que loucura!"

        // Encontrar e configurar o Switch
        val fofo: Switch = findViewById(R.id.fofo)
        fofo.setOnCheckedChangeListener { _, isChecked ->
            olaMundoTextView.text = if (isChecked) "Switch is on" else "Switch is off"
        }

        // Encontrar e configurar o Button e o TextView do contador
        val incrementButton: Button = findViewById(R.id.incrementButton)
        val counterTextView: TextView = findViewById(R.id.counterTextView)

        incrementButton.setOnClickListener {
            counter++ // Incrementar o contador
            counterTextView.text = counter.toString() // Atualizar o TextView com o novo valor
        }
    }
}
