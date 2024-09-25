package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fuelcalculator.databinding.ActivityResultBinding

class Result : AppCompatActivity() {
    private lateinit var binding : ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val gas = intent.getFloatExtra("Gas",0.0f)
        val car = intent.getFloatExtra("Car",0.0f)
        val distance = intent.getFloatExtra("distance",0.0f)
        val result = intent.getFloatExtra("result",0.0f)

        binding.tvResult.text = result.toString()
        binding.preco.text = gas.toString()
        binding.consumo.text = car.toString()
        binding.distancia.text = distance.toString()

        binding.BtnNovoCalculo.setOnClickListener {
            val intent = Intent(this,FuelPrice::class.java)
            startActivity(intent)
        }


    }
}