package io.github.aungkothet.padc.assignment9.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import io.github.aungkothet.padc.assignment9.R
import io.github.aungkothet.padc.assignment9.data.vos.PlantVo
import io.github.aungkothet.padc.assignment9.delegates.PlantDelegate
import io.github.aungkothet.padc.assignment9.views.holders.PlantViewHolder

class PlantRecyclerAdapter(private val delegate: PlantDelegate) :
    BaseRecyclerAdapter<PlantViewHolder, PlantVo>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_plant_card, parent, false)
        return PlantViewHolder(view, delegate)
    }
}