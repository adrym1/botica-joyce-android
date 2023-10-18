package com.cibertec.farmacia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottomNavView)

        // Configurar el listener para los cambios de fragmento
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.itemProductos -> {
                    // Reemplazar el fragmento actual con el fragmento "Productos"
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, ProductosDisponiblesFragment())
                        .commit()
                    true
                }

                R.id.itemMantenimiento -> {
                    // Reemplazar el fragmento actual con el fragmento "Mantenimiento"
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, MantenimientoFragment())
                        .commit()
                    true
                }

                R.id.itemCuenta -> {
                    // Reemplazar el fragmento actual con el fragmento "Cuenta"
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, CuentaFragment())
                        .commit()
                    true
                }

                else -> false
            }
        }

        // Establecer el fragmento inicial
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, ProductosDisponiblesFragment())
            .commit()
    }
}