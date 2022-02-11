package com.bright.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author OUKELE
 * @create 2019-03-22 11:27
 */

@Configuration
@ConfigurationProperties(prefix = "spring.datasource")//读取 application.properties里的内容
public class DruidConfig {

    //数据库 url
    private String url;
    //数据库用户名
    private String username;
    //数据库登陆密码
    private String password;
    //最大的连接数量
    private final int maxActive= 20;
    //初始化大小
    private final int initialSize= 5;
    // 设置 超时的等待时间
    private final int maxWait =-1;
    //最小的连接数量
    private final int minIdle=1;
    //监控统计拦截的filters，如果去掉后监控界面sql将无法统计
    private final String filters="stat,wall,slf4j";

    public String getFilters() {
        return filters;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMaxActive() {
        return maxActive;
    }


    public int getInitialSize() {
        return initialSize;
    }


    public int getMaxWait() {
        return maxWait;
    }


    public int getMinIdle() {
        return minIdle;
    }


    //注册 Servlet 组件
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        /*servletRegistrationBean.addInitParameter("allow", "192.168.1.3"); //白名单IP*/
        servletRegistrationBean.addInitParameter("loginUsername", "druid");
        servletRegistrationBean.addInitParameter("loginPassword", "12345");
        return servletRegistrationBean;
    }

    // 注册 Filter 组件
    @Bean
    public FilterRegistrationBean statFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        //验证所有请求
//        filterRegistrationBean.addUrlPatterns("/*");
        //对 *.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/* 不进行验证
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*,/*");
        return filterRegistrationBean;
    }

    //配置数据源
    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setMaxActive(maxActive);
        dataSource.setInitialSize(initialSize);
        try {
            dataSource.setFilters(filters);
        } catch (SQLException e) {
            //do nothing
        }
        dataSource.setMaxWait(maxWait);
        dataSource.setMinIdle(minIdle);
        return dataSource;
    }
}
