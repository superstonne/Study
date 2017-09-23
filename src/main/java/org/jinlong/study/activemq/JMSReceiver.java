package org.jinlong.study.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTextMessage;

import javax.jms.*;

public class JMSReceiver {
    public static void main(String[] args) throws JMSException {
        ConnectionFactory factory = new ActiveMQConnectionFactory
                ("tcp://192.168.152.132:61616");
        Connection connection = factory.createConnection();
        connection.start();
//        Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
        Session session = connection.createSession(Boolean.FALSE, Session.CLIENT_ACKNOWLEDGE);
        Destination destination = session.createQueue("queue");
        MessageConsumer consumer = session.createConsumer(destination);
        ActiveMQTextMessage message = (ActiveMQTextMessage) consumer.receive();
        System.out.println(message.getText());
        message.acknowledge();
//        session.commit();
        session.close();
        connection.close();

    }
}
