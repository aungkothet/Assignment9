package io.github.aungkothet.padc.assignment9.data.models

import androidx.lifecycle.LiveData
import io.github.aungkothet.padc.assignment9.data.vos.UserVo

object LoginModelImpl : BaseModel(), LoginModel {
    override fun checkLoggedIn(): LiveData<List<UserVo>> {
        return dataBase.userDao().getLoginUser()

    }

    override fun login(
        email: String,
        password: String,
        onSuccess: (UserVo) -> Unit, onFailure: (String) -> Unit
    ) {
        dataAgent.login(email = email, password = password, onSuccess = {
            val userList = listOf(it)
            dataBase.userDao().setLoginUser(userList)
            onSuccess(it)
        }, onFailure = onFailure)
    }

    override fun logout(userVo: UserVo) {
        dataBase.userDao().logout(userVo)
    }
}