package com.chaokunyang.springcloud.configclient.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangck
 * @create 2017-02-14 12:36
 */
@RestController
@RefreshScope
public class TestController {
    //@Value("${from}")
    private String from;

    @Value("${canDir}")
    private String canDir;

    @RequestMapping(value = "/from", method = RequestMethod.GET)
    public String from() {
        return from;
    }

    public String getFrom() {
        return from;
    }

    @RequestMapping(value = "/canDir", method = RequestMethod.GET)
    public String getCanDir() {
        return canDir;
    }
}
