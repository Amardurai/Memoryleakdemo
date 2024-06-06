package com.example.memoryleakdemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.compose.runtime.MutableState

class MemoryLeakReceiver(val text: MutableState<String>) : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        when (intent?.action) {
            Intent.ACTION_POWER_CONNECTED -> {
                text.value = "Power Connected"
            }
            Intent.ACTION_POWER_DISCONNECTED -> {
                text.value = "Power Disconnected"
            }
        }
    }
}
