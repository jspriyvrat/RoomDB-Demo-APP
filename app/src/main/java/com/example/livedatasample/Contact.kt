package com.example.livedatasample

import androidx.room.Entity
import androidx.room.PrimaryKey



@Entity(tableName = "contacts")
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val id:Long,
    val name:String,
    val email:String,

)
