package io.github.aungkothet.padc.assignment9.activities

import android.os.Bundle
import android.transition.Fade
import android.transition.Slide
import android.view.Gravity
import android.view.Window
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import io.github.aungkothet.padc.assignment9.R
import io.github.aungkothet.padc.assignment9.adapters.FavPlantListRecyclerAdapter
import io.github.aungkothet.padc.assignment9.data.vos.PlantVo
import io.github.aungkothet.padc.assignment9.mvp.persenters.FavPlantListPresenter
import io.github.aungkothet.padc.assignment9.mvp.persenters.MainPresenter
import io.github.aungkothet.padc.assignment9.mvp.views.FavPlantListView
import kotlinx.android.synthetic.main.activity_favourite_list.*


class FavouriteListActivity : BaseActivity(), FavPlantListView {
    override fun showFavPlantList(plantList: List<PlantVo>) {
        favPlantListRecyclerAdapter.setNewData(plantList.toMutableList())
    }

    override fun showErrorMessage(message: String) {
        showSnackBar(message)
    }

    private lateinit var favPlantListRecyclerAdapter: FavPlantListRecyclerAdapter
    private lateinit var mPresenter: FavPlantListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpTransition()
        setContentView(R.layout.activity_favourite_list)
        mPresenter = ViewModelProviders.of(this).get(FavPlantListPresenter::class.java)
        mPresenter.initPresenter(this)
        favPlantListRecyclerAdapter = FavPlantListRecyclerAdapter()
        with(favPlantRecyclerList) {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(context, 2)
            adapter = favPlantListRecyclerAdapter
        }
        mPresenter.onUiReady(this)

    }


    private fun setUpTransition() {
        with(window) {
            requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
            val slideTransition = Slide()
            slideTransition.slideEdge = Gravity.BOTTOM
            slideTransition.interpolator = AccelerateDecelerateInterpolator()
            slideTransition.duration = 600
            enterTransition = slideTransition
            exitTransition = slideTransition
        }
    }
}
