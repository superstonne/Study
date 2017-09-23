package org.jinlong.study.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTextMessage;

import javax.jms.*;

public class JMSTopic {
    public static void main(String[] args) throws JMSException {
        ConnectionFactory factory = new ActiveMQConnectionFactory
                ("tcp://192.168.152.132:61616");
        Connection connection = factory.createConnection();
        connection.start();
        Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createTopic("topic");
        MessageProducer producer = session.createProducer(destination);
        TextMessage message = new ActiveMQTextMessage();
        message.setText("message from Nick");
        producer.send(message);
        session.commit();
        session.close();
        connection.close();

    }
}
