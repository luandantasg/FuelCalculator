package com.example.fuelcalculator

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fuelcalculator.Result
import com.example.fuelcalculator.databinding.ActivityDistanceBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class Distance : AppCompatActivity() {
    private lateinit var binding : ActivityDistanceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = ActivityDistanceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val gas = intent.getFloatExtra("Gas",0.0f)
        val carPrice = intent.getFloatExtra("Car",0.0f)


        binding.btnResultado.setOnClickListener {

            val distanceTemp = binding.edtDistance.text


            if (distanceTemp?.isEmpty() == true){

                Snackbar
                    .make(
                        binding.edtDistance,
                        "Preencha todos os campos",
                        Snackbar.LENGTH_LONG
                    )
                    .show()


            }else {

                val distanceString: Float = distanceTemp.toString().toFloat()
                val gasString: Float = gas.toString().toFloat()
                val carString: Float = carPrice.toString().toFloat()

                val distance = distanceString * gasString
                val result = distance / carString


                val intent = Intent(this, Result::class.java)
                intent.apply {
                    putExtra("Gas", gasString)
                    putExtra("Car",carString)
                    putExtra("distance",distanceString)
                    putExtra("result",result)
                }
                startActivity(intent)
            }

        }


    }

}




