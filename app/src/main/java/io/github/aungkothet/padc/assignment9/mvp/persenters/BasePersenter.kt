package io.github.aungkothet.padc.assignment9.mvp.persenters

import androidx.lifecycle.ViewModel
import io.github.aungkothet.padc.assignment9.mvp.views.BaseView

abstract class BasePersenter<T: BaseView>: ViewModel(){
    protected lateinit var mView: T

    open fun initPresenter(view: T) {
        mView = view
    }
}