package io.github.aungkothet.padc.assignment9.persistance.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import io.github.aungkothet.padc.assignment9.data.vos.UserVo

@Dao
abstract class UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun setLoginUser(events: List<UserVo>): LongArray

    @Query("SELECT * FROM user")
    abstract fun getLoginUser(): LiveData<List<UserVo>>

    @Query("SELECT * FROM user WHERE user_id=:id")
    abstract fun getUserById(id: String): UserVo

    @Delete
    abstract fun logout(userVo: UserVo)
}