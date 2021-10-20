package com.example.task.incoming.data

import android.content.Context
import androidx.room.Room

class DatabaseUtil(context: Context) {
    val dao =
        Room.databaseBuilder(
            context, IncomingCallDatabase::class.java, "incoming-calls"
        ).build().incomingCallDao()
}
