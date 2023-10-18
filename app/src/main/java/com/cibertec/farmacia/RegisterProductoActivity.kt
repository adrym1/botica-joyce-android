package com.cibertec.farmacia

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.cibertec.farmacia.R
import com.cibertec.farmacia.productos.RegisterProductoViewModel
import com.google.android.material.textfield.TextInputEditText

class RegisterProductoActivity: AppCompatActivity() {
    private lateinit var nombre: TextInputEditText
    private lateinit var laboratorio: TextInputEditText
    private lateinit var ifa: TextInputEditText
    private lateinit var precio_empaq: TextInputEditText
    private lateinit var precio_unit: TextInputEditText
    private lateinit var btnGuardar:Button
    private lateinit var viewModel: RegisterProductoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_producto)

        viewModel = ViewModelProvider(this)[RegisterProductoViewModel::class.java]

        nombre = findViewById(R.id.edtNombre)
        laboratorio = findViewById(R.id.edtLaboratorio)
        ifa = findViewById(R.id.edtIFA)
        precio_empaq = findViewById(R.id.edtPrecioEmpaq)
        precio_unit = findViewById(R.id.edtPrecioUnit)
        btnGuardar = findViewById(R.id.btnGuardarProducto)

        btnGuardar.setOnClickListener {
            val nom = nombre.text.toString()
            val lab = laboratorio.text.toString()
            val ifaa = ifa.text.toString()
            val pem = precio_empaq.text.toString()
            val pun = precio_unit.text.toString()

            if (nom.isNotEmpty() || lab.isNotEmpty() || ifaa.isNotEmpty() || pem.isNotEmpty() || pun.isNotEmpty()) {
                viewModel.guardarProducto(nom,lab,ifaa,pem,pun)
                Toast.makeText(this,"Producto guardado exitosamente",Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this,"Debe completar todos los campos",Toast.LENGTH_SHORT).show()
            }
        }

    }
}