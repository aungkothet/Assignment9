package io.github.aungkothet.padc.assignment9.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import io.github.aungkothet.padc.assignment9.R
import io.github.aungkothet.padc.assignment9.data.vos.TipsVo
import io.github.aungkothet.padc.assignment9.views.holders.TipsViewHolder

class TipsRecyclerAdapter() :
    BaseRecyclerAdapter<TipsViewHolder, TipsVo>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipsViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_tips_card, parent, false)
        return TipsViewHolder(view)
    }
}