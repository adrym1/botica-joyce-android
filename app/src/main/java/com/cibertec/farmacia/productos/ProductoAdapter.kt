package com.cibertec.farmacia.productos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cibertec.farmacia.R

class ProductoAdapter(private var productoFirestores: List<ProductoFirestore>):
    RecyclerView.Adapter<ProductoAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_producto, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductoAdapter.ViewHolder, position: Int) {
        val producto = productoFirestores[position]
        holder.bind(producto)
    }

    override fun getItemCount(): Int = productoFirestores.size

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val textNombre: TextView = itemView.findViewById(R.id.textNombre)
        private val textLaboratorio: TextView = itemView.findViewById(R.id.textLaboratorio)
        private val textIFA: TextView = itemView.findViewById(R.id.textIFA)
        private val textPrecioEmpaque: TextView = itemView.findViewById(R.id.textPrecioEmpaque)
        private val textPrecioUnidad: TextView = itemView.findViewById(R.id.textPrecioUnidad)

        fun bind(productoFirestore: ProductoFirestore) {
            textNombre.text = productoFirestore.nombre
            textLaboratorio.text = productoFirestore.laboratorio
            textIFA.text = productoFirestore.ifa
            textPrecioEmpaque.text = productoFirestore.precio_empaq
            textPrecioUnidad.text = productoFirestore.precio_unit
        }
    }
}