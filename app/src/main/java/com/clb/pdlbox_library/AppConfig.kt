package com.clb.pdlbox_library

/**
 * 项目配置信息
 */
object AppConfig {

    /**
     * 获取bugid
     */
    fun getBuglyId(): String {
        return BuildConfig.BUGLY_ID
    }
}