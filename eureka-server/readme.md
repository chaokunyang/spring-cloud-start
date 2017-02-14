双节点高可用启动方式：
通过spring.profiles.active属性来分别启动peer1和peer2
java -jar eureka-server-1.0.0.jar --spring.profiles.active=peer1
java -jar eureka-server-1.0.0.jar --spring.profiles.active=peer2