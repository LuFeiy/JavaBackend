package com.yuan;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Date;

@WebListener
public class ConfigLoaderListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // 在Web应用启动时执行的代码，比如加载配置文件
        System.out.println("Loading application settings...");
        // 假设我们有一个方法loadApplicationSettings来加载设置
        loadApplicationSettings(sce.getServletContext());
    }

    private void loadApplicationSettings(ServletContext context) {
        // 这里是加载设置的逻辑，可能包括读取数据库或配置文件
        // 然后将设置存储在ServletContext范围内，以便整个应用程序都可以访问
        context.setAttribute("appSettings", new Date());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // 在Web应用关闭时执行的代码，比如清理资源
        System.out.println("Cleaning up application settings...");
    }
}
