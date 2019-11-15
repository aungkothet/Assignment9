package io.github.aungkothet.padc.assignment9.mvp.persenters

import androidx.lifecycle.Observer
import io.github.aungkothet.padc.assignment9.activities.BaseActivity
import io.github.aungkothet.padc.assignment9.data.models.PlantModelImpl
import io.github.aungkothet.padc.assignment9.mvp.views.FavPlantListView

class FavPlantListPresenter : BasePersenter<FavPlantListView>() {

     fun onUiReady(activity: BaseActivity) {
        PlantModelImpl.getFavPlants{
            mView.showErrorMessage(it)
        }.observe(activity, Observer {
            if(it.isNullOrEmpty()){
                mView.showErrorMessage("No Favourite Plant Added!")
            }else {
                mView.showFavPlantList(it)
            }
        })
    }
}