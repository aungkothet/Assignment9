package io.github.aungkothet.padc.assignment9.data.models

import androidx.lifecycle.LiveData
import io.github.aungkothet.padc.assignment9.data.vos.FavPlantsVo
import io.github.aungkothet.padc.assignment9.data.vos.PlantVo

interface PlantModel {
    fun getPlants(

        onFailure: (String) -> Unit
    ): LiveData<List<PlantVo>>

    fun getPlantById(plantId: String): LiveData<PlantVo>

    fun getFavPlants( onFailure: (String) -> Unit): LiveData<List<PlantVo>>

    fun getFavPlantByPlantId(plantId: String): FavPlantsVo?

    fun addFavPlant(favPlantsVo: FavPlantsVo)

    fun removeFavPlant(favPlantsVo: FavPlantsVo)
}