package io.github.aungkothet.padc.assignment9.mvp.persenters

import io.github.aungkothet.padc.assignment9.data.models.PlantModelImpl
import io.github.aungkothet.padc.assignment9.mvp.views.FavPlantListView

class FavPlantListPresenter : BasePersenter<FavPlantListView>() {

    override fun onCreate() {
        super.onCreate()
        PlantModelImpl.getFavPlants({
            mView.showFavPlantList(it)
        },{
            mView.showErrorMessage(it)
        })
    }
}