package com.example.task.incoming.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [IncomingCall::class], version = 1, exportSchema = false)
abstract class RoomSingleton : RoomDatabase() {
    abstract fun incomingCallDao(): IncomingCallDao

    companion object {
        private var INSTANCE: RoomSingleton? = null
        fun getInstance(context: Context): RoomSingleton {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    RoomSingleton::class.java,
                    "appDB"
                )
                    .build()
            }

            return INSTANCE as RoomSingleton
        }
    }
}
