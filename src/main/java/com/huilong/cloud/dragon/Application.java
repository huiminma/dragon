package com.huilong.cloud.dragon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @author zhanghuilong
 * @desc
 * @since 2018/11/06
 */
@SpringBootApplication
@SpringBootConfiguration
@MapperScan(value = "com.huilong.cloud.dragon.dao")
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

    }


    /**
     * 设置允许跨域
     */
    @Configuration
    public class CorsConfig {
        /**
         允许任何域名使用
         允许任何头
         允许任何方法（post、get等）
         */
        private CorsConfiguration buildConfig() {
            CorsConfiguration corsConfiguration = new CorsConfiguration();
            corsConfiguration.addAllowedOrigin("http://localhost:8080");
            corsConfiguration.addAllowedHeader("*");
            corsConfiguration.addAllowedMethod("*");
            return corsConfiguration;
        }

        @Bean
        public CorsFilter corsFilter() {
            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
            source.registerCorsConfiguration("/**", buildConfig());
            return new CorsFilter(source);
        }
    }

}
