package org.jinlong.study.patterns.structural;

public class FacadeDemo {
    public static void main(String[] args) {

    }
}

class Client {
    BuyFacade facade = new BuyFacader();
    void buy() {
        facade.buy();
    }
}

abstract class BuyFacade {
    abstract void buy();
}

class BuyFacader extends BuyFacade {

    Dispatch dispatch = new Dispatch();
    Buyer buyer = new Buyer();
    Sender sender = new Sender();

    @Override
    void buy() {
        dispatch.dispatch();
        buyer.buy();
        sender.send();
    }
}

class Dispatch {
    void dispatch() {
        System.out.println("Dispatch...");
    }
}

class Buyer {
    void buy() {
        System.out.println("Buy...");
    }
}

class Sender {
    void send() {
        System.out.println("Send...");
    }
}
