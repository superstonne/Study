package org.jinlong.study.webservice;

import javax.xml.ws.Endpoint;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by xiaobao on 2017/7/30.
 */
public class Bootstrap {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/say", new SayImpl());
        System.out.println("Server started.");
        String a = "a";
        a = "b";
    }
}
