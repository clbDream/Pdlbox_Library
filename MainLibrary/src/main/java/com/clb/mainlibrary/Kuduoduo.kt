package com.clb.mainlibrary

import android.app.Application
import com.clb.bugly.BuglyLibrary
import com.clb.umeng.UmengLibrary

/**
 * 库多多入口类
 */
class Kuduoduo {

    class Builder(private val application: Application) {

        fun initBugly(): Builder {
            BuglyLibrary.init(application)
            return this
        }

        /**
         * 预初始化
         */
        fun preInitUmeng(channle: String,logEnable: Boolean): Builder {
            UmengLibrary.preInit(application, channle, logEnable)
            return this
        }

        /**
         * 正式初始化
         */
        fun initUmeng(
            channle: String,
            deviceType: Int,
            logEnable: Boolean
        ): Builder {
            UmengLibrary.init(application, channle, deviceType,logEnable)
            return this
        }

        fun create(): Kuduoduo {
            return Kuduoduo()
        }

    }
}