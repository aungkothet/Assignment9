package io.github.aungkothet.padc.assignment9.activities

import android.animation.ObjectAnimator
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.transition.Fade
import android.util.DisplayMetrics
import android.view.MenuItem
import android.view.View
import android.view.Window
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.ImageView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.core.view.GravityCompat
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import coil.api.load
import com.google.android.material.navigation.NavigationView
import io.github.aungkothet.padc.assignment9.R
import io.github.aungkothet.padc.assignment9.adapters.PlantRecyclerAdapter
import io.github.aungkothet.padc.assignment9.data.vos.PlantVo
import io.github.aungkothet.padc.assignment9.data.vos.UserVo
import io.github.aungkothet.padc.assignment9.mvp.persenters.StartPresenter
import io.github.aungkothet.padc.assignment9.mvp.views.StartView
import kotlinx.android.synthetic.main.activity_start.*
import kotlinx.android.synthetic.main.app_bar_start.*
import kotlinx.android.synthetic.main.content_flower_list.*
import kotlinx.android.synthetic.main.nav_header_start.view.*

class StartActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener, StartView {
    override fun logout() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    companion object {
        private const val IE_USER = "intentUser"
        fun newIntent(context: Context, id: String): Intent {
            val intent = Intent(context, StartActivity::class.java)
            intent.putExtra(IE_USER, id)
            return intent
        }
    }

    private fun setUpTransition() {
        with(window) {
            requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
            val fadeTransaction = Fade()
            fadeTransaction.interpolator = AccelerateDecelerateInterpolator()
            fadeTransaction.duration = 600
            enterTransition = fadeTransaction
        }
    }

    private lateinit var plantAdapter: PlantRecyclerAdapter
    private lateinit var mPresenter: StartPresenter

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.nav_favourite) {
            mPresenter.navFavClicked()
        } else if (item.itemId == R.id.nav_logout) {
            mPresenter.navLogoutClicked(this.userVo)
        }

        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    lateinit var userVo: UserVo
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpTransition()
        setContentView(R.layout.activity_start)
        mPresenter = ViewModelProviders.of(this).get(StartPresenter::class.java)
        mPresenter.initPresenter(this)
        plantAdapter = PlantRecyclerAdapter(mPresenter)
        mPresenter.onUiReady(this)

        setSupportActionBar(toolbar)
        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)
        toggle.isDrawerIndicatorEnabled = true


        val displayMatrix = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMatrix)
        val width = displayMatrix.widthPixels

        ObjectAnimator.ofFloat(
            plantList,
            View.TRANSLATION_X,
            width.toFloat(),
            0f
        ).apply {
            duration = 1000L
            start()
        }


        with(plantList) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = plantAdapter
        }

    }

    override fun showPlantList(plantList: List<PlantVo>) {
        plantAdapter.setNewData(plantList.toMutableList())
    }

    override fun navigateToDetail(plantId: String, plantImage: ImageView) {
        val pair = Pair.create(plantImage as View, "tPlantImage")

        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, pair)

        startActivity(DetailActivity.newIntent(this, plantId), options.toBundle())
    }

    override fun showErrorMessage(message: String) {
        showSnackBar(message)
    }

    override fun navigateToFavList() {
        startActivity(
            Intent(this, FavouriteListActivity::class.java),
            ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle()
        )
    }

    override fun bindUserDataToNav(userVo: UserVo) {
        this.userVo = userVo
        val view = navView.getHeaderView(0)
        view.profileImage.load(userVo.userPhotoUrl)
        view.userName.text = userVo.userName
        view.memberRankTextView.text = userVo.memberRank
    }
}
