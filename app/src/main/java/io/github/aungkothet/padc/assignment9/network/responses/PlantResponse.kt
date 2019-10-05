package io.github.aungkothet.padc.assignment9.network.responses

import com.google.gson.annotations.SerializedName
import io.github.aungkothet.padc.assignment9.data.vos.PlantVo
import io.github.aungkothet.padc.assignment9.utils.CODE_RESPONSE_OK

data class PlantResponse(
    @SerializedName("code")
    val code:Int,
    @SerializedName("message")
    val message:String,
    @SerializedName("data")
    val data: List<PlantVo>?) {
    fun isResponseOk(): Boolean {
        return code == CODE_RESPONSE_OK && data != null
    }
}