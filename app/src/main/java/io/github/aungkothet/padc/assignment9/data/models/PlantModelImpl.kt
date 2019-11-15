package io.github.aungkothet.padc.assignment9.data.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
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

    override fun getFavPlants(onFailure: (String) -> Unit): LiveData<List<PlantVo>> {
        return dataBase.favPlantDao().getFavPlantList()

    }

    override fun getPlants(onFailure: (String) -> Unit): LiveData<List<PlantVo>> {
        dataAgent.getPlantList({
            dataBase.plantDao().insetPlants(it)
        }, onFailure)
        return Transformations.distinctUntilChanged(dataBase.plantDao().getAllPlants())
    }

    override fun getPlantById(plantId: String): LiveData<PlantVo> {
        return dataBase.plantDao().getPlantById(plantId)
    }


}