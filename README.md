##### 2019年4月二十六放弃5月25的软考，开始完成这个p2p项目之旅，6月份之后加班太严重了，9月开始做架构的重构，这个项目是网上拿别人的项目做的架构重构的，页面资源样式自己也做了些改动，后台代码和表结构业务都是后期改的因为之前的的架构有点老，最近公司用springboot+springcload,这边直接将这个p2p项目改造springboot架构了，国庆窝在家里四五天没出门憋出来这个项目

# 项目经过架构改造之后，之前的项目架构是struts2, spring , springdata ,oracle单体应用

# 当前是用springboot 分布式架构
## 其中需要用相关的技术
### 1.java1.8、 mysql5.5 、redis 、框架为springboot+springmvc+mybatis+webservice+activeMQ
1. 项目结构
   - microservicecloud-api //实体类和一些中间件的配置类放在这个模块中
   - microservicecloud-consumer-dept-80  //P2P-ADMIN 后端管理系统的消费端+页面
   - microservicecloud-consumer-p2p-81 //P2P-WEB 消费端 + 页面 
   - microservicecloud-consumer-dept-feign //豪猪这里暂时不用
   - microservicecloud-eureka-7001
   - microservicecloud-eureka-7002 // eureka 其中7001和7003为了本地开发方便暂时不用到我在application.yml注释掉了
   - microservicecloud-eureka-7003 
   - microservicecloud-provider-dept-8001 //ActiveMQ   consumer
   - microservicecloud-provider-dept-8002 //P2P-ADMIN 后端管理系统服务提供方
   - microservicecloud-provider-dept-8003 //P2P-WEB服务提供断
   
   # 说明：
   
   - （1） 首先需要将eureka7002.com配置到host文件
   - （2）在启动redis  设置  auth  123456  因为我代码中写了需要auth 123456验证码和登录生成token都需要用到redis
   - （3）mysql需要创建表，语句我都放在\p2p-microservicecloud\microservicecloud-api\src\main\java\com\lijinquan\springcloud\sql下
   ### 启动前台页面
   - （1）首先启动microservicecloud-eureka-7002 这个提供注册用，再启动microservicecloud-consumer-p2p-81、microservicecloud-provider-dept-8003
   - （2）访问localhost：81 进入p2p平台首页
   - （3）平台中有一个充值的入口，这边还没跟相关银行的对接，但是我写了个测试项目，项目是需要用到webservice，可以到https://github.com/li-jin-quan/webservice下载并使用
   ### 启动后台管理系统
   - （1）数据库表上面一样的，启动顺序为microservicecloud-eureka-7002 、 microservicecloud-provider-dept-8002、microservicecloud-consumer-dept-80
   如果电脑性能好点这五个应用可以一起跑，端口不会冲突，而且eureka都是共用，如果你想开启多个eureka可以将项目中的注释放开，在host文件中配置相关信息即可
   
   
