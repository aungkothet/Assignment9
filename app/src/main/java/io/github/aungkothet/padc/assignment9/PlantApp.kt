package io.github.aungkothet.padc.assignment9

import android.app.Application
import io.github.aungkothet.padc.assignment9.data.models.LoginModelImpl
import io.github.aungkothet.padc.assignment9.data.models.PlantModelImpl

class PlantApp: Application() {
    override fun onCreate() {
        super.onCreate()
        PlantModelImpl.initializeDatabase(this)
        LoginModelImpl.initializeDatabase(this)
    }
}