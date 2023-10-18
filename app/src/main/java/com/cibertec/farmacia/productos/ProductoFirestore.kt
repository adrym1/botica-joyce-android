package com.cibertec.farmacia.productos

data class ProductoFirestore(
    val nombre: String?,
    val laboratorio: String?,
    val ifa: String?,
    val precio_empaq: String?,
    val precio_unit: String?
)
