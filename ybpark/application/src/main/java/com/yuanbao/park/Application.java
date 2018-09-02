package com.yuanbao.park;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.yuanbao.park.config.ds.ClusterDataSourceConfig;
import com.yuanbao.park.config.ds.MasterDataSourceConfig;

import org.springframework.boot.autoconfigure.web.MultipartAutoConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.web.MultipartProperties;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.DispatcherServlet;
import tk.mybatis.spring.annotation.MapperScan;

import javax.servlet.MultipartConfigElement;
import java.util.Properties;

/**
 * Spring Boot 应用启动类
 *
 * Created by bysocket on 16/4/26.
 */
// Spring Boot 应用的标识
@SpringBootApplication
@EnableSwagger2
public class Application extends SpringBootServletInitializer{
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }

    @Autowired
    private MultipartProperties multipartProperties;

    public static void main(String[] args) {
    	
        // 程序启动入口
        // 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
        SpringApplication.run(Application.class,args);
    }

    //取消上传文件大小限制
    @Bean
    @ConditionalOnMissingBean
    public MultipartConfigElement multipartConfigElement() {
        this.multipartProperties.setMaxFileSize("-1");
        this.multipartProperties.setMaxRequestSize("-1");
        return this.multipartProperties.createMultipartConfig();
    }
}
