package com.chaokunyang.springcloud.eurekafeign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * 使用@FeignClient("compute-service")注解来绑定该接口对应compute-service服务
 * 通过Spring MVC的注解来配置compute-service服务下的具体实现。
 *
 * 虽然是Feign是Web Service客户端，但在Spring Cloud里面，本质是也是被实现为HTTP请求方式
 *
 * @author yangck
 * @create 2017-02-14 10:34
 */
@FeignClient(value = "compute-service", fallback = ComputeClientHystrix.class)
public interface ComputeClient {

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);
}