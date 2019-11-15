package io.github.aungkothet.padc.assignment9.utils

import android.content.Context
import io.github.aungkothet.padc.assignment9.persistance.PlantDataBase

object DataBaseProvider{

    lateinit var plantDataBase: PlantDataBase

    fun initDataBase(context: Context){
        plantDataBase = PlantDataBase.getInstance(context)
    }
}