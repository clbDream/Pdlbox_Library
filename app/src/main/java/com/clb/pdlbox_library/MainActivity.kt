package com.clb.pdlbox_library

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.amap.api.location.AMapLocationClient
import com.amap.api.maps.AMap
import com.amap.api.maps.MapsInitializer
import com.pdlbox.tools.utils.RegexUtils
import com.tencent.bugly.crashreport.CrashReport
import com.umeng.message.PushAgent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        CrashReport.testJavaCrash()

        initSdk()
    }

    /**
     * 初始化SDK
     */
    private fun initSdk() {
        //TODO 注意需要在隐私弹框同意后,做以下下更新操作
        //该方法是推送平台多维度推送决策必调用的方法，请务必调用
        //需在用户同意隐私政策协议之后调用，否则会出现合规问题
        PushAgent.getInstance(this).onAppStart()
        //TODO ***确保调用SDK任何接口前先调用更新隐私合规updatePrivacyShow、updatePrivacyAgree两个接口并且参数值都为true，若未正确设置有崩溃风险***
        MapsInitializer.updatePrivacyShow(this, true, true);
        MapsInitializer.updatePrivacyAgree(this, true);
    }

    fun amap(view: View) {
        startActivity(Intent(this, AMapActivity::class.java))
    }
}