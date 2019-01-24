package com.example.miscontactos

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_crear.*

class Crear : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear)

        home.setOnClickListener{//redirigimos los botones
            val intento = Intent(this, Contactos::class.java)//Redirigimos a contactos
            startActivity(intento)
            onStop()
        }
    }
}
