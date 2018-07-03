# dubbodemo

角色：
	
	provider：服务提供者，将服务注册到注册中心zookeeper
	
	container：服务容器，完成服务的加载、初始化和运行
	
	Consumer：服务消费者，从注册中心订阅相关服务
	
	Registry：服务注册中心，负责服务注册和调度
	
	monitor：服务运行状态监控，统计分析
		

* Consumer和provider之间的连接是持续性的，一旦服务断开，注册中心就能检测出来并通知消费者，那么是如何做到的呢？

 答案是注册中心，dubbo依赖于zookeeper注册中心，zookeeper有四种节点类型，dubbo使用的是zookeeper的临时节点，dubbo将服务注册到zookeeper的临时节点，消费者订阅服务的时候会在该节点上注册一个watch，如果该节点有改动，则会通过zookeeper的事件通知到消费者

	
