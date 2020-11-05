package com.ccl.secondserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : chichenglong
 * @version : V0.5
 * @Project : OCHServ
 * @Package : com.ccl.server.controller
 * @Class : ServiceBalanceController
 * @Description :
 * @CreateDate : 2020-11-04 17:31:05
 * @Copyright : 2019 dfcx.com Inc. All rights reserved.
 * @Reviewed :
 * @UpateLog :    Name    Date    Reason/Contents
 * ---------------------------------------
 * ****    ****    ****
 */

@RestController
@RequestMapping(value = "service")
public class ServiceBalanceController {

    @RequestMapping("hello")
    public String hello() {
        System.out.println("service2:hello方法");
        return "service2:hello";
    }
}
