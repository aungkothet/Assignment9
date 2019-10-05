package io.github.aungkothet.padc.assignment9.data.vos

import androidx.room.*
import com.google.gson.annotations.SerializedName

@Entity(tableName = "plant")
data class PlantVo(

    @PrimaryKey
    @SerializedName("plant_id")
    @ColumnInfo(name = "plant_id")
    val plantId: String,

    @SerializedName("plant_name")
    @ColumnInfo(name = "plant_name")
    val plantName: String,

    @SerializedName("plant_type")
    val plantType: List<String>,

    @SerializedName("description")
    @ColumnInfo(name = "description")
    val description: String,

    @SerializedName("top_tip")
    @ColumnInfo(name = "top_tip")
    val topTip: String,

    @SerializedName("tips")
    @Embedded(prefix = "tips_")
    val tips: TipsVo,

    @SerializedName("uploaded_user")
    @Embedded(prefix = "tips_")
    val uploadedUserVo: UploadedUserVo,

    @SerializedName("plant_photo")
    @ColumnInfo(name = "plant_photo")
    val plantPhoto: String
)