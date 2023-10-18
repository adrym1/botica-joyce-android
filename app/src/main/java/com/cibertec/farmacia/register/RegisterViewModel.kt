package com.cibertec.farmacia.register

import android.app.Activity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class RegisterViewModel: ViewModel() {
    private lateinit var auth: FirebaseAuth
    val userRegisterFirebase = MutableLiveData<Boolean>()

    fun verificarRegister(email: String, password: String, cpassword: String) {
        if (email.isEmpty() || password.isEmpty() || cpassword.isEmpty()) {
            userRegisterFirebase.value = false
        }
        else if (password != cpassword) {
            userRegisterFirebase.value = false
        }
        else {
            registerFirebase(email,password)
        }
    }

    private fun registerFirebase(email: String, password: String) {
        auth = FirebaseAuth.getInstance()
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(Activity()) { task ->
                if (task.isSuccessful) {
                    val userId = task.result?.user?.uid
                    userRegisterFirebase.value = true
                } else {
                    userRegisterFirebase.value = false
                }
            }
    }
}