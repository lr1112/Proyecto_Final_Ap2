package edu.ucne.proyecto_final.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Visitantes")
data class Visitante(
    @PrimaryKey(autoGenerate = true)
    val VisitanteId: Int=0,
    val Nombre: String,
    val Apellido: String,
    val Parentesco: String,
    val isComplete: Boolean = false
)
