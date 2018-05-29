package org.jinlong.study.reactorpattern.singlethread;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Reactor reactor = new Reactor(6666);

        new Thread(reactor).start();


    }

}
