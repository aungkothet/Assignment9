package io.github.aungkothet.padc.assignment9.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "user")
data class UserVo(

    @PrimaryKey
    @SerializedName("user_id")
    @ColumnInfo(name = "user_id")
    val userId: String,

    @SerializedName("user_name")
    @ColumnInfo(name = "user_name")
    val userName: String,

    @SerializedName("user_photo_url")
    @ColumnInfo(name = "user_photo_url")
    val userPhotoUrl: String,

    @SerializedName("member_since")
    @ColumnInfo(name = "member_since")
    val memberSince: String,

    @SerializedName("member_rank")
    @ColumnInfo(name = "member_rank")
    val memberRank: String
){

}