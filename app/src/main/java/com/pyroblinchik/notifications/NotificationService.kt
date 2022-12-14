package com.pyroblinchik.notifications

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import androidx.core.app.NotificationCompat
import com.pyroblinchik.notifications.MainActivity.Companion.DOWNLOAD_TYPE
import com.pyroblinchik.notifications.MainActivity.Companion.IMAGE_TYPE
import com.pyroblinchik.notifications.MainActivity.Companion.LONG_TYPE
import com.pyroblinchik.notifications.MainActivity.Companion.SIMPLE_TYPE


class NotificationService(
    private val context: Context
) {
    private val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    fun showNotification(notificationType: String) {
        val activityIntent = Intent(context, MainActivity::class.java)
        val activityPendingIntent = PendingIntent.getActivity(
            context,
            1,
            activityIntent,
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) PendingIntent.FLAG_IMMUTABLE else 0
        )
        val incrementIntent = PendingIntent.getBroadcast(
            context,
            2,
            Intent(context, NotificationReceiver::class.java),
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) PendingIntent.FLAG_IMMUTABLE else 0
        )
        when(notificationType){
            SIMPLE_TYPE ->{
                val notification = NotificationCompat.Builder(context, COUNTER_CHANNEL_ID)
                    .setSmallIcon(R.drawable.ic_baseline_agriculture_24)
                    .setContentTitle("Header")
                    .setContentText("Content")
                    .setColor(Color.CYAN)
                    .setContentIntent(activityPendingIntent)
                    .addAction(
                        R.drawable.ic_baseline_agriculture_24,
                        "Button",
                        incrementIntent
                    )
                    .build()

                notificationManager.notify(1, notification)
            }
//            REPLY_TYPE ->{
//                val remoteInput = RemoteInput.getResultsFromIntent(intent)
//                if (remoteInput != null) {
//                    val input = "input"
//                    val person = "Me"
//                    val message = NotificationCompat.MessagingStyle.Message(
//                        input, System.currentTimeMillis(), person
//                    )
//                    val notification = NotificationCompat.Builder(context, COUNTER_CHANNEL_ID)
//                        .setContentTitle("Sent!")
//                        .setStyle(null)
//                        .build()
//                    notificationManager.notify(
//                        2,
//                        notification
//                    )
//                }
//                notificationManager.notify(1, notification)
//            }
            LONG_TYPE ->{
                val bm = BitmapFactory.decodeResource(context.resources, R.drawable.image)
                val notification = NotificationCompat.Builder(context, COUNTER_CHANNEL_ID)
                    .setSmallIcon(R.drawable.ic_baseline_agriculture_24)
                    .setContentTitle("Header")
                    .setContentText("Content")
                    .setContentIntent(activityPendingIntent)
                    .setLargeIcon(bm)
                    .setStyle(NotificationCompat.BigTextStyle()
                        .bigText("TextTextTextTextTextTextTextTextTextTextTextTextTextTextTextText" +
                                "TextTextTextTextTextTextTextTextTextTextTextTextTextTextTextText" +
                                "TextTextTextTextTextTextTextTextTextTextTextTextTextTextTextText" +
                                "TextTextTextTextTextTextTextTextTextTextTextTextTextTextTextText" +
                                "TextTextTextTextTextTextTextTextTextTextTextTextTextText" +
                                "TextTextTextTextTextTextTextText"))

                    .build()

                notificationManager.notify(1, notification)
            }
            DOWNLOAD_TYPE ->{
//                val notification = NotificationCompat.Builder(context, COUNTER_CHANNEL_ID)
//                    .setSmallIcon(R.drawable.ic_baseline_agriculture_24)
//                    .setContentTitle("Increment counter")
//                    .setContentText("The count is $counter")
//                    .setContentIntent(activityPendingIntent)
//                    .addAction(
//                        R.drawable.ic_baseline_agriculture_24,
//                        "Increment",
//                        incrementIntent
//                    )
//                    .build()
//
//                notificationManager.notify(1, notification)
            }
            IMAGE_TYPE ->{
                val bm = BitmapFactory.decodeResource(context.resources, R.drawable.image)
                val notification = NotificationCompat.Builder(context, COUNTER_CHANNEL_ID)
                    .setSmallIcon(R.drawable.ic_baseline_agriculture_24)
                    .setContentTitle("Title")
                    .setContentText("Content")
                    .setLargeIcon(bm)
                    .setStyle(NotificationCompat.BigPictureStyle()
                        .bigPicture(bm)
                        .bigLargeIcon(null))
                    .build()


                notificationManager.notify(1, notification)
            }
            else -> {

            }
        }
    }

    companion object {
        const val COUNTER_CHANNEL_ID = "counter_channel"
    }
}