package io.github.aungkothet.padc.assignment9.mvp.persenters

import io.github.aungkothet.padc.assignment9.mvp.views.BaseView

abstract class BasePersenter<T: BaseView>{
    protected lateinit var mView: T

    open fun initPresenter(view: T) {
        mView = view
    }

    open fun onCreate() {}

    open fun onStart() {}

    open fun onStop() {}

    open fun onResume() {}

    open fun onPause() {}

    open fun onDestroy() {}

}