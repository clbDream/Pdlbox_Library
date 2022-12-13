package com.clb.pdlbox_library

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pdlbox.tools.utils.RegexUtils
import com.tencent.bugly.crashreport.CrashReport
import com.umeng.message.PushAgent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        CrashReport.testJavaCrash()
        //该方法是推送平台多维度推送决策必调用的方法，请务必调用
        //需在用户同意隐私政策协议之后调用，否则会出现合规问题
        PushAgent.getInstance(this).onAppStart()
    }
}