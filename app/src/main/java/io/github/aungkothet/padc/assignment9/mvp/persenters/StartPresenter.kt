package io.github.aungkothet.padc.assignment9.mvp.persenters

import android.media.Image
import android.widget.ImageView
import androidx.lifecycle.Observer
import io.github.aungkothet.padc.assignment9.activities.BaseActivity
import io.github.aungkothet.padc.assignment9.data.models.LoginModelImpl
import io.github.aungkothet.padc.assignment9.data.models.PlantModelImpl
import io.github.aungkothet.padc.assignment9.data.vos.FavPlantsVo
import io.github.aungkothet.padc.assignment9.data.vos.UserVo
import io.github.aungkothet.padc.assignment9.delegates.PlantDelegate
import io.github.aungkothet.padc.assignment9.mvp.views.StartView

class StartPresenter : BasePersenter<StartView>(), PlantDelegate {
    override fun onTabItemEvent(plantId: String,plantImage:ImageView) {
        mView.navigateToDetail(plantId,plantImage)
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

    fun navFavClicked(){
        mView.navigateToFavList()
    }

    fun onUiReady(activity: BaseActivity)
    {
        PlantModelImpl.getPlants{
            mView.showErrorMessage(it)
        }.observe(activity, Observer {
            mView.showPlantList(it)
        })
        LoginModelImpl.checkLoggedIn().observe(activity, Observer {
            mView.bindUserDataToNav(it[0])
        })
    }

    fun navLogoutClicked(userVo: UserVo)
    {
        LoginModelImpl.logout(userVo)
        mView.logout()
    }

}