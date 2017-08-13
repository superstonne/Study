package org.jinlong.study.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by xiaobao on 2017/7/30.
 */
@WebService
public class SayImpl implements ISay {
    @WebMethod
    public void sayHello(String name) {
        System.out.println("Hello " + name);
    }

    @WebMethod
    public String sayLocation() {
        return "ShangHai";
    }
}
