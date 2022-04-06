package com.wildcardev.roommate_utilities.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.wildcardev.roommate_utilities.model.db.dao.RoommateDao
import com.wildcardev.roommate_utilities.model.db.entities.RoommateEntity

@Database(entities = [RoommateEntity::class],version = 1, exportSchema = false)
abstract class RoommmateDatabase: RoomDatabase(){
    abstract fun roommateDao(): RoommateDao

    companion object{

        @Volatile private var instance: RoommmateDatabase? = null

        fun getInstance(context: Context): RoommmateDatabase{
            return instance ?: synchronized(this){
                instance ?: buildDatabase(context).also{ instance = it }
            }
        }

        private fun buildDatabase(context: Context): RoommmateDatabase{
            return Room.databaseBuilder(context,
            RoommmateDatabase::class.java,
                "RoommateUtil")
                .build()
        }
    }
}