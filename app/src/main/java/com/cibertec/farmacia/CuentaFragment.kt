package com.cibertec.farmacia

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth

class CuentaFragment: Fragment() {
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_cuenta, container, false)

        auth = FirebaseAuth.getInstance()

        val currentUser = auth.currentUser
        val email = currentUser?.email

        val emailTextView = view.findViewById<TextView>(R.id.textViewEmail)
        emailTextView.text = email

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnAcercaDe = view.findViewById<Button>(R.id.btnAcercaDe)
        btnAcercaDe.setOnClickListener {
            startActivity(Intent(context,AcercaDeActivity::class.java))
        }

        val logoutButton = view.findViewById<Button>(R.id.logoutButton)
        logoutButton.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            Toast.makeText(context,"Sesión cerrada con éxito",Toast.LENGTH_SHORT).show()
            activity?.finish()
        }
    }
}