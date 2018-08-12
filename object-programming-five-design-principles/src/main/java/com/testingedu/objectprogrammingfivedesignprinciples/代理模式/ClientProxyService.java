package com.testingedu.objectprogrammingfivedesignprinciples.代理模式;

import org.springframework.stereotype.Service;

@Service
public class ClientProxyService {
    public void testRequest() {
        Proxy realProxy = new Proxy();
        realProxy.request();
    }

}
