package com.example.practiceprojekt

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "clients")
data class Item (
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "number_phone")
    var numberPhone: String,
    @ColumnInfo(name = "password")
    var password: String,
        )