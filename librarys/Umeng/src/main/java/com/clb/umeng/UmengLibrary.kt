package com.clb.umeng

import android.app.Application
import com.umeng.commonsdk.UMConfigure

object UmengLibrary {

    fun preInit(application: Application, appKey: String, channle: String) {
        UMConfigure.preInit(application, appKey, channle)
    }

    fun init(
        application: Application,
        appKey: String,
        channle: String,
        pushSecret: String,
        deviceType: Int,
    ) {
        //初始化友盟
        UMConfigure.init(application,
            appKey,
            channle,
            deviceType,
            pushSecret)

    }
}