package com.ejemplo.registro_personas.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ejemplo.registro_personas.model.Persona

@Database(
    entities = [Persona::class],
    version = 1
)
abstract class PersonasDb: RoomDatabase() {
    abstract val personaDao: PersonaDao


}