package com.example.task.incoming.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

@Dao
interface IncomingCallDao {
    @Query("SELECT * FROM incomingCalls")
    fun getAll(): LiveData<List<IncomingCall>>

    @Query("INSERT INTO incomingCalls(phone_number, time_stamp) VALUES(:phoneNumber, :timeStamp)")
    fun insert(phoneNumber: String, timeStamp: String)

    @Query("SELECT COUNT(id) from incomingCalls")
    fun getCount(): LiveData<Int>
}