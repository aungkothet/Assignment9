package io.github.aungkothet.padc.assignment9.mvp.persenters

import io.github.aungkothet.padc.assignment9.data.models.LoginModelImpl
import io.github.aungkothet.padc.assignment9.mvp.views.MainView

class MainPresenter :BasePersenter<MainView>(){

    override fun onStart() {
        super.onStart()
        val loggedInUser = LoginModelImpl.checkLoggedIn()
        if(loggedInUser != null)
        {
            mView.navigateToPlantList(loggedInUser.userId)
        }
    }

    fun login(email:String,password:String){
        LoginModelImpl.login(email,password,{
            mView.navigateToPlantList(it.userId)
        },{
            mView.showErrorMessage(it)
        })
    }

}
