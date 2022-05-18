package com.ejemplo.registro_personas.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Profesiones")
data class Persona(
    @PrimaryKey(autoGenerate = true)
    val personaId: Int,
    val nombres: String,
    val email: String,
    val ocupacion: String,
    val salario: Float
    )
