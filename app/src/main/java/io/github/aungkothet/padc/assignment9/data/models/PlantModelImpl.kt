package io.github.aungkothet.padc.assignment9.data.models

import io.github.aungkothet.padc.assignment9.data.vos.FavPlantsVo
import io.github.aungkothet.padc.assignment9.data.vos.PlantVo

object PlantModelImpl : BaseModel(), PlantModel {
    override fun removeFavPlant(favPlantsVo: FavPlantsVo) {
        dataBase.favPlantDao().removeFavPlant(favPlantsVo)
    }

    override fun getFavPlantByPlantId(plantId: String): FavPlantsVo {
        return dataBase.favPlantDao().getFavPlantByPlantId(plantId)
    }

    override fun addFavPlant(favPlantsVo: FavPlantsVo) {
        dataBase.favPlantDao().insetFavPlant(favPlantsVo)
    }

    override fun getFavPlants(onSuccess: (List<PlantVo>) -> Unit, onFailure: (String) -> Unit) {
        val plantsFromDB = dataBase.favPlantDao().getFavPlantList()
        if (plantsFromDB.isNotEmpty()) {
            onSuccess(plantsFromDB)
        } else {
            onFailure("No Favourite Plant Added!!")
        }
    }

    override fun getPlants(onSuccess: (List<PlantVo>) -> Unit, onFailure: (String) -> Unit) {
        val plantsFromDB = dataBase.plantDao().getAllPlants()
        if (plantsFromDB.isNotEmpty()) {
            onSuccess(plantsFromDB)
        } else {
            dataAgent.getPlantList({
                dataBase.plantDao().insetPlants(it)
                onSuccess(it)
            }, onFailure)
        }
    }

    override fun getPlantById(plantId: String): PlantVo {
        return dataBase.plantDao().getPlantById(plantId)
    }


}