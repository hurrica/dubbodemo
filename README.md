# dubbodemo

角色：
	
	provider：服务提供者，将服务注册到注册中心zookeeper
	
	container：服务容器，完成服务的加载、初始化和运行
	
	Consumer：服务消费者，从注册中心订阅相关服务
	
	Registry：服务注册中心，负责服务注册和调度
	
	monitor：服务运行状态监控，统计分析
		

* Consumer和provider之间的连接是持续性的，一旦服务断开，注册中心就能检测出来并通知消费者，那么是如何做到的呢？
答案是注册中心，dubbo依赖于zookeeper注册中心，zookeeper有四种节点类型，dubbo使用的是zookeeper的临时节点，dubbo将服务注册到zookeeper的临时节点，消费者订阅服务的时候会在该节点上注册一个watch，如果该节点有改动，则会通过zookeeper的事件通知到消费者

# 协议
1、dubbo。dubbo协议采用单一长连接和NIO异步通讯，适用于小数据量大并发的服务调用；dubbo协议不适用于大数据量的服务，比如传文件、视频等

2、RMI。RMI协议采用JDK标准的java.rmi实现，采用阻塞式短连接和JDK标准序列化方式。

3、hessian。hessian协议用于集成hessian服务，底层采用http通讯，采用servlet暴露服务，dubbo缺省内嵌jetty作为服务器实现

4、http。基于 HTTP 表单的远程调用协议，采用 Spring 的 HttpInvoker 实现

# 注册中心

1、Multicast。不需要启动任何中心节点，只要广播地址一样，就可以互相发现。为了减少广播量，Dubbo 缺省使用单播发送提供者地址信息给消费者，如果一个机器上同时启了多个消费者进程，消费者需声明 unicast=false，否则只会有一个消费者能收到消息，适用于开发或者小规模应用

2、zookeeper。zookeeper是一个高性能分布式应用，zookeeper注册中心的可靠性依赖于zookeeper本身的可靠性。虽然dubbo官方推荐使用zookeeper注册中心，但是阿里本身的dubbo注册中心并没有使用zookeeper，而是采用的自己实现的基于数据库的注册中心，因此zookeeper注册中心并没有在阿里内部长时间运行的可靠性保障

3、redis。redis注册中心使用key/Map结构：
* 主key为服务名和类型
* Map中的key为url地址
* Map中的value为过期时间，用于判断脏数据
使用redis的pub/sub事件通知数据变更

4、simple。simple注册中心本身是一个普通的dubbo服务，可以减少第三方依赖，使整体通讯方式一致。SimpleRegistryService 只是简单实现，不支持集群，可作为自定义注册中心的参考，不适合用于生产环境


	
