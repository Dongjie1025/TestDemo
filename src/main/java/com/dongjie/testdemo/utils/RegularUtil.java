package com.dongjie.testdemo.utils;

import java.util.regex.Pattern;

/**
 * 常用正则表达式工具类
 */
public class RegularUtil {

  /**
   * 判断整数（int）
   */
  public static boolean isInteger(String str) {
    if (null == str || "".equals(str)) {
      return false;
    }
    Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
    return pattern.matcher(str).matches();
  }

  /**
   * 判断浮点数（double和float）
   */
  public static boolean isDouble(String str) {
    if (null == str || "".equals(str)) {
      return false;
    }
    Pattern pattern = Pattern.compile("^[-\\+]?\\d*[.]\\d+$");
    return pattern.matcher(str).matches();
  }
}
