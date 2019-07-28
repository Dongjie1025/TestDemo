package com.dongjie.testdemo.custom.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.FontMetricsInt;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ReplacementSpan;
import android.util.Log;

public class RelativeVerticalSpan extends ReplacementSpan {

  private int textSize;
  private int textColor;

  public RelativeVerticalSpan(int textSize, int textColor) {
    this.textSize = textSize;
    this.textColor = textColor;
  }

  public RelativeVerticalSpan(int textSize) {
    this.textSize = textSize;
  }

  @Override
  public int getSize(@NonNull Paint paint, CharSequence text, int start,
      int end, @NonNull Paint.FontMetricsInt fm) {
    text = text.subSequence(start, end);
    Paint p = getCustomTextPaint(paint);
    return (int) p.measureText(text.toString());
  }

  @Override
  public void draw(@NonNull Canvas canvas, CharSequence text, int start,
      int end, float x, int top, int y, int bottom, @NonNull Paint paint) {
    text = text.subSequence(start, end);
    Paint p = getCustomTextPaint(paint);
    FontMetricsInt fm = p.getFontMetricsInt();
    if (text.toString().contains(".") || TextUtils.isDigitsOnly(text)) {
      canvas.drawText(text.toString(), x, y + 8, p);
    } else {
      canvas.drawText(text.toString(), x, y, p);
    }
    Log.e("RelativeVerticalSpan", "text --->" + text.toString() + " y --->" + y + " fm --->" + fm.toString());
  }

  private TextPaint getCustomTextPaint(Paint srcPaint) {
    TextPaint paint = new TextPaint(srcPaint);
    paint.setTextSize(textSize);   //设定字体大小, sp转换为px
    paint.setColor(textColor);   //设定字体大小, sp转换为px
    return paint;
  }
}
