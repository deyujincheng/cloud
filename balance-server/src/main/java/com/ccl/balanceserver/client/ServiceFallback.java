package com.ccl.balanceserver.client;

import org.springframework.stereotype.Component;

/**
 * @author : chichenglong
 * @version : V0.5
 * @Project : OCHServ
 * @Package : com.ccl.balanceserver.client
 * @Class : ServiceFallback
 * @Description :
 * @CreateDate : 2020-11-04 17:01:25
 * @Copyright : 2019 dfcx.com Inc. All rights reserved.
 * @Reviewed :
 * @UpateLog :    Name    Date    Reason/Contents
 * ---------------------------------------
 * ****    ****    ****
 */
@Component
public class ServiceFallback implements ServiceFeignClient{
    @Override
    public String hello() {
        return "服务调用失败";
    }
}
