package io.github.aungkothet.padc.assignment9.mvp.views

import io.github.aungkothet.padc.assignment9.data.vos.PlantVo

interface FavPlantListView : BaseView {

    fun showFavPlantList(plantList: List<PlantVo>)
    fun showErrorMessage(message:String)
}