package com.example.navigationdemo

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Telephony
import android.view.View
import android.widget.Button
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity(), View.OnClickListener{
    private val NOTIFICATION_ID = 888
    private lateinit var  mNotificationManagerCompat :NotificationManagerCompat
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mNotificationManagerCompat = NotificationManagerCompat.from(this@MainActivity)
        val btnInboxStyleNotification = findViewById<Button>(R.id.btn_inbox_style)
        btnInboxStyleNotification.setOnClickListener(this@MainActivity)
        val btnBigImageStyleNotification = findViewById<Button>(R.id.btn_big_image_style)
        btnBigImageStyleNotification.setOnClickListener(this@MainActivity)

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_inbox_style->
            {
                    generateInboxStyleNotification()
                return
            }
            R.id.btn_big_image_style->{
                generateBigPictureStyleNotification()
                return
            }
        }
    }
    private fun generateBigPictureStyleNotification(){
        val notificationChannelId:String = NotificationUtil()
                .createBigPictureStyleNotificationChannel(this)
        val bigPictureStyle = NotificationCompat.BigPictureStyle()
        bigPictureStyle.bigPicture(
                BitmapFactory.decodeResource(resources,
                BigPictureStyleMockData.mBigImage)
        )
                .setBigContentTitle(BigPictureStyleMockData.mBigContentTitle)
                .setSummaryText(BigPictureStyleMockData.mSummaryText)
        val mainIntent  =Intent(this, MainActivity::class.java )
        val mainPendingIntent = PendingIntent.getActivity(
                this,
                0,
                mainIntent,
                PendingIntent.FLAG_UPDATE_CURRENT
        )
        val notificationCompatBuilder = NotificationCompat.Builder(
                applicationContext
        ,
                notificationChannelId
        )
        notificationCompatBuilder
                .setStyle(bigPictureStyle)
                .setContentTitle(BigPictureStyleMockData.mBigContentTitle)
                .setContentText(BigPictureStyleMockData.mContentText)
                .setSmallIcon(R.drawable.ic_start_notification)
                .setLargeIcon(
                        BitmapFactory.decodeResource(
                                resources,
                                R.drawable.ic_person
                        )
                )
                .setSubText(1.toString())
                .setCategory(Notification.CATEGORY_SOCIAL)
                .setPriority(BigPictureStyleMockData.mPriority)
                .setVisibility(BigPictureStyleMockData.mLockedScreenVisibility)
                .setContentIntent(mainPendingIntent)
                for(name in BigPictureStyleMockData.mParticipant()){
                    @Suppress("DEPRECATION")
                    notificationCompatBuilder.addPerson(name)
                }
        val notification = notificationCompatBuilder.build()
        mNotificationManagerCompat.notify(NOTIFICATION_ID, notification)



    }

    private fun generateInboxStyleNotification(){
            val notificationChannelId:String =
                    NotificationUtil().createInboxNotificationChannel(this)
        val inboxStyle = NotificationCompat.InboxStyle()
                .setBigContentTitle(InboxStyleMockData.mBigContentTitle)
                .setSummaryText(InboxStyleMockData.mSummaryText)
        for(summary in InboxStyleMockData.mIndividualEmailSummary()){
            inboxStyle.addLine(summary)
        }
        val mainIntent = Intent(this, MainActivity::class.java)
        val mainPendingIntent = PendingIntent.getActivity(this
        ,0,
         mainIntent,
        PendingIntent.FLAG_UPDATE_CURRENT)

        val notificationCompatBuilder = NotificationCompat.Builder(
                applicationContext,
                notificationChannelId
        )

        notificationCompatBuilder.setStyle(inboxStyle)
                .setContentTitle(InboxStyleMockData.mContentTitle)
                .setContentText(InboxStyleMockData.mContentText)
                .setSmallIcon(R.drawable.ic_start_notification)
                .setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.ic_person))
                .setContentIntent(mainPendingIntent)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setColor(ContextCompat.getColor(
                        applicationContext, R.color.purple_500
                ))
                .setSubText(InboxStyleMockData.mNumberOfMail.toString())
                .setCategory(Notification.CATEGORY_EMAIL)
                .setPriority(InboxStyleMockData.mPriority)
                .setVisibility(InboxStyleMockData.mLockedScreenVisibility)
        for(name in InboxStyleMockData.mParticipants()){
            @Suppress("DEPRECATION")
            notificationCompatBuilder.addPerson(name)
        }
        val notification = notificationCompatBuilder.build()
        mNotificationManagerCompat.notify(NOTIFICATION_ID, notification)
    }
}