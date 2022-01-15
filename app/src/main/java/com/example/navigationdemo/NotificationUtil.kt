package com.example.navigationdemo

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.provider.Telephony

class NotificationUtil {
    fun createInboxNotificationChannel(context: Context):String{
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
        {
                val channelId:String = InboxStyleMockData.mChannelId
                val channelName:CharSequence = InboxStyleMockData.mChannelName
                val channelDescription:String = InboxStyleMockData.mChannelDescription
                val channelImportance:Int = InboxStyleMockData.mChannelImportant
                val channelVibration:Boolean = InboxStyleMockData.mChannelEnableVibration
                val channelLockScreenVisibility = InboxStyleMockData.mLockedScreenVisibility

                //Notification Channel
                val notificationChannel = NotificationChannel(channelId, channelName, channelImportance)
                notificationChannel.description = channelDescription
                notificationChannel.enableVibration(channelVibration)
                notificationChannel.lockscreenVisibility =channelLockScreenVisibility

            //notificationManager
            val notificationManager =
                    context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(notificationChannel)

            return channelId
        }
        else{
            return " "
        }
    }

    fun createBigPictureStyleNotificationChannel(context: Context):String{
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
        {
            val channelId:String = BigPictureStyleMockData.mChannelId
            val channelName:CharSequence = BigPictureStyleMockData.mChannelName
            val channelDescription:String = BigPictureStyleMockData.mChannelDescription
            val channelImportance:Int =BigPictureStyleMockData.mChannelImportant
            val channelVibration:Boolean = BigPictureStyleMockData.mChannelEnableVibration
            val channelLockScreenVisibility = BigPictureStyleMockData.mLockedScreenVisibility

            //Notification Channel
            val notificationChannel = NotificationChannel(channelId, channelName, channelImportance)
            notificationChannel.description = channelDescription
            notificationChannel.enableVibration(channelVibration)
            notificationChannel.lockscreenVisibility =channelLockScreenVisibility

            //notificationManager
            val notificationManager =
                    context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(notificationChannel)

            return channelId
        }
        else{
            return " "
        }
    }
}