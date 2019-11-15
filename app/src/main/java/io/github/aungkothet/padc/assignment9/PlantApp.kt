package io.github.aungkothet.padc.assignment9

import android.app.Application
import io.github.aungkothet.padc.assignment9.data.models.LoginModelImpl
import io.github.aungkothet.padc.assignment9.data.models.PlantModelImpl
import io.github.aungkothet.padc.assignment9.utils.DataBaseProvider

class PlantApp: Application() {
    override fun onCreate() {
        super.onCreate()
       DataBaseProvider.initDataBase(this)
    }
}