package com.ejemplo.registro_personas.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "Personas")
@Parcelize
data class Persona(
    @PrimaryKey(autoGenerate = true)
    val personaId: Int,
    val nombres: String,
    val email: String,
    val ocupacion: String,
    val salario: Float
    ): Parcelable
