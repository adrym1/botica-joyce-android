package com.cibertec.farmacia

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.cibertec.farmacia.login.LoginViewModel
import com.google.android.material.textfield.TextInputEditText

class LoginActivity: AppCompatActivity() {

    private lateinit var buttonAcceder: Button
    private lateinit var buttonRegistro: Button
    private lateinit var edituser: TextInputEditText
    private lateinit var editpword: TextInputEditText
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        buttonRegistro = findViewById(R.id.btnRegistrar)
        buttonRegistro.setOnClickListener {
            startActivity(Intent(this, RegistroActivity::class.java))
        }

        buttonAcceder = findViewById(R.id.btnAcceder)
        edituser = findViewById(R.id.editTextUsername)
        editpword = findViewById(R.id.editTextPassword)

        buttonAcceder.setOnClickListener {

            val useredtx = edituser.text.toString()
            val passedtx = editpword.text.toString()
            viewModel.verificarLogin(useredtx, passedtx)

        }

        observablesViewModel()
    }

    private fun observablesViewModel() {
        viewModel.userLoginServiceResponse.observe(this) {
            if (it) {
                Toast.makeText(this,"Acceso concedido", Toast.LENGTH_SHORT).show()
                //startActivity(Intent(this, ProductoDisponibleActivity::class.java))
                startActivity(Intent(this, MainActivity::class.java))
            } else {
                Toast.makeText(this, "Verifique sus credenciales",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }
}