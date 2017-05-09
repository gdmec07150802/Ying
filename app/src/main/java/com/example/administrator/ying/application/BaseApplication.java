package com.example.administrator.ying.application;

import android.app.Application;

import com.example.administrator.ying.utils.StaticClass;
import com.tencent.bugly.crashreport.CrashReport;

import cn.bmob.v3.Bmob;

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化Bugly
        CrashReport.initCrashReport(getApplicationContext(), StaticClass.BUGLY_APP_ID, true);

        //初始化BMob
        Bmob.initialize(this,StaticClass.BMOB_APP_ID);
    }
}
