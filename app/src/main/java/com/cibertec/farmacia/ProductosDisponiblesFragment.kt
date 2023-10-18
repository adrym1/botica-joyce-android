package com.cibertec.farmacia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cibertec.farmacia.productos.MantenimientoAdapter
import com.cibertec.farmacia.productos.ProductoAdapter
import com.cibertec.farmacia.productos.ProductoFirestore
import com.google.firebase.firestore.FirebaseFirestore

class ProductosDisponiblesFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val productoFirestores: MutableList<ProductoFirestore> = mutableListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_productos_disponibles, container, false)

        val adapter = ProductoAdapter(productoFirestores)
        recyclerView = view.findViewById(R.id.recycler_Productos)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        val db = FirebaseFirestore.getInstance()
        val productosRef = db.collection("productos")

        productosRef.get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    val nombre = document.getString("nombre")
                    val laboratorio = document.getString("laboratorio")
                    val ifa = document.getString("ifa")
                    val precio_empaq = document.getString("precio_empaq")
                    val precio_unit = document.getString("precio_unit")

                    val productoFirestore = ProductoFirestore(nombre, laboratorio, ifa, precio_empaq, precio_unit)
                    productoFirestores.add(productoFirestore)
                }
                adapter.notifyDataSetChanged()
            }
            .addOnFailureListener { exception ->

            }

        return view
    }

}