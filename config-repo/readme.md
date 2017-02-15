URL与配置文件的映射关系如下：
/{application}/{profile}[/{label}]
/{application}-{profile}.yml
/{label}/{application}-{profile}.yml
/{application}-{profile}.properties
/{label}/{application}-{profile}.properties

这里的application指的是config.properties、config-prod.properties等里的config，与配置服务器里的application.properties里的spring.application.name=config-server没有任何关系。URL要根据这里的值来构造。配置客户端里的应用名要和这里的名字保持一致，如spring.application.name=config
http://localhost:7001/config/prod/config-label-test
http://localhost:7001/config/dev/config-label-test
