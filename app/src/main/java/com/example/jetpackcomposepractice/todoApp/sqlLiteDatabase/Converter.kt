package com.example.jetpackcomposepractice.todoApp.sqlLiteDatabase

import androidx.room.TypeConverter
import androidx.room.TypeConverters
import java.util.Date

class Converter {

    @TypeConverter
    fun fromDate(date:Date):Long{
        return date.time
    }

    @TypeConverter
    fun toDate(time : Long):Date{
        return Date(time)
    }
}