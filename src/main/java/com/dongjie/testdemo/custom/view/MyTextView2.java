//package com.dongjie.testdemo.custom;
//
//import android.content.Context;
//import android.graphics.Color;
//import android.graphics.Paint;
//import android.util.AttributeSet;
//
//public class MyTextView2 {
//  //数值的画笔
//  private Paint valuePaint;
//
//  //单位的画笔
//  private Paint unitPaint;
//
//  private int valueColor = Color.BLACK;
//
//  private int unitColor = Color.BLACK;
//
//  private float valueTextSize = 30;
//
//  private float unitTextSize = 24;
//
//  //数值和单位之间的padding
//  private float space = 0;
//
//  /**
//   * 类型
//   * 0：下方未超出baseline
//   * 1：下方超出baseline
//   */
//  private int type;
//
//  private String value;
//
//  private String unit;
//
//  //数值对应baseline的y值
//  private float valueDrawY;
//
//  private Paint.FontMetrics valueMetrics;
//
//  private Paint.FontMetrics unitMetrics;
//
//  public AlignmentView(Context context) {
//    this(context, null, 0);
//  }
//
//  public AlignmentView(Context context, AttributeSet attrs) {
//    this(context, attrs, 0);
//  }
//
//  public AlignmentView(Context context, AttributeSet attrs, int defStyleAttr) {
//    super(context, attrs, defStyleAttr);
//    init(context, attrs, defStyleAttr);
//  }
//
//  private void init(Context context, AttributeSet attrs, int defStyleAttr) {
//
//    if (attrs == null) {
//      return;
//    }
//
//    TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.AlignmentView, defStyleAttr, 0);
//    value = array.getString(R.styleable.AlignmentView_value);
//    unit = array.getString(R.styleable.AlignmentView_unit);
//    space = array.getDimension(R.styleable.AlignmentView_space, 0);
//    unitColor = array.getColor(R.styleable.AlignmentView_unitColor, Color.BLACK);
//    valueColor = array.getColor(R.styleable.AlignmentView_valueColor, Color.BLACK);
//    valueTextSize = array.getDimension(R.styleable.AlignmentView_valueSize, 30);
//    unitTextSize = array.getDimension(R.styleable.AlignmentView_unitSize, 24);
//    type = array.getInt(R.styleable.AlignmentView_type, 0);
//
//    if (TextUtils.isEmpty(value)) {
//      value = "数值";
//    }
//
//    if (TextUtils.isEmpty(unit)) {
//      unit = "单位";
//    }
//
//    valuePaint = new Paint();
//    valuePaint.setAntiAlias(true);
//    valuePaint.setTextSize(valueTextSize);
//    valuePaint.setColor(valueColor);
//    valuePaint.setTextAlign(Paint.Align.LEFT);
//
//    unitPaint = new Paint();
//    unitPaint.setAntiAlias(true);
//    unitPaint.setTextSize(unitTextSize);
//    unitPaint.setColor(unitColor);
//    unitPaint.setTextAlign(Paint.Align.LEFT);
//
//    array.recycle();
//  }
//
//  @Override
//  protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//    valueMetrics = valuePaint.getFontMetrics();
//    unitMetrics = unitPaint.getFontMetrics();
//
//    //获取文字的宽高
//    float valueH = valueMetrics.descent - valueMetrics.ascent;
//    float valueW = valuePaint.measureText(value);
//    float unitH = unitMetrics.descent - unitMetrics.ascent;
//    float unitW = unitPaint.measureText(unit);
//
//    int realH = (int) (Math.max(valueH, unitH) + getPaddingBottom() + getPaddingTop());
//    int realW = (int) (valueW + unitW + getPaddingLeft() + getPaddingRight() + space);
//
//    int width = measureSize(realW, widthMeasureSpec);
//    int height = measureSize(realH, heightMeasureSpec);
//    setMeasuredDimension(width, height);
//  }
//
//  private int measureSize(int defaultSize, int measureSpec) {
//    int resultSize = defaultSize;
//    int mode = MeasureSpec.getMode(measureSpec);
//    int size = MeasureSpec.getSize(measureSpec);
//
//    switch (mode) {
//      case MeasureSpec.AT_MOST:
//      case MeasureSpec.UNSPECIFIED:
//        break;
//      case MeasureSpec.EXACTLY:
//        resultSize = size;
//        break;
//    }
//    return resultSize;
//  }
//
//  @Override
//  protected void onDraw(Canvas canvas) {
//    super.onDraw(canvas);
//    drawValue(canvas);
//    drawUnit(canvas);
//    canvas.drawLine(getPaddingLeft(), valueDrawY, getWidth(), valueDrawY, unitPaint);
//  }
//
//  //    画左侧的数值
//  private void drawValue(Canvas canvas) {
//    //y值的计算，向下偏移
//    valueDrawY = getHeight() / 2 + (Math.abs(valueMetrics.ascent) - valueMetrics.descent) / 2;
//    canvas.drawText(value, getPaddingLeft(), valueDrawY, valuePaint);
//  }
//
//  //    画右侧的单位
//  private void drawUnit(Canvas canvas) {
//    float valueWidth = valuePaint.measureText(value);
//    float x = getPaddingLeft() + valueWidth + space;
//    float y = valueDrawY;
//    if (type == 1) {
////            当底部超出baseline的时候，应该向上偏移单位对应的descent值
//      y = valueDrawY - unitMetrics.descent;
//    }
//    canvas.drawText(unit, x, y, unitPaint);
//  }
//
//  //    向外部提供设置值的方法
//  public void setValue(String value) {
//    this.value = value;
//    invalidate();
//  }
//
//  public void setUnit(String unit) {
//    this.unit = unit;
//    invalidate();
//  }
//}
