package io.github.aungkothet.padc.assignment9.data.vos

import androidx.room.*

@Entity(
    tableName = "fav_plants",
    foreignKeys = [
        ForeignKey(
            entity = PlantVo::class,
            parentColumns = ["plant_id"],
            childColumns = ["fav_plant_id"],
            onDelete = ForeignKey.NO_ACTION
        )
    ],
    indices = [
        Index(value = ["fav_plant_id"], unique = true)]
)
data class FavPlantsVo(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "fav_id")
    val id: Int,

    @ColumnInfo(name = "fav_plant_id")
    val plantId: String
)