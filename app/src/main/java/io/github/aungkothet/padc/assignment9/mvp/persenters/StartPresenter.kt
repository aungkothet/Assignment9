package io.github.aungkothet.padc.assignment9.mvp.persenters

import io.github.aungkothet.padc.assignment9.data.models.LoginModelImpl
import io.github.aungkothet.padc.assignment9.data.models.PlantModelImpl
import io.github.aungkothet.padc.assignment9.data.vos.FavPlantsVo
import io.github.aungkothet.padc.assignment9.data.vos.UserVo
import io.github.aungkothet.padc.assignment9.delegates.PlantDelegate
import io.github.aungkothet.padc.assignment9.mvp.views.StartView

class StartPresenter : BasePersenter<StartView>(), PlantDelegate {
    override fun onTabItemEvent(plantId: String) {
        mView.navigateToDetail(plantId)
    }

    override fun favButtonClicked(plantId: String,toggleStatus:Boolean) {
        var favPlantsVo = FavPlantsVo(plantId = plantId,id = 0)
        if(toggleStatus)
            PlantModelImpl.addFavPlant(favPlantsVo)
        else
        {
            favPlantsVo =  PlantModelImpl.getFavPlantByPlantId(plantId)
            PlantModelImpl.removeFavPlant(favPlantsVo)
        }
    }

    override fun onCreate() {
        super.onCreate()

        PlantModelImpl.getPlants({
            mView.showPlantList(it)
        },{
            mView.showErrorMessage(it)
        })
    }

    fun navFavClicked(){
        mView.navigateToFavList()
    }

    fun onUiReady()
    {
        mView.bindUserDataToNav(LoginModelImpl.checkLoggedIn()!!)
    }

    fun navLogoutClicked(userVo: UserVo)
    {
        LoginModelImpl.logout(userVo)
        mView.logout()
    }

}