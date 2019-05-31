# kotlin_frame
使用kotlin 搭建框架

 特别注意 ：1、该项目的其他成员，不得私自引用任何第三方的库，如需要须与项目组长讨论。
            2、与模块相关的库应该放在该模块的build.gradle 下，不得放在common ,防止引用太多，降低studio 的编译时间
            3、本框架不得使用butterKnife findViewById ,除不能直接找到相关id 外，使用findViewById，kotlin  支持直接引用xml 文件的id 即可
            4、studio 统一版本 3.4
            5、如果由moduleDev=true 切换到false，不能成功编译app ,需要clean project 即可正常

 1.在gradle.properties 文件
   moduleDev  false 关闭模块化开发，所有module 组成一个整体的app
              true  除common 模块其他module 均可单独运行

   releaseApi true  正式环境的API
              false  测试环境的API



    第三方库的引用

 1.  轮播图统一使用 第三方banner com.youth.banner:banner:1.4.10 ,如果不能满足UI 需求，可自定义view
 2.  json 解析 使用moshi 取代Gson , 原因更高效。需要注意 moshi 解析实体类，需与后台沟通哪些数据是可空，哪些是非空，可以全部视为可空，但是绑定数据的时候需要非空的判断
 3.  图片加载使用Glide ,可以直接使用SimpleImageLoad ，如不满足条件，可在同级目录下自行定义
 4.  数据库使用google 官方的room ,支持响应式编程，除 返回Flowable 相关字段，其他 增 删 改 均在Server 执行耗时操作，可参考 UserService
 5.  aRouter 阿里的跨模块页面跳转，相关的使用连接 https://github.com/alibaba/ARouter
     相关页面必须登录才能进入 使用Arouter 的拦截器
 6.  rxpermissions 权限申请
 7.  matisse 知乎 图片选择器 https://github.com/zhihu/Matisse
 8.  今日头条适配 https://www.wanandroid.com/blog/show/2343
 9.  图片选择器   https://github.com/zhihu/Matisse


  自定义控件
  1. toolBar 封装 目前满足 沉浸式状态栏颜色的切换
  2. CustomHeadView 详情页全屏式头部轮播图
  3. SmartRefreshFragment 封装 预加载页面 空页面 网络错误页面的 相关逻辑，使用适配器的模式，getItemViewType 返回不同的布局id ,实现多布局
  4. searchView 搜索控件 在xml 布局文件中可以设置 背景图片 搜索icon 着色 tint 值 字体大小 颜色 提示hint 等等
  5.
  6.
  7.
  8
  9.dialogFragment 弹出框基础封装



  该框架目前依然在优化阶段，如果大家有一些更好的想法，可以相互交流，尽早让这个版本成熟化，规范化。




