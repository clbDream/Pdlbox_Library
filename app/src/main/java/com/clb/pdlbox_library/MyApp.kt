package com.clb.pdlbox_library

import android.app.Application
import com.clb.mainlibrary.Kuduoduo

class MyApp: Application() {

    override fun onCreate() {
        super.onCreate()
        Kuduoduo.init(this)
    }
}