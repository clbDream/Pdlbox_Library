package com.clb.umeng

import android.app.Application
import android.util.Log
import com.umeng.analytics.MobclickAgent
import com.umeng.commonsdk.UMConfigure
import com.umeng.message.PushAgent
import com.umeng.message.api.UPushRegisterCallback
import com.umeng.socialize.PlatformConfig
import org.android.agoo.huawei.HuaWeiRegister
import org.android.agoo.xiaomi.MiPushRegistar


object UmengLibrary {

    private val TAG = "UmengLibrary"

    fun preInit(application: Application, channle: String, logEnable: Boolean) {
        UMConfigure.preInit(application, BuildConfig.UM_KEY, channle)
        // 选用自动采集模式：https://developer.umeng.com/docs/119267/detail/118588#h1-u9875u9762u91C7u96C63
        MobclickAgent.setPageCollectionMode(MobclickAgent.PageMode.AUTO)

        // 初始化各个平台的 ID 和 Key
        PlatformConfig.setWeixin(BuildConfig.WX_ID, BuildConfig.WX_SECRET)
        PlatformConfig.setQQZone(BuildConfig.QQ_ID, BuildConfig.QQ_SECRET)

        // 初始化各个平台的文件提供者（必须要初始化，否则会导致无法分享文件）
        val fileProvider = application.packageName + ".provider"
        PlatformConfig.setWXFileProvider(fileProvider)
        PlatformConfig.setQQFileProvider(fileProvider)

        // 是否开启日志打印
        UMConfigure.setLogEnabled(logEnable)
    }

    fun init(
        application: Application,
        channle: String,
        deviceType: Int,
        logEnable: Boolean,
    ) {
        preInit(application, channle, logEnable)
        //初始化友盟
        UMConfigure.init(application,
            BuildConfig.UM_KEY,
            channle,
            deviceType,
            BuildConfig.UM_PUSH_SECRET)

        //注册推送
        PushAgent.getInstance(application).register(object : UPushRegisterCallback {
            override fun onSuccess(deviceToken: String) {
                //注册成功后返回deviceToken，deviceToken是推送消息的唯一标志
                if (BuildConfig.DEBUG) {
                    Log.i(TAG, "注册成功 deviceToken:$deviceToken")
                }
            }

            override fun onFailure(errCode: String, errDesc: String) {
                if (BuildConfig.DEBUG) {
                    Log.e(TAG, "注册失败 code:$errCode, desc:$errDesc")
                }
            }
        })

        MiPushRegistar.register(application, BuildConfig.XIAOMI_ID, BuildConfig.XIAOMI_KEY, false)
        HuaWeiRegister.register(application)
    }
}