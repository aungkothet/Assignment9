package io.github.aungkothet.padc.assignment9.mvp.views

interface MainView : BaseView {

    fun navigateToPlantList(userId:String)
    fun showErrorMessage(message:String)
}