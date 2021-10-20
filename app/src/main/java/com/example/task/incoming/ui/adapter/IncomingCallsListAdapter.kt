package com.example.task.incoming.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.task.incoming.R
import com.example.task.incoming.data.IncomingCall

class IncomingCallsListAdapter(private val incomingCalls: List<IncomingCall>) :
    RecyclerView.Adapter<IncomingCallsListAdapter.IncomingCallsViewHolder>() {

    class IncomingCallsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val phoneNumber: TextView = itemView.findViewById(R.id.phone_number)
        val timeStamp: TextView = itemView.findViewById(R.id.time_stamp)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IncomingCallsViewHolder {
        return IncomingCallsViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.incoming_call_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: IncomingCallsViewHolder, position: Int) {
        holder.phoneNumber.text = incomingCalls[position].phoneNumber
        holder.timeStamp.text = incomingCalls[position].timeStamp
    }

    override fun getItemCount(): Int {
        return incomingCalls.size
    }
}
