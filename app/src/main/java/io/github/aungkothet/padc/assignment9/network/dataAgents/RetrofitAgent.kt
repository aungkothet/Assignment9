package io.github.aungkothet.padc.assignment9.network.dataAgents

import io.github.aungkothet.padc.assignment9.data.vos.PlantVo
import io.github.aungkothet.padc.assignment9.data.vos.UserVo
import io.github.aungkothet.padc.assignment9.network.PlantApi
import io.github.aungkothet.padc.assignment9.network.responses.LoginResponse
import io.github.aungkothet.padc.assignment9.network.responses.PlantResponse
import io.github.aungkothet.padc.assignment9.utils.BASE_URL
import io.github.aungkothet.padc.assignment9.utils.EM_NULL_RESPONSE
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitAgent : PlantDataAgent {

    private val plantApi: PlantApi

    init {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        plantApi = retrofit.create(PlantApi::class.java)
    }

    override fun login(
        email: String,
        password: String,
        onSuccess: (UserVo) -> Unit,
        onFailure: (String) -> Unit
    ) {
        val call = plantApi.login(email = email,password = password)
        call.enqueue(object : Callback<LoginResponse> {
            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                onFailure(t.localizedMessage)
            }

            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                val loginResponse = response.body()
                if (loginResponse != null) {
                    if (loginResponse.isResponseOk())
                        onSuccess(loginResponse.data!!)
                    else
                        onFailure(response.message())
                } else {
                    onFailure(EM_NULL_RESPONSE)
                }
            }
        })
    }

    override fun getPlantList(onSuccess: (List<PlantVo>) -> Unit, onFailure: (String) -> Unit) {
        val call = plantApi.getPlantList()
        call.enqueue(object : Callback<PlantResponse> {
            override fun onResponse(call: Call<PlantResponse>, response: Response<PlantResponse>) {

                val plantResponse = response.body()
                if (plantResponse != null) {
                    if (plantResponse.isResponseOk())
                        onSuccess(plantResponse.data!!)
                    else
                        onFailure(response.message())
                } else {
                    onFailure(EM_NULL_RESPONSE)
                }
            }

            override fun onFailure(call: Call<PlantResponse>, t: Throwable) {
                onFailure(t.localizedMessage)
            }
        })
    }
}