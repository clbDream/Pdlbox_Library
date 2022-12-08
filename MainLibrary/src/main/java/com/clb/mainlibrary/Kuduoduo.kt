package com.clb.mainlibrary

import android.app.Application
import com.clb.bugly.BuglyLibrary

/**
 * 库多多入口类
 */
object Kuduoduo {

    fun init(application: Application){
        //初始化Bugly
        BuglyLibrary.init(application)
    }
}