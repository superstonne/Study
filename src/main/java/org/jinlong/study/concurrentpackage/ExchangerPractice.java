package org.jinlong.study.concurrentpackage;

import java.util.concurrent.Exchanger;

/**
 * Created by nick on 31/05/2017.
 */
public class ExchangerPractice {

    public static void main(String[] args) {
        Exchanger exchanger = new Exchanger();

        new Thread(new ExchangeerRunnable(exchanger, "A")).start();
        new Thread(new ExchangeerRunnable(exchanger, "B")).start();

    }
}
