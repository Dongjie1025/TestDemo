package com.dongjie.testdemo.utils;

import android.app.NotificationManager;
import android.content.Context;

public class SystemUtil {

  /**
   * 获取通知栏管理器
   * @param context
   * @return
   */
  public static NotificationManager getNotificationManager(Context context) {
    return (NotificationManager) context
        .getSystemService(Context.NOTIFICATION_SERVICE);
  }

}
