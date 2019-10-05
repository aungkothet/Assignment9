package io.github.aungkothet.padc.assignment9.mvp.views

import io.github.aungkothet.padc.assignment9.data.vos.PlantVo
import io.github.aungkothet.padc.assignment9.data.vos.UserVo

interface StartView : BaseView {
    fun showPlantList(plantList: List<PlantVo>)
    fun navigateToDetail(plantId: String)
    fun showErrorMessage(message: String)


    fun bindUserDataToNav(userVo: UserVo)
    fun navigateToFavList()

    fun logout()
}