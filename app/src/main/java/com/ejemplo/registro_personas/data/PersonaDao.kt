package com.ejemplo.registro_personas.data

import androidx.room.*
import com.ejemplo.registro_personas.model.Persona
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun Insertar(persona:Persona)

    @Delete
    suspend fun Eliminar(persona:Persona)

    @Query("SELECT * FROM Personas ORDER BY personaId")
    fun GetList(): Flow<List<Persona>>
}