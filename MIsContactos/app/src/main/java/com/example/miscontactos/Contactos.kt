package com.example.miscontactos

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_contactos.*

class Contactos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contactos)

        Agregar.setOnClickListener{//redirigimos los botones
            val intento = Intent(this, Crear::class.java)//Redirigimos a contactos
            startActivity(intento)
            onStop()
        }
    }

}
