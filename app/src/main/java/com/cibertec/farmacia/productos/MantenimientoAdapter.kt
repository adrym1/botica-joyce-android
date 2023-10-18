package com.cibertec.farmacia.productos

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cibertec.farmacia.EditProductoActivity
import com.cibertec.farmacia.R

class MantenimientoAdapter(private var productoFirestores: List<ProductoFirestore>):
                           RecyclerView.Adapter<MantenimientoAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MantenimientoAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_mantenimiento,
                   parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MantenimientoAdapter.ViewHolder, position: Int) {
        val producto = productoFirestores[position]
        holder.bind(producto)

        holder.textNombre.text = producto.nombre
        holder.textLaboratorio.text = producto.laboratorio
        holder.textIFA.text = producto.ifa
        holder.textPrecioEmpaque.text = producto.precio_empaq
        holder.textPrecioUnidad.text = producto.precio_unit

        /*holder.itemView.setOnClickListener {
            val intent = Intent(context, EditProductoActivity::class.java)
            intent.putExtra("productoId", producto.id)
            context.startActivity(intent)
        }*/
    }

    override fun getItemCount(): Int = productoFirestores.size

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val textNombre: TextView = itemView.findViewById(R.id.textViewNombre)
        val textLaboratorio: TextView = itemView.findViewById(R.id.textViewLaboratorio)
        val textIFA: TextView = itemView.findViewById(R.id.textViewIFA)
        val textPrecioEmpaque: TextView = itemView.findViewById(R.id.textViewPrecioEmp)
        val textPrecioUnidad: TextView = itemView.findViewById(R.id.textViewPrecioUni)

        fun bind(productoFirestore: ProductoFirestore) {
            textNombre.text = productoFirestore.nombre
            textLaboratorio.text = productoFirestore.laboratorio
            textIFA.text = productoFirestore.ifa
            textPrecioEmpaque.text = productoFirestore.precio_empaq
            textPrecioUnidad.text = productoFirestore.precio_unit
        }
    }
}