package com.cibertec.farmacia.productos

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore

class RegisterProductoViewModel: ViewModel() {

    private val db = FirebaseFirestore.getInstance()

    fun guardarProducto(nombre: String, laboratorio: String, ifa: String, precio_empaq : String, precio_unit : String) {
        val producto = hashMapOf(
            "nombre" to nombre,
            "laboratorio" to laboratorio,
            "ifa" to ifa,
            "precio_empaq" to precio_empaq,
            "precio_unit" to precio_unit
        )

        db.collection("productos")
            .add(producto)
            .addOnSuccessListener { documentReference ->
                val nuevoId = documentReference.id
            }
            .addOnFailureListener {

            }
    }
}