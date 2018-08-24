# ManageSystem
ssh &amp; mysql for my wower register <br />

1.下载一个tomcat,百度有官方网址下载，下载下来安装就可以用<br />
1.1 源码需要修改的位置就是你的mysql配置  在源码/src/config/jdbc.properties 这个文件里面<br />
    host=127.0.0.1<br />
    dbName=acore_auth<br />
    jdbc.username=root<br />
    jdbc.password=****<br />
1.2 修改 邮件发送内容  ManageSystem/src/com/lee/service/impl/UserServiceImpl.java 
    SendMailUtil.send 的参数   可以参考ManageSystem/src/com/lee/util/SendMailUtil.java  里面的main函数<br />
2.需要下eclipse将源码编译成war包。 百度eclipse 就可以了。再百度下eclipse打包项目就知道咋做了.<br />
3.编译会生成一个ManageSystem.war<br />
4.将这个包丢到tomcat目录下的webapps文件夹里面，然后启动tomcat就可以了<br />
5.访问的本地地址是:http://localhost:8080/ManageSystem/html/index.html   localhost 改自己的ip就行<br />

补充事项：我给accout表增加了一个password字段 vachar(40) 以便于管理
