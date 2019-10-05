package io.github.aungkothet.padc.assignment9.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import coil.api.load
import io.github.aungkothet.padc.assignment9.R
import kotlinx.android.synthetic.main.item_plant_detail_image.view.*

class PlantImagePagerAdapter(private val imageUrl: String) : PagerAdapter() {

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int = 4

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(container.context)
            .inflate(R.layout.item_plant_detail_image, container, false)
        view.vpPlantImage.load(imageUrl)
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}