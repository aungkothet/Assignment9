package io.github.aungkothet.padc.assignment9.delegates

interface PlantDelegate {
    fun onTabItemEvent(plantId: String)

    fun favButtonClicked(plantId: String,toggleStatus: Boolean)

}