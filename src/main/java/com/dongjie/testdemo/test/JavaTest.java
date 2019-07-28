package com.dongjie.testdemo.test;

import android.util.Log;
import android.widget.DatePicker;
import com.dongjie.testdemo.utils.DipUtils;
import java.util.logging.Logger;

public class JavaTest {

  private static final String TAG = "JAVATEST";

  public static void main(String[] s) {
//    dpiToDp(1920,1080,8);
    pxToDp(8);
  }

  private static void dpiToDp(int w, int h,int dp) {
    System.out.print("屏幕适配 dip ->>> dp :" + (Math.sqrt(w * w + h * h)) / 160 / 4);
  }

  private static void pxToDp(int px){
    System.out.print("px --->> dp :" + DipUtils.px2dip(px));
  }

}
