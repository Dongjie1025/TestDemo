package com.dongjie.testdemo;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.provider.Settings;
import com.dongjie.testdemo.common.Constant;
import com.dongjie.testdemo.utils.SystemUtil;

public class MyApplication extends Application {

  public static Context mApplicationContext;// 全局Context
  public static Resources mApplicationResources;// 全局资源管理器

  @Override
  public void onCreate() {
    super.onCreate();
    initNotification();
    mApplicationContext = getApplicationContext();
    mApplicationResources = getApplicationContext().getResources();
  }

  /**
   * 初始化通知栏渠道
   */
  private void initNotification() {
    if (VERSION.SDK_INT >= VERSION_CODES.O) {
      NotificationManager manager = SystemUtil.getNotificationManager(this);
//      if (manager.getNotificationChannel(Constant.NOTIFICATION_CHANNEL_ID).getImportance()
//          == NotificationManager.IMPORTANCE_NONE) {
//        Intent intent = new Intent(Settings.ACTION_CHANNEL_NOTIFICATION_SETTINGS);
//        intent.putExtra(Settings.EXTRA_CHANNEL_ID, Constant.NOTIFICATION_CHANNEL_ID);
//        intent.putExtra(Settings.EXTRA_APP_PACKAGE, getPackageName());
//        startActivity(intent);
//        return;
//      }
      NotificationChannel defaultChannel = new NotificationChannel(
          Constant.NOTIFICATION_CHANNEL_ID, Constant.NOTIFICATION_CHANNEL_DEFAULT_NAME,
          NotificationManager.IMPORTANCE_DEFAULT);
      defaultChannel.enableLights(true);
      defaultChannel.enableVibration(true);
      defaultChannel.setBypassDnd(true); //设置绕过免打扰模式
      defaultChannel.canBypassDnd();      //检测是否绕过免打扰模式
      defaultChannel.setLockscreenVisibility(Notification.VISIBILITY_SECRET);//设置在锁屏界面上显示这条通知
      defaultChannel.setLightColor(Color.GREEN);
      defaultChannel.setShowBadge(true);
      defaultChannel.enableVibration(true);
      SystemUtil.getNotificationManager(this).createNotificationChannel(defaultChannel);
    }
//    if (VERSION.SDK_INT > VERSION_CODES.O) {
//      Notification notification = new Notification.Builder(this, Constant.NOTIFICATION_CHANNEL_ID)
//          .setWhen(System.currentTimeMillis())
//          .setContentIntent(
//              PendingIntent.getActivity(this, 100, new Intent(), PendingIntent.FLAG_IMMUTABLE))
//          .setContentTitle("ss")
//          .setContentText("ss")
//          .setShowWhen(true)
//          .setOngoing(false)
//          .setSmallIcon(R.mipmap.ic_launcher)
//          .setChannelId(Constant.NOTIFICATION_CHANNEL_ID)
//          .setAutoCancel(true)
//          .build();
//    }
  }
}
