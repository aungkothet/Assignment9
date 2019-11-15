package io.github.aungkothet.padc.assignment9.mvp.persenters

import androidx.lifecycle.Observer
import io.github.aungkothet.padc.assignment9.activities.BaseActivity
import io.github.aungkothet.padc.assignment9.data.models.LoginModelImpl
import io.github.aungkothet.padc.assignment9.mvp.views.MainView

class MainPresenter : BasePersenter<MainView>() {

    fun onUiReady(activity: BaseActivity) {
        LoginModelImpl.checkLoggedIn().observe(activity, Observer {
            if (it.isNotEmpty()) {
                mView.navigateToPlantList(it[0].userId)
            }
        })
    }

    fun onLoginButtonClicked(email: String, password: String) {
        LoginModelImpl.login(email, password, {
            mView.navigateToPlantList(it.userId)
        }, {
            mView.showErrorMessage(it)
        })
    }

}
