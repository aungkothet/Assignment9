package io.github.aungkothet.padc.assignment9.persistance

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import io.github.aungkothet.padc.assignment9.data.vos.FavPlantsVo
import io.github.aungkothet.padc.assignment9.data.vos.PlantVo
import io.github.aungkothet.padc.assignment9.data.vos.UserVo
import io.github.aungkothet.padc.assignment9.persistance.daos.FavPlantDao
import io.github.aungkothet.padc.assignment9.persistance.daos.PlantDao
import io.github.aungkothet.padc.assignment9.persistance.daos.UserDao
import io.github.aungkothet.padc.assignment9.persistance.typeconverters.PlantTypeConverter
import io.github.aungkothet.padc.assignment9.utils.DB_NAME

@Database(entities = [PlantVo::class,UserVo::class,FavPlantsVo::class], version = 4, exportSchema = false)
@TypeConverters(PlantTypeConverter::class)
abstract class PlantDataBase : RoomDatabase() {

    abstract fun plantDao(): PlantDao
    abstract fun userDao(): UserDao
    abstract fun favPlantDao(): FavPlantDao

    companion object {
        private var plantDataBase: PlantDataBase? = null
        fun getInstance(context: Context): PlantDataBase {
            if (plantDataBase == null) {
                plantDataBase = Room.databaseBuilder(context, PlantDataBase::class.java, DB_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration().build()
            }
            return plantDataBase!!
        }
    }

}