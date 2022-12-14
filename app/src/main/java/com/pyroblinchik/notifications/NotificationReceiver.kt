package com.pyroblinchik.notifications

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.pyroblinchik.notifications.MainActivity.Companion.notificationType

class NotificationReceiver: BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent?) {
        val service = NotificationService(context)
        service.showNotification(notificationType)
    }
}