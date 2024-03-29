package com.example.newsapp.data.dataBase

import androidx.room.TypeConverter
import com.example.newsapp.data.models.Source

class Converters {

    @TypeConverter
    fun fromSource(source: Source): String {
        return source.name
    }

    @TypeConverter
    fun toSource(name: String): Source {
        return Source(name, name)
    }
}