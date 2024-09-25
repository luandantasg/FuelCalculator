package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fuelcalculator.databinding.ActivityCarPriceBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class CarPrice : AppCompatActivity() {
    private lateinit var binding : ActivityCarPriceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCarPriceBinding.inflate(layoutInflater)
        setContentView(binding.root)

       val gas = intent.getFloatExtra("Gas",0.0f)

        binding.btnProximo2.setOnClickListener {

            val carStringTemp = binding.edtCar.text

            if (carStringTemp?.isEmpty() == true){

                Snackbar
                    .make(
                        binding.edtCar,
                        "Campo obrigatório",
                        Snackbar.LENGTH_LONG
                    )
                    .show()


            }else {

                val carString: Float = carStringTemp.toString().toFloat()
                val gasString : Float = gas.toString().toFloat()

                val intent = Intent(this, Distance::class.java)
                intent.apply {
                    putExtra("Gas", gasString)
                    putExtra("Car",carString)
                }
                startActivity(intent)
            }
        }

    }
}