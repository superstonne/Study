package org.jinlong.study.zookeeper.suscribe;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.jinlong.study.zookeeper.Constants;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import static org.apache.zookeeper.Watcher.Event.*;

public class SubscriberPractice {
    static ZooKeeper zooKeeper;

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {

        final CountDownLatch latch = new CountDownLatch(1);
        zooKeeper = new ZooKeeper(Constants.CONNECTION_STRING, 100, new Watcher() {
            public void process(WatchedEvent event) {
                if (Event.KeeperState.SyncConnected == event.getState()) {
                    latch.countDown();
                }
            }
        });
        latch.await();
        for (int i = 0; i < 10; i++) {
            Subscriber subscriber = new Subscriber(String.valueOf(i));
            Watcher watcher = new MyWatcher(subscriber);
            subscriber.setWatcher(watcher);
            subscriber.subscribe(zooKeeper, "/subscribe");
        }

        System.in.read();

    }

    static class MyWatcher implements Watcher {
        private Subscriber subscriber;

        public MyWatcher(Subscriber subscriber) {
            this.subscriber = subscriber;
        }

        public void process(WatchedEvent event) {
            switch (event.getType().getIntValue()) {
                case -1:
                    System.out.println("type none");
                    break;
                case 1:
                    System.out.println("node created");
                    break;
                case 2:
                    System.out.println("node deleted");
                    break;
                case 3:
                    //此处实现接收到订阅改变后，继续注册watcher监听
                    System.out.println(this.subscriber + " has detected node data changed.");
                    try {
                        zooKeeper.exists(event.getPath(), this);
                    } catch (KeeperException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    System.out.println("node children changed");
                    break;
                default:
                    throw new RuntimeException("Invalid integer value for conversion to EventType");
            }
        }
    }
}
