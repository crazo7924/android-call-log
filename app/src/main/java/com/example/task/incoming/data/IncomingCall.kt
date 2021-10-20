package com.example.task.incoming.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "incomingCalls")
data class IncomingCall(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "phone_number") val phoneNumber: String,
    @ColumnInfo(name = "time_stamp") val timeStamp: String
)