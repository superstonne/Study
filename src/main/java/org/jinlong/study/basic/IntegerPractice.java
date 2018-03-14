package org.jinlong.study.basic;

import java.util.logging.Level;
import java.util.logging.Logger;

public class IntegerPractice {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("log");
        logger.log(Level.WARNING, "test logger.");
        logger.log(Level.SEVERE, "severe.");
    }
}
