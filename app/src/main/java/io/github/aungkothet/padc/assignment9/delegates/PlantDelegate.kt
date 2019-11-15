package io.github.aungkothet.padc.assignment9.delegates

import android.widget.ImageView

interface PlantDelegate {
    fun onTabItemEvent(plantId: String,plantImage:ImageView)

    fun favButtonClicked(plantId: String,toggleStatus: Boolean)

}