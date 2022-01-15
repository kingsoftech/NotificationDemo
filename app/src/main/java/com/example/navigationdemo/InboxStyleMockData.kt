package com.example.navigationdemo

import android.app.Notification
import android.app.NotificationManager
import androidx.core.app.NotificationCompat

object InboxStyleMockData {
    const val mContentTitle = "5 new emails"
    const val mContentText = "from Jane , jay, Alex +2 more"
    const val mNumberOfMail = 5
    const val mPriority = NotificationCompat.PRIORITY_DEFAULT
    const val mBigContentTitle = "5v new emails from jane, jay,Alex 2+more"
    const val mSummaryText = "New Emails"

    fun mIndividualEmailSummary():ArrayList<String>{
        val list = ArrayList<String>()
        list.add("jane Faab - Launch party is here")
        list.add("Jay Walker-   there's a turtle")
        list.add("Alex chang-   check this out")
        list.add("Jane johns-   check in code")
        list.add("john smith-   Movie later"  )
        return list
    }

    fun mParticipants():ArrayList<String>{
        val list = ArrayList<String>()
        list.add("jane Faab")
        list.add("Jay Walker")
        list.add("Alex chang")
        list.add("Jane johns")
        list.add("john smith")
        return list
    }
    //Notification channel values
    const val mChannelId = "channel_email_1"

    //the users visible name of the channel
    const val mChannelName = "Sample Email"


    const val mChannelDescription ="Sample Email Notifications"
    const val mChannelImportant = NotificationManager.IMPORTANCE_DEFAULT
    const val  mChannelEnableVibration = true
    const val  mLockedScreenVisibility = NotificationCompat.VISIBILITY_PRIVATE

}