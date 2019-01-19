package com.ef_contreras.lab2.models
import android.app.Application

class ApplicationExt:Application(){
    companion object:MenuOrder{

        override var menuOrder: ArrayList<String> = ArrayList()

        override fun clear() {//Eliminar todos los elementos
            menuOrder.clear()
        }

        override fun add(element: String) {//agregar un elemento
            menuOrder.add(element)
        }

        override fun del(elementIndex: Int) {//borrar un elemento
            menuOrder.removeAt(elementIndex)
        }

        override fun done() {//done
            //DO NOTHING
        }

    }
}