package com.example.task.incoming.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [IncomingCall::class], version = 1, exportSchema = false)
abstract class IncomingCallDatabase : RoomDatabase() {
    abstract fun incomingCallDao(): IncomingCallDao
}
