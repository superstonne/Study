package org.jinlong.study.protocol;

import java.io.IOException;
import java.net.*;

public class UDPPractice {
    public static void main(String[] args) throws IOException {

        // 点对点通讯
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    DatagramSocket readDatagram = new DatagramSocket(8888);
                    DatagramPacket packet = new DatagramPacket(new byte[1000], 1000);
                    System.out.println("Waiting for packet...");
                    readDatagram.receive(packet);
                    System.out.println("Read packet: " + new String(packet.getData()));
                } catch (SocketException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        DatagramSocket datagramSocket = new DatagramSocket();
        String content = "This is test data gram packet.";
        DatagramPacket packet = new DatagramPacket(content.getBytes(), content.length());
        packet.setAddress(InetAddress.getByName("localhost"));
        packet.setPort(8888);
        datagramSocket.setBroadcast(true);
        datagramSocket.send(packet);
        System.out.println("Packet has been sent successfully.");

        // 广播通讯
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    MulticastSocket multicastSocket = new MulticastSocket(1234);
                    multicastSocket.joinGroup(InetAddress.getByName("228.5.6.7"));
                    DatagramPacket multicastPacket = new DatagramPacket(new byte[1000], 1000);
                    System.out.println("1234 Waiting for multicast packet...");
                    multicastSocket.receive(multicastPacket);
                    System.out.println("1234 Read packet: " + new String(multicastPacket.getData()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    MulticastSocket multicastSocket = new MulticastSocket(2345);
                    multicastSocket.joinGroup(InetAddress.getByName("228.5.6.7"));
                    DatagramPacket multicastPacket = new DatagramPacket(new byte[1000], 1000);
                    System.out.println("2345 Waiting for multicast packet...");
                    multicastSocket.receive(multicastPacket);
                    System.out.println("2345 Read packet: " + new String(multicastPacket.getData()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        MulticastSocket sentMulticastSocket = new MulticastSocket(5678);
        sentMulticastSocket.joinGroup(InetAddress.getByName("228.5.6.7"));
        String multicastContent = "This is a multicast message";
        DatagramPacket multicastPacket1234 = new DatagramPacket(multicastContent.getBytes(), multicastContent.length(),
                InetAddress.getByName("228.5.6.7"), 1234);
        DatagramPacket multicastPacket2345 = new DatagramPacket(multicastContent.getBytes(), multicastContent.length(),
                InetAddress.getByName("228.5.6.7"), 2345);
        sentMulticastSocket.send(multicastPacket1234);
        sentMulticastSocket.send(multicastPacket2345);
        System.out.println("Multicast message has been sent successfully.");
    }
}
