package com.wildcardev.roommate_utilities.model.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.wildcardev.roommate_utilities.model.models.Contact

@Dao
interface RoommateDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addRoommate(roommate: Contact)

}