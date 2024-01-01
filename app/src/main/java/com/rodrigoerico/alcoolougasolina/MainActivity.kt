package com.rodrigoerico.alcoolougasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var textInputAlcohol: TextInputLayout
    private lateinit var editAlcohol: TextInputEditText
    private lateinit var textInputGasoline: TextInputLayout
    private lateinit var editGasoline: TextInputEditText

    private lateinit var btnCalculate: Button
    private lateinit var textResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializesInterfaceComponents()
    }

    private fun initializesInterfaceComponents() {

        textInputAlcohol = findViewById(R.id.text_input_alcohol)
        editAlcohol = findViewById(R.id.edit_alcohol)
        textInputGasoline = findViewById(R.id.text_input_gasoline)
        editGasoline = findViewById(R.id.edit_gasoline)

        btnCalculate = findViewById(R.id.btn_calculate)
        textResult = findViewById(R.id.text_result)
    }

    private fun validateFields(priceAlcohol: String, priceGasoline: String): Boolean {

        textInputAlcohol.error = null
        textInputGasoline.error = null

        if(priceAlcohol.isEmpty()){
            textInputAlcohol.error = "Digite o preço do álcool!"
            return false
        }else if(priceGasoline.isEmpty()){
            textInputGasoline.error = "Digite o preço da gasolina!"
            return false
        }

        return true
    }

    private fun calculateBestPrice() {

        val priceAlcohol = editAlcohol.text.toString()
        val priceGasoline = editGasoline.text.toString()

        val validationResult = validateFields(priceAlcohol, priceGasoline)
        if(validationResult){
            val priceAlcoholDouble = priceAlcohol.toDouble()
            val priceGasolineDouble = priceGasoline.toDouble()

            val result = priceAlcoholDouble / priceGasolineDouble

            if( result >= 0.7 ){
                textResult.text = "Melhor utilizar Gasolina!"
            }else{
                textResult.text = "Melhor utilizar Álcool!"
            }
        }
    }
}