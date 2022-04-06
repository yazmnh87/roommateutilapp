package com.wildcardev.roommate_utilities.model.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "roommates")
data class RoommateEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val phone_number: String,
    val photo_uri: String
)