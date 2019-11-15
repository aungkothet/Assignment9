package io.github.aungkothet.padc.assignment9.data.models

import io.github.aungkothet.padc.assignment9.network.dataAgents.PlantDataAgent
import io.github.aungkothet.padc.assignment9.network.dataAgents.RetrofitAgent
import io.github.aungkothet.padc.assignment9.utils.DataBaseProvider

abstract class BaseModel {
    protected val dataBase = DataBaseProvider.plantDataBase
    protected val dataAgent: PlantDataAgent = RetrofitAgent
}