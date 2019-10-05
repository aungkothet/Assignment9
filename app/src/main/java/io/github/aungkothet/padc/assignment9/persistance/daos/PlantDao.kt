package io.github.aungkothet.padc.assignment9.persistance.daos

import androidx.room.*
import io.github.aungkothet.padc.assignment9.data.vos.PlantVo

@Dao
abstract class PlantDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insetPlants(plants: List<PlantVo>): LongArray

    @Query("SELECT * FROM plant")
    abstract fun getAllPlants(): List<PlantVo>

    @Query("SELECT * FROM plant WHERE plant_id=:id")
    abstract fun getPlantById(id: String): PlantVo

}