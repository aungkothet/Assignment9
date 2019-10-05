package io.github.aungkothet.padc.assignment9.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import io.github.aungkothet.padc.assignment9.R
import io.github.aungkothet.padc.assignment9.mvp.persenters.MainPresenter
import io.github.aungkothet.padc.assignment9.mvp.views.MainView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(),MainView {

    override fun showErrorMessage(message: String) {
        showSnackBar(message)
    }

    private lateinit var mPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mPresenter = MainPresenter()
        mPresenter.initPresenter(this)
        mPresenter.onCreate()
    }

    fun login(view: View){
        val email = emailTextView.text.toString()
        val password = passwordTextView.text.toString()
        mPresenter.login(email,password)

    }
    override fun navigateToPlantList(userId:String) {
        startActivity(StartActivity.newIntent(this,userId))
        finish()
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
