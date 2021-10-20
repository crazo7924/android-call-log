package com.example.task.incoming.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.task.incoming.data.IncomingCall
import com.example.task.incoming.data.RoomSingleton
import java.text.DateFormat.getDateInstance
import java.text.DateFormat.getTimeInstance
import java.util.*

class IncomingCallViewModel(application: Application) : AndroidViewModel(application) {
    private val db: RoomSingleton = RoomSingleton.getInstance(application)
    internal val incomingCalls: LiveData<List<IncomingCall>> = db.incomingCallDao().getAll()

    fun insert(phoneNumber: String, date: Date) {
        db.incomingCallDao().insert(phoneNumber, getTimeInstance().format(date))
    }
}