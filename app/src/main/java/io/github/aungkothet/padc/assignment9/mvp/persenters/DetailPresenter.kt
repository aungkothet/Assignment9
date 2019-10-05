package io.github.aungkothet.padc.assignment9.mvp.persenters

import io.github.aungkothet.padc.assignment9.data.models.PlantModelImpl
import io.github.aungkothet.padc.assignment9.mvp.views.DetailView

class DetailPresenter : BasePersenter<DetailView>(){

    fun favButtonClicked(plantId : String){
        mView.favButtonClicked(plantId)
    }

    fun onUiReady(plantId: String){
        val plantVo = PlantModelImpl.getPlantById(plantId)
        mView.bindPlantDetail(plantVo)
    }
}