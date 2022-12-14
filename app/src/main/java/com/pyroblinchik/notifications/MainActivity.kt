package com.pyroblinchik.notifications

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pyroblinchik.notifications.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val service = NotificationService(applicationContext)
        binding.buttonSimpleNotification.setOnClickListener {
            notificationType = SIMPLE_TYPE
            service.showNotification(notificationType)
        }

        binding.buttonLongNotification.setOnClickListener {
            notificationType = LONG_TYPE
            service.showNotification(notificationType)
        }

        binding.buttonDownloadNotification.setOnClickListener {
            notificationType = DOWNLOAD_TYPE
            service.showNotification(notificationType)
        }

        binding.buttonImageNotification.setOnClickListener {
            notificationType = IMAGE_TYPE
            service.showNotification(notificationType)
        }
        binding.buttonReplyNotification.setOnClickListener {
            notificationType = REPLY_TYPE
            service.showNotification(notificationType)
        }
    }

    private fun setupClickListeners() {

    }

    companion object{
        const val EMPTY_TYPE = "empty"
        const val SIMPLE_TYPE = "simple"
        const val LONG_TYPE = "long"
        const val DOWNLOAD_TYPE = "download"
        const val IMAGE_TYPE = "image"
        const val REPLY_TYPE = "reply"

        var notificationType = EMPTY_TYPE
    }
}