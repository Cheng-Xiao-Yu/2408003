package cn.tedu.ivos.base.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//1.添加注解表示当前为配置类
@Configuration
public class WebConfig implements WebMvcConfigurer {//2.实现WebMvcConfigurer接口
    //3.重写addCorsMappings方法
    @Override
    public void addCorsMappings(CorsRegistry registry) {
       //4.需要在重写的方法体中，配置自己的跨域策略
        registry.addMapping("/**")// /**表示可以匹配客户端发来的任何请求
                .allowedHeaders("*") //表示允许携带任意请求头
                .allowedMethods("*") //表示允许使用任意请求方式 GET/POST/DELETE...
                .allowedOriginPatterns("*") //任意域都可以(任意请求端口号、请求地址...)
                .allowCredentials(true)//表示允许携带会话信息(cookie、session)
                .maxAge(3600);//表示当前请求可以保持一个小时(3600秒)不再检测，直接放行
    }
}
