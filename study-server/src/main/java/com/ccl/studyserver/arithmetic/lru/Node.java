package com.ccl.studyserver.arithmetic.lru;

/**
 * @author : chichenglong
 * @version : V0.5
 * @Project : OCHServ
 * @Package : com.ccl.studyserver.arithmetic.lru
 * @Class : Node
 * @Description :
 * @CreateDate : 2020-11-12 11:33:26
 * @Copyright : 2019 dfcx.com Inc. All rights reserved.
 * @Reviewed :
 * @UpateLog :    Name    Date    Reason/Contents
 * ---------------------------------------
 * ****    ****    ****
 */
public class Node {
    //键
    Object key;
    //值
    Object value;
    //上一个节点
    Node pre;
    //下一个节点
    Node next;

    public Node(Object key, Object value) {
        this.key = key;
        this.value = value;
    }
}
