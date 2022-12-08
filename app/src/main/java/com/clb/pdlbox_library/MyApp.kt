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
            .initBugly("6dbea536a8")
            //预初始化友盟(可在应用启动时调用)
            .preInitUmeng("6391f71088ccdf4b7e9f2fd2","渠道信息")
            //初始化友盟(在同意隐私政策之后再调用)
            .initUmeng("6391f71088ccdf4b7e9f2fd2","渠道信息","ed2a19398e6ddf107dd7b5de062c2018", UMConfigure.DEVICE_TYPE_PHONE)
            .create()
    }
}