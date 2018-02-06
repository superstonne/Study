package org.jinlong.study.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;

public class MyKafkaProducer {
    private static final String KAKFA_BROKER_LIST =
            "192.168.152.132:9092";
    private final KafkaProducer<Integer, String> producer = null;
}
