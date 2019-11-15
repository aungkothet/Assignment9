package io.github.aungkothet.padc.assignment9.activities

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import androidx.core.app.ActivityOptionsCompat
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
        setUpTransaction()
        mPresenter = ViewModelProviders.of(this).get(MainPresenter::class.java)
        mPresenter.initPresenter(this)
        mPresenter.onUiReady(this)
    }

    fun setUpTransaction() {
        val displayMatrix = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMatrix)
        val width = displayMatrix.widthPixels

        val loginText = ObjectAnimator.ofFloat(
            textView2,
            View.ALPHA,
            0f,
            1f
        )
        val profileImage = ObjectAnimator.ofFloat(
            profileImage,
            View.ALPHA,
            0f,
            1f
        )

        val textView3ALPHA = ObjectAnimator.ofFloat(
            textView3,
            View.ALPHA,
            0f,
            1f
        )
        val emailTextViewALPHA = ObjectAnimator.ofFloat(
            emailTextView,
            View.ALPHA,
            0f,
            1f
        )
        val textView4ALPHA = ObjectAnimator.ofFloat(
            textView4,
            View.ALPHA,
            0f,
            1f
        )
        val passwordTextViewALPHA = ObjectAnimator.ofFloat(
            passwordTextView,
            View.ALPHA,
            0f,
            1f
        )
        val textView5ALPHA = ObjectAnimator.ofFloat(
            textView5,
            View.ALPHA,
            0f,
            1f
        )

        val textView3 = ObjectAnimator.ofFloat(
            textView3,
            View.TRANSLATION_X,
            width.toFloat(),
            0f
        )
        val emailTextView = ObjectAnimator.ofFloat(
            emailTextView,
            View.TRANSLATION_X,
            width.toFloat(),
            0f
        )
        val textView4 = ObjectAnimator.ofFloat(
            textView4,
            View.TRANSLATION_X,
            width.toFloat(),
            0f
        )
        val passwordTextView = ObjectAnimator.ofFloat(
            passwordTextView,
            View.TRANSLATION_X,
            width.toFloat(),
            0f
        )
        val textView5 = ObjectAnimator.ofFloat(
            textView5,
            View.TRANSLATION_X,
            width.toFloat(),
            0f
        )
        val loginButtonALPHA = ObjectAnimator.ofFloat(
            loginButton,
            View.ALPHA,
            0f,
            1f
        )
        val loginButton = ObjectAnimator.ofFloat(
            loginButton,
            View.TRANSLATION_X,
            (0 - width).toFloat(),
            0f
        )
        val anim1 = AnimatorSet().apply {
            play(loginText).with(profileImage)
        }
        val anim3 =  AnimatorSet().apply {
            play(loginButtonALPHA).with(loginButton)
        }
        val anim2 = AnimatorSet().apply {
            play(textView3).with(textView4).with(textView5).with(emailTextView)
                .with(passwordTextView)
                .with(textView3ALPHA).with(textView4ALPHA).with(textView5ALPHA)
                .with(emailTextViewALPHA).with(passwordTextViewALPHA)
                .before(anim3)
        }

        AnimatorSet().apply {
            play(anim1).before(anim2)
            duration = 1000L
            start()
        }
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
        startActivity(
            StartActivity.newIntent(this, userId),
            ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle()
        )
        finish()
    }


}
