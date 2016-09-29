"# back-front" 
1.启动keycloak服务
服务下载地址：https://downloads.jboss.org/keycloak/2.2.1.Final/keycloak-2.2.1.Final.zip
解压程序安装包，进入到D:\mzk\keycloak-2.2.1.Final\bin目录下
双击standalone.bat启动程序 
2.进入keycloak管理控制台
http://localhost:8080/auth
初次登录，可以设置用户名和密码
创建realm  name：myfuture
选择配置下的Clients, 点击Create
Client ID : back-front
Root URL: * //表示任意机器都可以访问
保存，可以给此应用系统（back-front添加用户）
获取跳转登录配置文件
{
  "realm": "myfuture",
  "realm-public-key": "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAh8HuYtQn6aZJ27iUFiU9rB9yNsd9G9voSYltV0WynspUPb5qE3T45x3QisDxCAMjmhR+CW17OBeDHJZ2Y7INrQwyOnTX6rS11Vm6eI0S4Oica+15cV6DrSwIO4qmXMbqCagQhOIMr8yhwBZXeT85G6/nXZAKRHQkyMZ4gyRSGDxzL1dIkPyetFQOeXbwr0rqecDWvg9LtOEtZ+dQKX4v/OOtwnmTA7p6jrKaCbmYKcwUy6molilkHmAxazHj2QZYg7jwDWKuVPqOzAIKT5E+403ElJITNfLUjRtYyBRtm367hfV+/IP+vXXPuebRO9W14yU/AmoQOUG4oKP4uBZIAQIDAQAB",
  "auth-server-url": "http://192.168.8.168:8080/auth",
  "ssl-required": "external",
  "resource": "back-front",
  "public-client": true
}
3.将back-front工程导入到IDE（Intellij、Eclipse、Netbeans）中
 创建数据库，数据库名 test
 将第二步的配置文件拷贝到front工程WEB-INF中的keycloak.json中
 修改back工程中的数据库地址，数据库访问名，密码
 启动back
 启动front
 4.访问地址：http://IP:8088/front
 已满足简单的查询、增加、删除、修改。
