package io.github.aungkothet.padc.assignment9.network.dataAgents

import io.github.aungkothet.padc.assignment9.data.vos.PlantVo
import io.github.aungkothet.padc.assignment9.data.vos.UserVo

interface PlantDataAgent {
    fun getPlantList(
        onSuccess: (List<PlantVo>) -> Unit,
        onFailure: (String) -> Unit
    )

    fun login(
        email: String,
        password: String,
        onSuccess: (UserVo) -> Unit,
        onFailure: (String) -> Unit
    )
}