package io.github.aungkothet.padc.assignment9.adapters

import androidx.recyclerview.widget.RecyclerView
import io.github.aungkothet.padc.assignment9.views.holders.BaseViewHolder
import java.util.ArrayList


abstract class BaseRecyclerAdapter<VH : BaseViewHolder<T>, T> : RecyclerView.Adapter<VH>() {

    var data: MutableList<T> = ArrayList()

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.data = data[position]
    }

    fun setNewData(newData:MutableList<T>){
        data = newData
        notifyDataSetChanged()
    }

    fun appendNewData(newData: ArrayList<T>){
        data.addAll(newData)
        notifyDataSetChanged()
    }

}