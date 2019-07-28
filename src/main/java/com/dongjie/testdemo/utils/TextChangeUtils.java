package com.dongjie.testdemo.utils;

import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.text.SpannableString;
import com.dongjie.testdemo.custom.span.RelativeVerticalSpan;

public class TextChangeUtils {

  public static SpannableString textChange(String content, String[] changeTxs, int[] colors,
      int[] sizes) {
    SpannableString sbString = new SpannableString(content);
    for (int i = 0; i < changeTxs.length; i++) {
      String tx = changeTxs[i];
      if (!content.contains(tx)) {
        continue;
      }
      int startIndex = content.indexOf(tx);
      int endIndex = startIndex + tx.length();
      RelativeVerticalSpan mSpan = new RelativeVerticalSpan(sizes[i],ResourcesUtils.getColor(colors[i]));
      sbString.setSpan(mSpan, startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    }

    return sbString;
  }

  public static SpannableString textChange(String content, String changeTx, int color,
      int size) {
    SpannableString sbString = new SpannableString(content);
    if (!content.contains(changeTx)) {
      return sbString;
    }
    int startIndex = content.indexOf(changeTx);
    int endIndex = startIndex + changeTx.length();
    RelativeVerticalSpan mSpan = new RelativeVerticalSpan(size,ResourcesUtils.getColor(color));
    sbString.setSpan(mSpan, startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    return sbString;
}



  /**
   * 半角字符转全角字符
   */
  public static String halfToFull(String str) {
    char[] chars = str.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] == 12288) {// 半角空格转全角空格
        chars[i] = 32;
        continue;
      }
      if (chars[i] == 46) {// 半角点号不转
        continue;
      }
//      if (chars[i] > 33 && chars[i] < 127) {// 半角符号转全角符号
//        chars[i] += 65248;
//      }w
    }
    return new String(chars);
  }
}
