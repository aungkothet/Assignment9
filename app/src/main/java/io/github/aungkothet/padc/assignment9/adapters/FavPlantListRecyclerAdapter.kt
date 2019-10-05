package io.github.aungkothet.padc.assignment9.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import io.github.aungkothet.padc.assignment9.R
import io.github.aungkothet.padc.assignment9.data.vos.PlantVo
import io.github.aungkothet.padc.assignment9.views.holders.FavPlantImageViewHolder

class FavPlantListRecyclerAdapter :
    BaseRecyclerAdapter<FavPlantImageViewHolder, PlantVo>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavPlantImageViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_fav_image_card, parent, false)
        return FavPlantImageViewHolder(view)
    }
}