package com.example.fuelcalculatorapp

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar_resultado)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        val valorTotal = intent.getDoubleExtra("DISTANCIA_CUSTO_TOTAL", 0.0)
        val precoPorLitro = intent.getDoubleExtra("DISTANCIA_PRECO_LITRO", 0.0)
        val distanciaTotal = intent.getIntExtra("DISTANCIA_VALOR", 0)
        val consumoPorLitro = intent.getIntExtra("DISTANCIA_CONSUMO_LITRO", 0)

        val tvPrecoViagem = findViewById<TextView>(R.id.tvPrecoViagem)
        val tvPrecoLitro = findViewById<TextView>(R.id.tvResultadoPreco)
        val tvConsumoLitro = findViewById<TextView>(R.id.tvResultadoConsumo)
        val tvDistancia = findViewById<TextView>(R.id.tvResultadoDistancia)
        val btnResultadoNovo = findViewById<Button>(R.id.btnResultadoNovo)

        tvPrecoViagem.text = String.format("R$ %.2f", valorTotal)
        tvPrecoLitro.text = String.format("R$ %.2f", precoPorLitro)
        tvConsumoLitro.text = "${consumoPorLitro} km/litro"
        tvDistancia.text = "${distanciaTotal} km"
        btnResultadoNovo.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home ->{
                finish()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}