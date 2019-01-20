package com.ef_contreras.lab2
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ef_contreras.lab2.models.ApplicationExt
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        menu.setOnClickListener {//redirigimos los botones
            val intento = Intent(this, Menu::class.java)//Redirigimos al menu
            startActivity(intento)
        }

        orden.setOnClickListener {
            val intento1 = Intent(this, Orden::class.java)//Redigimos a la orden
            startActivity(intento1)
        }


    }

}
