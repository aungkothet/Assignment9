package io.github.aungkothet.padc.assignment9.network

import io.github.aungkothet.padc.assignment9.network.responses.LoginResponse
import io.github.aungkothet.padc.assignment9.network.responses.PlantResponse
import io.github.aungkothet.padc.assignment9.utils.PARAM_EMAIL
import io.github.aungkothet.padc.assignment9.utils.PARAM_PASSWORD
import io.github.aungkothet.padc.assignment9.utils.URL_GET_ALL_PLANTS
import io.github.aungkothet.padc.assignment9.utils.URL_LOG_IN
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface PlantApi {

    @POST(URL_LOG_IN)
    @FormUrlEncoded
    fun login(@Field(PARAM_EMAIL) email: String,@Field(PARAM_PASSWORD) password: String): Call<LoginResponse>

    @POST(URL_GET_ALL_PLANTS)
    fun getPlantList(): Call<PlantResponse>

}