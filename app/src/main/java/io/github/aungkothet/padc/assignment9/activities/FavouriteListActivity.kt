package io.github.aungkothet.padc.assignment9.activities

import android.os.Bundle
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


}
