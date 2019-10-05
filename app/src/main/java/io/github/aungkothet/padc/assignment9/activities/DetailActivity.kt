package io.github.aungkothet.padc.assignment9.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import coil.api.load
import io.github.aungkothet.padc.assignment9.R
import io.github.aungkothet.padc.assignment9.adapters.PlantImagePagerAdapter
import io.github.aungkothet.padc.assignment9.adapters.TipsRecyclerAdapter
import io.github.aungkothet.padc.assignment9.data.vos.PlantVo
import io.github.aungkothet.padc.assignment9.data.vos.TipsVo
import io.github.aungkothet.padc.assignment9.mvp.persenters.DetailPresenter
import io.github.aungkothet.padc.assignment9.mvp.views.DetailView
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_detail.*

class DetailActivity : BaseActivity(), DetailView {

    companion object {
        private const val IE_PLANT_ID = "intentPlant"
        fun newIntent(context: Context, id: String): Intent {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(IE_PLANT_ID, id)
            return intent
        }
    }

    private lateinit var tipsRecyclerAdapter: TipsRecyclerAdapter
    private lateinit var mPresenter: DetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(toolbar)
        mPresenter = DetailPresenter()
        mPresenter.initPresenter(this)
        tipsRecyclerAdapter = TipsRecyclerAdapter()
        mPresenter.onUiReady(intent.getStringExtra(IE_PLANT_ID)!!)
        with(tipsRecyclerView) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = tipsRecyclerAdapter
        }
    }

    override fun bindPlantDetail(plantVo: PlantVo) {
        plantName.text = plantVo.plantName
        uploaderPhoto.load(plantVo.uploadedUserVo.userPhoto)
        plantUploaderName.text = plantVo.uploadedUserVo.name
        plantDesc.text = plantVo.description
        val plantImagePagerAdapter = PlantImagePagerAdapter(plantVo.plantPhoto)
        vpPlantImages.adapter = plantImagePagerAdapter
        val tips = arrayListOf(
            TipsVo("", plantVo.tips.light, ""),
            TipsVo(plantVo.tips.temperature, "", ""),
            TipsVo("", "", plantVo.tips.placement)
        )
        tipsRecyclerAdapter.appendNewData(tips)
        fab.setOnClickListener {
            mPresenter.favButtonClicked(plantVo.plantId)
        }
    }

    override fun favButtonClicked(plantId: String) {
        Toast.makeText(this, "favButtonClicked clicked", Toast.LENGTH_SHORT).show()

    }

    override fun onStart() {
        super.onStart()
        mPresenter.onStart()
    }

    override fun onStop() {
        super.onStop()
        mPresenter.onStop()
    }

    override fun onResume() {
        super.onResume()
        mPresenter.onResume()
    }

    override fun onPause() {
        super.onPause()
        mPresenter.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.onDestroy()
    }
}
