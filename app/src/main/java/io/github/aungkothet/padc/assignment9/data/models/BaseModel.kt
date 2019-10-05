package io.github.aungkothet.padc.assignment9.data.models

import android.content.Context
import io.github.aungkothet.padc.assignment9.network.dataAgents.PlantDataAgent
import io.github.aungkothet.padc.assignment9.network.dataAgents.RetrofitAgent
import io.github.aungkothet.padc.assignment9.persistance.PlantDataBase

abstract class BaseModel {
    protected lateinit var dataBase: PlantDataBase
    protected val dataAgent:PlantDataAgent = RetrofitAgent

    fun initializeDatabase(context: Context){
        dataBase = PlantDataBase.getInstance(context)
    }
}