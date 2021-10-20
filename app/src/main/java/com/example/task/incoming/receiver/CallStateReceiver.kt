package com.example.task.incoming.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.PhoneStateListener
import android.telephony.TelephonyManager
import com.example.task.incoming.data.RoomSingleton
import java.util.*
import kotlin.concurrent.thread

class CallStateReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val dao = RoomSingleton.getInstance(context).incomingCallDao()

        if (intent.action != "android.intent.action.PHONE_STATE") return
        val telephony = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        telephony.listen(object : PhoneStateListener() {
            override fun onCallStateChanged(state: Int, incomingNumber: String) {
                super.onCallStateChanged(state, incomingNumber)
                if (state == TelephonyManager.CALL_STATE_RINGING) {
                    thread { dao.insert(incomingNumber, Date().toString()) }
                }
            }
        }, PhoneStateListener.LISTEN_CALL_STATE)
    }
}