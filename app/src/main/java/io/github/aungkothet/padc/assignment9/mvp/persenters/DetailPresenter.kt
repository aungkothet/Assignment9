package io.github.aungkothet.padc.assignment9.mvp.persenters

import androidx.lifecycle.Observer
import io.github.aungkothet.padc.assignment9.activities.BaseActivity
import io.github.aungkothet.padc.assignment9.data.models.PlantModelImpl
import io.github.aungkothet.padc.assignment9.data.vos.FavPlantsVo
import io.github.aungkothet.padc.assignment9.mvp.views.DetailView

class DetailPresenter : BasePersenter<DetailView>() {

    fun favButtonClicked(plantId: String, isFavourite: Boolean) {
        var favPlantsVo = FavPlantsVo(plantId = plantId, id = 0)
        if (isFavourite){
            PlantModelImpl.addFavPlant(favPlantsVo)
            mView.favButtonClicked("Added To Favourite List!")

        }
        else {
            favPlantsVo = PlantModelImpl.getFavPlantByPlantId(plantId)
            PlantModelImpl.removeFavPlant(favPlantsVo)
            mView.favButtonClicked("Removed From Favourite List!")
        }

    }

    fun onUiReady(plantId: String, activity: BaseActivity) {
        PlantModelImpl.getPlantById(plantId)
            .observe(activity, Observer {
                mView.bindPlantDetail(it)
            })
    }
}