package com.dongjie.testdemo.test;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class TestHandlerThread {

  private String TAG = TestHandlerThread.class.getSimpleName();
  private static final int LOOPER_TIME = 3000;

  private HashMap<Integer, Disposable> map = new HashMap<>();

  private static TestHandlerThread mInstance;

  public static TestHandlerThread getInstance() {
    if (mInstance == null) {
      synchronized (TestHandlerThread.class) {
        if (mInstance == null) {
          mInstance = new TestHandlerThread();
        }
      }
    }
    return mInstance;
  }

  private TestHandlerThread() {
  }

  public void startLooper(final int id, final String message) {
    Disposable disposable = Observable.interval(0, LOOPER_TIME, TimeUnit.MILLISECONDS)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<Long>() {
          @Override
          public void accept(Long aLong) throws Exception {
            Log.e(TAG, "id ->> " + id + "  message ->> " + message);
          }
        });
    map.put(id, disposable);
  }

  public void stopLooper(final int id) {
    Disposable disposable = map.get(id);
    if (disposable != null) {
      disposable.dispose();
    }
  }


}
