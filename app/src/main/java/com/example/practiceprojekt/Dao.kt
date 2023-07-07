package com.example.practiceprojekt

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    @Insert
    fun insertClient(item: Item)
    @Query("SELECT * FROM clients")
    fun getAllClients(): Flow<List<Item>>
}