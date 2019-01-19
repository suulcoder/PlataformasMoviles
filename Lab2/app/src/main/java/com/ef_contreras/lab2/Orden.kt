package com.ef_contreras.lab2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.ef_contreras.lab2.models.ApplicationExt
import kotlinx.android.synthetic.main.activity_orden.*

class Orden : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orden)

        val adapter = ArrayAdapter(this,R.layout.listview_item, ApplicationExt.menuOrder)

        val listView: ListView = findViewById(R.id.pedido)
        listView.setAdapter(adapter)

        home.setOnClickListener {
            val intento = Intent(this, MainActivity::class.java)
            startActivity(intento)
        }

        limpiar.setOnClickListener {
            ApplicationExt.clear()//Borramos todos los elemntos
            adapter.notifyDataSetChanged()//actualizamos
        }

        ordenar.setOnClickListener {
            ApplicationExt.clear()
            adapter.notifyDataSetChanged()
            Toast.makeText(applicationContext,"ORDEN ENVIADA CON EXITO",Toast.LENGTH_SHORT).show()
            val intentoFinal = Intent(this,Exito::class.java)
            startActivity(intentoFinal)//Enviamos a la plantilla final
        }

        listView.onItemLongClickListener = object : AdapterView.OnItemLongClickListener{//SI lo mantiene sostenido
            override fun onItemLongClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long): Boolean {
                val itemValue = listView.getItemAtPosition(position) as String
                Toast.makeText(applicationContext,"Se ha eliminado el elemento " + ApplicationExt.menuOrder[position] + " al carrito de compra",Toast.LENGTH_SHORT).show()//Informamos el elemento que se elimino
                ApplicationExt.del(position)//lo eliminamos del array
                adapter.notifyDataSetChanged()//Actualizamos
                return true
            }
        }
    }
}
