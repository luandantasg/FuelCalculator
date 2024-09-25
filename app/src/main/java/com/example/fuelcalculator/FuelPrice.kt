package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fuelcalculator.databinding.ActivityFuelPriceBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class FuelPrice : AppCompatActivity() {

    private lateinit var binding : ActivityFuelPriceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFuelPriceBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnProximo.setOnClickListener {

            val gasStringTemp = binding.edtGas.text

            if (gasStringTemp?.isEmpty() == true){

                Snackbar
                    .make(
                        binding.edtGas,
                        "Campo obrigatório",
                        Snackbar.LENGTH_LONG
                    )
                    .show()


            }else {

                val gasString: Float = gasStringTemp.toString().toFloat()

                val intent = Intent(this, CarPrice::class.java)
                intent.apply {
                    putExtra("Gas", gasString)
                }
                startActivity(intent)
            }
        }
    }
}
