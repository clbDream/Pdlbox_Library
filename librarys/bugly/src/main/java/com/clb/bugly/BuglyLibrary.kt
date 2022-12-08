package com.clb.bugly

import android.app.Application
import com.tencent.bugly.crashreport.CrashReport

object BuglyLibrary {

    fun init(application: Application) {
        //初始化Bugly
        CrashReport.initCrashReport(application, "6dbea536a8", false)
    }
}