# 潘多拉-库多多

开发一套纯粹的工具库

[![](https://jitpack.io/v/com.gitee.clbDream/pdl-box_library.svg)](https://jitpack.io/#com.gitee.clbDream/pdl-box_library)

![](images/banner.png)

## 简介

这是一个Android开发工具库系列开源项目,主要用来搜集安卓开发过程中常用的开发工具库,并可根据需求灵活选用配置,每个库我都会定时更新最新版本,以满足每个人的需求,现在开源,供广大Android开发程序员同胞使用,欢迎大家一起来进行维护

我也是个萌新程序员,项目有什么地方不足,请多多指教,哈哈

#### 作者的其他开源项目

* 多功能记录项目<事迹>
  ：[RecordThings-Android](https://github.com/clbDream/RecordThings-Android) ![](https://img.shields.io/github/stars/clbDream/RecordThings-Android.svg) ![](https://img.shields.io/github/forks/clbDream/RecordThings-Android.svg)

* 工具库(常用工具类集合项目)
  ：[Pdlbox_Tools](https://github.com/clbDream/Pdlbox_Tools) ![](https://img.shields.io/github/stars/clbDream/Pdlbox_Tools.svg) ![](https://img.shields.io/github/forks/clbDream/Pdlbox_Tools.svg)

## 项目构成

1. app(项目主工程目录,你的代码在这里编写)
2. MainLibrary(库多多主库,其他库都通过这个库来集成,主工程目录只用集成这一个库)
3. librarys(这里主要存放所搜集的三方库)
4. bugly(bugly崩溃搜集库)
4. Umeng(友盟相关库)

## 如何使用

### 如果你是新开项目,可以直接以此项目作为基础来进行开发,避免了导入库时存在的各种问题

### 如果是老项目需要使用这个库

1. 将MainLibrary库导入你的项目中
2. 按照你的实际需求,将librarys中的库导入到你的项目中(建议将所有库导入,可进行灵活配置)
3. 修改库多多初始化方法,去掉不需要的库

```
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
```

4. 将你的app主项目依赖MainLibrary库
5. 初始化库多多

```
class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        //以下SDK根据你的实际需求调用,这里只是做演示使用
        Kuduoduo.Builder(this)
            //初始化Bugly
            .initBugly()
            //预初始化友盟(可在应用启动时调用)
            .preInitUmeng("渠道信息", BuildConfig.DEBUG)
            //初始化友盟(在同意隐私政策之后再调用)
            .initUmeng("渠道信息", UMConfigure.DEVICE_TYPE_PHONE, BuildConfig.DEBUG)
            .create()
    }
}
```

6. 至此,库多多引入完成

# 特别说明

## 推送相关
    1. 需要在统同意隐私政策时候调用
        //该方法是推送平台多维度推送决策必调用的方法，请务必调用
        //需在用户同意隐私政策协议之后调用，否则会出现合规问题
        PushAgent.getInstance(this).onAppStart()
    2. 推送配置的PUSH_SECRET是Umeng Message Secret,不是App Master Secret

# 常见问题

1. 第三方SDK中的appId等参数怎么配置 相关的配置信息已封装在configs.gradle文件中,可通过修改对应的信息来替换

```
ext {
// 友盟 AppKey
UMENG_APP_KEY = "6391f71088ccdf4b7e9f2fd2"
//友盟推送
UMENG_PUSH_SECRET = "ed2a19398e6ddf107dd7b5de062c2018"
// QQ AppId
QQ_APP_ID = "101828096"
// QQ Secret
QQ_APP_SECRET = "9dfd3300c3aa3c4596a07796c64914b2"
// 微信 AppId
WX_APP_ID = "wxd35706cc9f46114c"
// 微信 Secret
WX_APP_SECRET = "0c8c7cf831dd135a32b3e395ea459b5a"
//BuglyId
BUGLY_ID = "6dbea536a8"
//小米推送
XIAOMI_ID = "请自行配置"
XIAOMI_KEY = "请自行配置"
//华为APPID
HUAWEI_ID = "请自行配置"
}
```

2. 如果库多多有新的更新,我的项目该怎么更新
    库多多是以项目的形式发布的,一般情况下只需要替换librarys中的文件即可,如果有其他修改,会在对应的版本说明中进行介绍
    
 
    