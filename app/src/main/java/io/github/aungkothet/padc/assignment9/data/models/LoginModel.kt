package io.github.aungkothet.padc.assignment9.data.models

import io.github.aungkothet.padc.assignment9.data.vos.UserVo

interface LoginModel {
    fun login(
        email: String,
        password: String,
        onSuccess: (UserVo) -> Unit,
        onFailure: (String) -> Unit
    )

    fun logout(userVo: UserVo)

    fun checkLoggedIn():UserVo?
}