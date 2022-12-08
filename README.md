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
  
* 库多多(常用sdk集合项目)：[Pdlbox_Tools](https://github.com/clbDream/Pdlbox_Tools) ![](https://img.shields.io/github/stars/clbDream/Pdlbox_Tools.svg) ![](https://img.shields.io/github/forks/clbDream/Pdlbox_Tools.svg)

## 项目构成
  1. app(项目主工程目录,你的代码在这里编写)
  2. MainLibrary(库多多主库,其他库都通过这个库来集成,主工程目录只用集成这一个库)
  3. librarys(这里主要存放所搜集的三方库)
  4. bugly(bugly崩溃搜集库)

## 如何使用

### 如果你是新开项目,可以直接以此项目作为基础来进行开发,避免了导入库时存在的各种问题

### 如果是老项目需要使用这个库
  1. 将MainLibrary库导入你的项目中
  2. 按照你的实际需求,将librarys中的库导入到你的项目中(建议将所有库导入,可进行灵活配置)
  3. 修改库多多初始化方法,去掉不需要的库
```
object Kuduoduo {

    fun init(application: Application){
        //初始化Bugly
        BuglyLibrary.init(application)
    }
}
```
  4. 将你的app主项目依赖MainLibrary库
  5. 初始化库多多
```
class MyApp: Application() {

    override fun onCreate() {
        super.onCreate()
        Kuduoduo.init(this)
    }
}
```
  6. 至此,库多多引入完成