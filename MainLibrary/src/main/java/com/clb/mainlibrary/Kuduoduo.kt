package com.clb.mainlibrary

import android.app.Application
import com.clb.bugly.BuglyLibrary
import com.clb.umeng.UmengLibrary

/**
 * 库多多入口类
 */
class Kuduoduo {

    class Builder(private val application: Application) {

        fun initBugly(appKey: String): Builder {
            BuglyLibrary.init(application, appKey)
            return this
        }

        /**
         * 预初始化
         */
        fun preInitUmeng(appKey: String, channle: String): Builder {
            UmengLibrary.preInit(application, appKey, channle)
            return this
        }

        /**
         * 正式初始化
         */
        fun initUmeng(
            appKey: String,
            channle: String,
            pushSecret: String,
            deviceType: Int,
        ): Builder {
            UmengLibrary.init(application, appKey, channle, pushSecret, deviceType)
            return this
        }

        fun create(): Kuduoduo {
            return Kuduoduo()
        }

    }
}