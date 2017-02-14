package com.chaokunyang.springcloud.apigateway;

import com.chaokunyang.springcloud.apigateway.filter.AccessFilter;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * @author yangck
 * @create 2017-02-14 15:19
 */
@SpringCloudApplication
@EnableZuulProxy
public class Application {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class).web(true).run(args);
    }

    @Bean
    public AccessFilter accessFilter() {
        return  new AccessFilter();
    }
}
