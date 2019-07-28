package com.dongjie.testdemo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.dongjie.testdemo.custom.view.MyTextView;
import com.dongjie.testdemo.test.TestHandlerThread;
import com.dongjie.testdemo.utils.DipUtils;
import com.dongjie.testdemo.utils.TextChangeUtils;

public class MainActivity extends AppCompatActivity implements OnClickListener {

  private Button mStartLooperBtn, mStopLooperBtn;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    mStartLooperBtn = findViewById(R.id.startLooper);
    mStopLooperBtn = findViewById(R.id.stopLooper);

    mStartLooperBtn.setOnClickListener(this);
    mStopLooperBtn.setOnClickListener(this);

//    SpannableString sbString = TextChangeUtils
//        .textChange(mStartLooperBtn.getText().toString(), new String[]{"90","米","a","g","j"},new int[]{R.color.text_color_red,R.color.text_color_red,R.color.text_color_red,R.color.text_color_red,R.color.text_color_red}, new int[]{70,70,70,70,70});
//    mStartLooperBtn.setText(sbString);
//    Log.e("dj","px --> dp :" + DipUtils.px2dip(8));
    SpannableString sb = TextChangeUtils.textChange(mStartLooperBtn.getText().toString(),"90",R.color.text_color_red,40);
    mStartLooperBtn.setText(sb);
  }

  @Override
  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.startLooper: {
        TestHandlerThread.getInstance().startLooper(1,"这是第一条消息");
        TestHandlerThread.getInstance().startLooper(2,"这是第二条消息");
        break;
      }
      case R.id.stopLooper: {
        TestHandlerThread.getInstance().stopLooper(2);
        break;
      }
    }
  }
}
