spring.application.name：对应前配置文件中的{application}部分,即我的配置文件的名称格式中的“config”，与配置服务器的配置文件无关系，配置服务器甚至可以有多个
spring.cloud.config.profile：对应前配置文件中的{profile}部分
spring.cloud.config.label：对应前配置文件的git分支
spring.cloud.config.uri：配置中心的地址


/bus/refresh POST 会将刷新配置信息发布到消息队列，各个实例会重新从配置服务器获取配置信息。
注意：触发更新是异步的，消息队列可能会有延迟，有时时间比较长，长达10s以上，这是正常的，不要在请求完成后没看到更新就认为程序有问题，多等一会就好了
若想指定刷新范围，加上参数destination：
/bus/refresh?destination=config:7002
/bus/refresh?destination=config:**

从Git仓库中配置的修改到发起/bus/refresh的POST请求这一步可以通过Git仓库的Web Hook来自动触发。由于所有连接到消息总线上的应用都会接受到更新请求，所以在Web Hook中就不需要维护所有节点内容来进行更新，从而解决了通过Web Hook来逐个进行刷新的问题。

缺点：
当我们需要对服务实例进行迁移时，那么我们就不得不修改Web Hook中的配置等。所以我们要尽可能的让服务集群中的各个节点是对等的。
解决方案：
在Config Server中也引入Spring Cloud Bus，将配置服务端也加入到消息总线中来。
/bus/refresh请求不在发送到具体服务实例上，而是发送给Config Server，并通过destination参数来指定需要更新配置的服务或实例。

bootstrap配置也可以使用profile