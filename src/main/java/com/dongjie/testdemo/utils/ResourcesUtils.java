package com.dongjie.testdemo.utils;

import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;
import com.dongjie.testdemo.MyApplication;

public class ResourcesUtils {

  public static int getColor(@ColorRes int colorId) {
    return ContextCompat.getColor(MyApplication.mApplicationContext, colorId);
  }

  public static Drawable getDrawable(@DrawableRes int drawableId) {
    return ContextCompat.getDrawable(MyApplication.mApplicationContext, drawableId);
  }

}
