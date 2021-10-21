package com.example.myapplication

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    var num1: Double = 0.0
    var num2: Double = 0.0
    var operacion: Int = 0
    var resultado=0.0
    var cambiarBinario=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val orientation=resources.configuration.orientation
        if(orientation==Configuration.ORIENTATION_LANDSCAPE){
            deshabilitarBotonesBinario()
        }

    }



    fun numero(v: View) {
        val valorNumerico = findViewById<Button>(v.id)
        val textNumerico = valorNumerico.text.toString()

        resultadoTextView.text="${resultadoTextView.text.toString()}${textNumerico}"
    }


    fun borrarText(v: View) {
        resultadoTextView.text=null
        resultado=0.0
        operacion=0
    }

    fun operar(v: View) {
        if (resultadoTextView.length()>0) {
            val valorDeOperacion = findViewById<Button>(v.id)
            if(valorDeOperacion.text.toString()=="+") {
                operacion=1
            } else if(valorDeOperacion.text.toString()=="-") {
                operacion=2
            } else if (valorDeOperacion.text.toString()=="x") {
                operacion=3
            }else if(valorDeOperacion.text.toString()=="/"){
                operacion=4
            }
            else {
                operacion = 0
            }
            num1=resultadoTextView.text.toString().toDouble()
            resultadoTextView.text=null
        }
    }

    fun relizarOperacion(v: View) {
        if(operacion!=0) {
            num2=resultadoTextView.text.toString().toDouble()
            if(operacion==1) {
                resultado = num1+num2
                resultadoTextView.text="${resultado}"
            }else if(operacion==2) {
                resultado = num1-num2
                resultadoTextView.text="${resultado}"
            }else if(operacion==3) {
                resultado = num1*num2
                resultadoTextView.text="${resultado}"
            }else if(operacion==4) {
                resultado = num1 / num2
                resultadoTextView.text = "${resultado}"
            }else if (operacion==0) {
                resultadoTextView.text=null
            }
        }
        else {
            resultadoTextView.text="0"
        }
    }

    fun calcularBinario() {
        deshabilitarBotonesBinario()
    }

    fun deshabilitarBotonesBinario() {
        val dosBoton2 = findViewById<Button>(R.id.dosBoton2)
        val tresBoton2 = findViewById<Button>(R.id.tresBoton2)
        val cuatroBoton2 = findViewById<Button>(R.id.cuatroBoton2)
        val cincoBoton2= findViewById<Button>(R.id.cincoBoton2)
        val seisBoton2= findViewById<Button>(R.id.seisBoton2)
        val sieteBoton2 = findViewById<Button>(R.id.sieteBoton2)
        val ochoBoton2 = findViewById<Button>(R.id.ochoBoton2)
        val nueveBoton2 = findViewById<Button>(R.id.nueveBoton2)
        if (cambiarBinario==false) {

            cambiarBinario=true
        } else if (cambiarBinario==true) {
            cambiarBinario=false
        }
    }


}


