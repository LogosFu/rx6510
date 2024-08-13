package com.logos.rx6510

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.Intent.ACTION_BOOT_COMPLETED

class BootBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        if (intent?.action.equals(ACTION_BOOT_COMPLETED)) {
            val bootStartIntent = Intent(context, MainActivity::class.java)
            bootStartIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context?.startActivity(bootStartIntent)
        }
    }
}