package com.clb.pdlbox_library

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tencent.bugly.crashreport.CrashReport

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        CrashReport.testJavaCrash()
    }
}