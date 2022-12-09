package com.clb.pdlbox_library

import android.app.Application
import com.clb.mainlibrary.Kuduoduo
import com.umeng.commonsdk.UMConfigure

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        //以下SDK根据你的实际需求调用,这里只是做演示使用
        Kuduoduo.Builder(this)
            //初始化Bugly
            .initBugly()
            //预初始化友盟(可在应用启动时调用)
            .preInitUmeng("渠道信息", BuildConfig.DEBUG)
            //初始化友盟(在同意隐私政策之后再调用)
            .initUmeng("渠道信息", UMConfigure.DEVICE_TYPE_PHONE, BuildConfig.DEBUG)
            .create()
    }
}