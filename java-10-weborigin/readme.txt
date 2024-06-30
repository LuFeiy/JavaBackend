测试通过最原始的方式打war包，发布到tomcat中运行

相关命令
1· 编译，进入项目根目录
javac -d web/WEB-INF/classes/ -cp E:\SoftWare\apache-tomcat-9.0.64\lib\servlet-api.jar src/MyServlet.java

2. 打war包，进入web目录
jar -cvf wake.war *
