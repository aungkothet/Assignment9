package io.github.aungkothet.padc.assignment9.activities

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import io.github.aungkothet.padc.assignment9.R
import io.github.aungkothet.padc.assignment9.mvp.persenters.MainPresenter
import io.github.aungkothet.padc.assignment9.mvp.views.MainView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), MainView {

    override fun showErrorMessage(message: String) {
        showSnackBar(message)
    }

    private lateinit var mPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mPresenter = ViewModelProviders.of(this).get(MainPresenter::class.java)
        mPresenter.initPresenter(this)
        mPresenter.onUiReady(this)
    }

    fun login(view: View) {
        val email = emailTextView.text.toString()
        val password = passwordTextView.text.toString()
        if (isEmailValid(email) && isPasswordValid(password))
            mPresenter.onLoginButtonClicked(email, password)
    }

    private fun isEmailValid(email: String?): Boolean {
        if (email.isNullOrBlank() || email.isNullOrEmpty()) {
            emailTextView.error = "Enter valid email!"
            return false
        } else {
            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                emailTextView.error = "Enter valid email!"
                return false
            }
        }
        return true
    }

    private fun isPasswordValid(password: String?): Boolean {
        if (password.isNullOrBlank() || password.isNullOrEmpty()) {
            passwordTextView.error = "Enter password!"
            return false
        }
        return true
    }

    override fun navigateToPlantList(userId: String) {
        startActivity(StartActivity.newIntent(this, userId))
        finish()
    }


}
