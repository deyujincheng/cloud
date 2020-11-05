package com.ccl.server;

import org.springframework.stereotype.Service;

/**
 * @author : chichenglong
 * @version : V0.5
 * @Project : OCHServ
 * @Package : com.ccl.server
 * @Class : TestServiceImpl
 * @Description :
 * @CreateDate : 2020-10-28 22:05:49
 * @Copyright : 2019 dfcx.com Inc. All rights reserved.
 * @Reviewed :
 * @UpateLog :    Name    Date    Reason/Contents
 * ---------------------------------------
 * ****    ****    ****
 */
@Service
public class TestServiceImpl implements TestServices{
    @Override
    public String get(String name) {
        return "参数name:" + name;
    }
}
