package com.ccl.web;

import com.ccl.balanceserver.client.ServiceFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : chichenglong
 * @version : V0.5
 * @Project : OCHServ
 * @Package : com.ccl.web
 * @Class : TestWebController
 * @Description :
 * @CreateDate : 2020-10-31 15:13:41
 * @Copyright : 2019 dfcx.com Inc. All rights reserved.
 * @Reviewed :
 * @UpateLog :    Name    Date    Reason/Contents
 * ---------------------------------------
 * ****    ****    ****
 */

@RestController
@RequestMapping("/test")
public class TestWebController {

    @Value("${aa.bb}")
    String value;

    @Autowired
    private ServiceFeignClient serviceFeignClient;

    @RequestMapping("/value")
    public String value() {
        return "value:" + value;
    }

    @RequestMapping("/balance")
    public String balance() {
        System.out.println("进入web的balance方法");
        return serviceFeignClient.hello();
    }
}
