spring.application.name：对应前配置文件中的{application}部分,即我的配置文件的名称格式中的“config”，与配置服务器的配置文件无关系，配置服务器甚至可以有多个
spring.cloud.config.profile：对应前配置文件中的{profile}部分
spring.cloud.config.label：对应前配置文件的git分支
spring.cloud.config.uri：配置中心的地址