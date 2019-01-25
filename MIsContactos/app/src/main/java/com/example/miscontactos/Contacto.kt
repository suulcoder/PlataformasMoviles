package com.example.miscontactos

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_contacto.*
import kotlinx.android.synthetic.main.activity_list_item.*

class Contacto : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacto)


        showNombre.setText(getIntent().getStringExtra("nombre"))
        var number = getIntent().getStringExtra("telefono")
        showPhone.setText(number)
        showMail.setText(getIntent().getStringExtra("mail"))
        setPhoto.setImageDrawable(getDrawable(getIntent().getIntExtra("foto",R.drawable.background)))

        home.setOnClickListener{//redirigimos los botones
            val intento = Intent(this, Contactos::class.java)//Redirigimos a contactos
            startActivity(intento)
            onStop()
        }

        goMail.setOnClickListener{
            val intent = Intent(this, Correo::class.java)
            startActivity(intent)
            onStop()
        }

        call.setOnClickListener{
            try {
                val intentcall = Intent(Intent.ACTION_CALL,Uri.fromParts("tel",number,null))
                startActivity(intentcall)
            }
            catch (e: Exception){
                val intentcall = Intent(Intent.ACTION_DIAL,Uri.fromParts("tel",number,null))
                startActivity(intentcall)
            }

        }

    }
}
