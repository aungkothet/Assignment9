package io.github.aungkothet.padc.assignment9.views.holders

import android.view.View
import coil.api.load
import io.github.aungkothet.padc.assignment9.data.vos.PlantVo
import io.github.aungkothet.padc.assignment9.delegates.PlantDelegate
import kotlinx.android.synthetic.main.item_plant_card.view.*

class PlantViewHolder(itemView: View, private val delegate: PlantDelegate) :
    BaseViewHolder<PlantVo>(itemView) {

    init {
        itemView.setOnClickListener {
            data?.plantId?.let {
                delegate.onTabItemEvent(it,itemView.plantItemImage)
            }
        }
    }

    override fun bindData(data: PlantVo) {
        with(itemView) {
            fav_toggle.setOnClickListener {

                delegate.favButtonClicked(data.plantId, fav_toggle.isChecked)
            }
            plantItemName.text = data.plantName
            uploaderPhoto.load(data.uploadedUserVo.userPhoto)
            plantUploaderName.text = "by ${data.uploadedUserVo.name}"
            plantItemImage.load(data.plantPhoto)
        }
    }
}