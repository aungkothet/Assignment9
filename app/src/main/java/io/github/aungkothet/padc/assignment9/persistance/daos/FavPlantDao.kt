package io.github.aungkothet.padc.assignment9.persistance.daos

import androidx.room.*
import io.github.aungkothet.padc.assignment9.data.vos.FavPlantsVo
import io.github.aungkothet.padc.assignment9.data.vos.PlantVo

@Dao
abstract class FavPlantDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insetFavPlant(favPlantsVo: FavPlantsVo)

    @Query("SELECT plant.* FROM plant INNER JOIN fav_plants WHERE fav_plant_id == plant_id")
    abstract fun getFavPlantList(): List<PlantVo>

    @Query("SELECT * FROM fav_plants WHERE fav_plant_id=:plantId")
    abstract fun getFavPlantByPlantId(plantId:String): FavPlantsVo

    @Delete
    abstract fun removeFavPlant(favPlantsVo: FavPlantsVo)


}