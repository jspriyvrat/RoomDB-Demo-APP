package com.example.livedatasample

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters



@Database(entities = [Contact::class],version = 1)
@TypeConverters(Convertors::class)
abstract class ContactDataBase : RoomDatabase() {

    abstract fun contactDao(): ContactDao


    companion object {
        @Volatile
        private var INSTANCE: ContactDataBase? = null


        fun getDataBase(context: Context): ContactDataBase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        ContactDataBase::class.java,
                        "MyData"
                    ).build()
                }

            }
            return INSTANCE!!
        }
    }

}