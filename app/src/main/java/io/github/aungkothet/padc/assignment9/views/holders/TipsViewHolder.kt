package io.github.aungkothet.padc.assignment9.views.holders

import android.view.View
import coil.api.load
import io.github.aungkothet.padc.assignment9.R
import io.github.aungkothet.padc.assignment9.data.vos.PlantVo
import io.github.aungkothet.padc.assignment9.data.vos.TipsVo
import io.github.aungkothet.padc.assignment9.delegates.PlantDelegate
import kotlinx.android.synthetic.main.item_plant_card.view.*
import kotlinx.android.synthetic.main.item_tips_card.view.*

class TipsViewHolder(itemView: View) :BaseViewHolder<TipsVo>(itemView){

    override fun bindData(data: TipsVo) {


            if(data.light.isNotEmpty()){

                itemView.card.setBackgroundColor(itemView.resources.getColor(R.color.colorAccent))
                itemView.imgTips.load(R.drawable.light)
                itemView.tipsTitle.text = "Light"
                itemView.tipsDesc.text = data.light
            } else if(data.temperature.isNotEmpty()){
                itemView.card.setBackgroundColor(itemView.resources.getColor(R.color.colorPrimary))

                itemView.imgTips.load(R.drawable.temperature)
                itemView.tipsTitle.text = "Temperature"
                itemView.tipsDesc.text = data.temperature
            }else if(data.placement.isNotEmpty()){
                itemView.card.setBackgroundColor(itemView.resources.getColor(R.color.colorAccent))

                itemView.imgTips.load(R.drawable.light)
                itemView.tipsTitle.text = "Placement"
                itemView.tipsDesc.text = data.placement
            }

    }
}