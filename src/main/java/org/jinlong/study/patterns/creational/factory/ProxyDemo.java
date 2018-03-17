package org.jinlong.study.patterns.creational.factory;

public class ProxyDemo {

    public static void main(String[] args) {
        Requester requester = new RequesterImpl();
        requester.request();

        requester = new RequestProxy(requester);
        requester.request();
    }
}



interface Requester {
    String request();
}

class RequesterImpl implements Requester {
    @Override
    public String request() {
        System.out.println("Do requesting.");
        return null;
    }
}

class RequestProxy implements Requester {

    private Requester requester;

    public RequestProxy(Requester requester) {
        this.requester = requester;
    }

    void preRequest() {
        System.out.println("Pre requesting.");
    }

    @Override
    public String request() {
        preRequest();
        String result = requester.request();
        postRequest();
        return result;
    }

    void postRequest() {
        System.out.println("Post requesting.");
    }
}

