package com.ef_contreras.lab2
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.ef_contreras.lab2.models.ApplicationExt
import kotlinx.android.synthetic.main.activity_menu.*


class Menu : AppCompatActivity() {

    var array = arrayOf("Hamburguesas","Chuchitos","Pizza","Tacos","Tamales","Helado","Dona","crepas","Coca-Cola","Pepsi","Cafe","Té")//menu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val adapter = ArrayAdapter(this,R.layout.listview_item, array)//Nos permitira agregar el array al ListView

        val listView:ListView = findViewById(R.id.menulist)
        listView.setAdapter(adapter)

        home.setOnClickListener {
            val intento = Intent(this, MainActivity::class.java)
            startActivity(intento)

        }
        //Definimos accion para los botones
        listView.onItemClickListener = object : AdapterView.OnItemClickListener{
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val itemValue = listView.getItemAtPosition(position) as String
                Toast.makeText(applicationContext,"Se ha agregado el elemento " + array[position] + " al carrito de compra",Toast.LENGTH_SHORT).show()//Enviamos informacion en un Toast
                ApplicationExt.add(array[position])//Actualizamos el ARray
            }
        }


    }
}

