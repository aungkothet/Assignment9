package io.github.aungkothet.padc.assignment9.persistance.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class PlantTypeConverter {
    @TypeConverter
    fun toString(list: List<String>): String {
        return Gson().toJson(list)
    }

    @TypeConverter
    fun toList(json: String): List<String> {
        return Gson().fromJson<List<String>>(json, object : TypeToken<List<String>>() {}.type)
    }
}