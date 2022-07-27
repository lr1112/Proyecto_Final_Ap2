package edu.ucne.proyecto_final.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Internos")
data class Interno(
    @PrimaryKey(autoGenerate = true)
    val InternoId: Int=0,
    val Nombre: String,
    val Apellido: String,
    val Ficha: String,
    val Pabellon: String,
    val isComplete: Boolean = false,
    val VisitanteId: Int
)
