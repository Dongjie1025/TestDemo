package com.dongjie.testdemo.utils;

import android.content.Context;
import com.dongjie.testdemo.MyApplication;

public class DipUtils {

  public static int px2dip(float pxValue) { // NO_UCD (unused code)
    final float scale = MyApplication.mApplicationContext.getResources()
        .getDisplayMetrics().density;
    return (int) (pxValue / scale + 0.5f);
  }
}
