package com.cibertec.farmacia

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.cibertec.farmacia.register.RegisterViewModel
import com.google.android.material.textfield.TextInputEditText

class RegistroActivity: AppCompatActivity() {

    private lateinit var uname: TextInputEditText
    private lateinit var pword: TextInputEditText
    private lateinit var cpword: TextInputEditText
    private lateinit var viewModel: RegisterViewModel
    private lateinit var buttonRegistrar: Button
    //private lateinit var db: DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        viewModel = ViewModelProvider(this)[RegisterViewModel::class.java]

        uname = findViewById(R.id.edtUsername)
        pword = findViewById(R.id.edtPassword)
        cpword = findViewById(R.id.edtCPassword)
        buttonRegistrar = findViewById(R.id.btnRegistrar)
        //db = DBHelper(this)

        buttonRegistrar.setOnClickListener {
            val unametext = uname.text.toString()
            val pwordtext = pword.text.toString()
            val cpwordtext = cpword.text.toString()

            viewModel.verificarRegister(unametext, pwordtext, cpwordtext)
        }
        observableViewModel()
    }

    private fun observableViewModel() {
        viewModel.userRegisterFirebase.observe(this) {
            if (it) {
                Toast.makeText(this,"Registro correcto",Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this,"Registro incorrecto",Toast.LENGTH_SHORT).show()
            }
        }
    }
}