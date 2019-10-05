package io.github.aungkothet.padc.assignment9.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import io.github.aungkothet.padc.assignment9.data.models.LoginModelImpl
import io.github.aungkothet.padc.assignment9.data.models.PlantModelImpl

abstract class BaseActivity : AppCompatActivity() {
    protected lateinit var plantDataAgent: PlantModelImpl
    protected lateinit var userDataAgent: LoginModelImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        plantDataAgent = PlantModelImpl
        userDataAgent = LoginModelImpl
    }

    fun showSnackBar(message: String) {
        val snackBar = Snackbar.make(window.decorView, message, Snackbar.LENGTH_INDEFINITE)
        snackBar.setAction("OK") { snackBar.dismiss() }
        snackBar.show()
    }
}