package io.github.aungkothet.padc.assignment9.data.models

import io.github.aungkothet.padc.assignment9.data.vos.FavPlantsVo
import io.github.aungkothet.padc.assignment9.data.vos.PlantVo

interface PlantModel {
    fun getPlants(
        onSuccess: (List<PlantVo>) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getPlantById(plantId: String): PlantVo

    fun getFavPlants(
        onSuccess: (List<PlantVo>) -> Unit, onFailure: (String) -> Unit
    )

    fun getFavPlantByPlantId(plantId: String): FavPlantsVo

    fun addFavPlant(favPlantsVo: FavPlantsVo)

    fun removeFavPlant(favPlantsVo: FavPlantsVo)
}