package edu.ucne.proyecto_final.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Interno(
    @PrimaryKey(autoGenerate = true)
    val InternoId: Int,
    val Nombre: String,
    val Apellido: String,
    val Ficha: String,
    val Pabellon: String
)
