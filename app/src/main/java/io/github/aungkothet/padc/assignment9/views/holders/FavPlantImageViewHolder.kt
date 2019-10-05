package io.github.aungkothet.padc.assignment9.views.holders

import android.view.View
import coil.api.load
import io.github.aungkothet.padc.assignment9.data.vos.PlantVo
import kotlinx.android.synthetic.main.item_fav_image_card.view.*

class FavPlantImageViewHolder(itemView: View) :
    BaseViewHolder<PlantVo>(itemView) {

    override fun bindData(data: PlantVo) {
        itemView.fav_image.load(data.plantPhoto)
    }
}