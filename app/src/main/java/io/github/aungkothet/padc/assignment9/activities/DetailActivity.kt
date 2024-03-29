package io.github.aungkothet.padc.assignment9.activities

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Message
import android.util.DisplayMetrics
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import coil.api.load
import io.github.aungkothet.padc.assignment9.R
import io.github.aungkothet.padc.assignment9.adapters.PlantImagePagerAdapter
import io.github.aungkothet.padc.assignment9.adapters.TipsRecyclerAdapter
import io.github.aungkothet.padc.assignment9.data.vos.PlantVo
import io.github.aungkothet.padc.assignment9.data.vos.TipsVo
import io.github.aungkothet.padc.assignment9.mvp.persenters.DetailPresenter
import io.github.aungkothet.padc.assignment9.mvp.persenters.MainPresenter
import io.github.aungkothet.padc.assignment9.mvp.views.DetailView
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_detail.*
import kotlinx.android.synthetic.main.content_flower_list.*

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

    private var favStatus = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(toolbar)
        mPresenter = ViewModelProviders.of(this).get(DetailPresenter::class.java)
        mPresenter.initPresenter(this)
        tipsRecyclerAdapter = TipsRecyclerAdapter()
        mPresenter.onUiReady(intent.getStringExtra(IE_PLANT_ID)!!,this)


        val displayMatrix = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMatrix)
        val width = displayMatrix.widthPixels

        ObjectAnimator.ofFloat(
            tipsRecyclerView,
            View.TRANSLATION_X,
            width.toFloat(),
            0f
        ) .apply {
            duration = 500L
            start()
        }

        val xScaleAnimator = ObjectAnimator.ofFloat(
            fab,
            View.SCALE_X,
            0.25f,
            1f
        )

        val yScaleAnimator = ObjectAnimator.ofFloat(
            fab,
            View.SCALE_Y,
            0.25f,
            1f
        )

        AnimatorSet().apply {
            duration = 500
            play(xScaleAnimator).with(yScaleAnimator)
            start()
        }

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
            if(!favStatus)
            {
                favStatus = true
//                fab.setImageDrawable(getDrawable(R.drawable.ic_favorite))
                fab.speed = 1.0f
                fab.playAnimation()
            }
            else{
                favStatus = false
//                fab.setImageDrawable(getDrawable(R.drawable.ic_favorite_border))
                fab.speed = -4.0f
                fab.playAnimation()
            }
            mPresenter.favButtonClicked(plantVo.plantId,favStatus)
        }
    }

    override fun favButtonClicked(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }
}
