package com.example.navigationdemo

import android.app.Notification
import android.app.NotificationManager
import androidx.core.app.NotificationCompat

object BigPictureStyleMockData {
    const val mContentTitle = "Bobs Post"
    const val mContentText  ="[Picture] like my shot of the earth?"
    const val mPriority = NotificationCompat.PRIORITY_HIGH
    const val mBigImage = R.drawable.earth
    const val mBigContentTitle = "Bobs Post"
    const val mSummaryText = "like my shot of the earth"

    fun mParticipant():ArrayList<String>{
        val list = ArrayList<String>()
        list.add("Bob Smith")
        return list
    }

    const val mChannelId = "channel_social_1"
    const val  mChannelName = "Sample channel"
    const val mChannelDescription = "Sample social Notification"
    const val mChannelImportant = NotificationManager.IMPORTANCE_HIGH
    const val mChannelEnableVibration = true
    const val mLockedScreenVisibility = NotificationCompat.VISIBILITY_PRIVATE

}