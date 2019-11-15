package io.github.aungkothet.padc.assignment9.mvp.views

import io.github.aungkothet.padc.assignment9.data.vos.PlantVo

interface DetailView : BaseView{

    fun favButtonClicked(message: String)

    fun bindPlantDetail(plantVo: PlantVo)

}