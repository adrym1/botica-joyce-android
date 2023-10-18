package com.cibertec.farmacia.login

import android.app.Activity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class LoginViewModel: ViewModel() {
    private lateinit var auth: FirebaseAuth
    val userLoginServiceResponse = MutableLiveData<Boolean>()

    fun verificarLogin(username: String, password: String) {
        if (username.isEmpty() || password.isEmpty()) {
            userLoginServiceResponse.value = false
        }
        else if (password.length <6) {
            userLoginServiceResponse.value = false
        }
        else {
            loginFirebase(username,password)
        }
    }

    private fun loginFirebase(username: String, password: String) {
        auth = FirebaseAuth.getInstance()
        auth.signInWithEmailAndPassword(username, password)
            .addOnCompleteListener(Activity()) { task ->
                if (task.isSuccessful) {
                    val userId = task.result?.user?.uid
                    userLoginServiceResponse.value = true
                } else {
                    userLoginServiceResponse.value = false
                }
            }
    }
}