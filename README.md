# cloud
SpringCloud+SpringBoot+SpringCloudAlibaba  
  
  
springcloud全家桶与其他替换组建学习测试  
  
  
注册中心: 
一、eureka  AP  
1.单机与集群的搭建  
2.服务提供者的入驻与消费者的调用  
3.负载均衡与保护模式  
ps:hosts文件的修改  
二、zookeeper  CP  
1.单机搭建  
2.服务提供者的注册与消费者的调用  
3.查看zk客户端中服务节点下储存的信息  
ps:jar包版本冲突可在pom.xml中排除冲突的jar包再引入对应不冲突jar包  
三、consul  CP  
1.单机搭建  
2.服务提供者的注册与消费者的调用  
  
  
负载均衡:  
一、ribbon  
1.属于类库，进程内的负载均衡  
2.负载均衡模式:轮询，随机，轮询后重试，响应时间权重，过滤等  
3.自定义配置注意componentScan的扫描以及启动类的@RibbonClient，服务名为大写  
4.轮询算法-->请求与集群数量取余，  
ps:进程内负载均衡与集中式负载均衡比较；  
二、openfeign  
1.集成了ribbon，更方便面向服务接口编程  
2.默认1秒等待时间，超时控制  
3.日志输出  
  
  
断路器:  
一、hystrix  
1.防止雪崩效应  
2.服务降级(fallback):异常，超时，熔断，线程池或信号量打满时直接返回一个备选响应  
3.服务限流(flowlimit):秒杀高并发等操作,排队一个个处理  
4.服务熔断(break):达到最大访问量，直接拒绝访问，返回服务降级方法结果  
5.还可用于隔离，监控hystrixdashboard等  
ps:监控需要在主启动内配置默认路径；  

