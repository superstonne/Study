package org.jinlong.study.zookeeper.suscribe;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

public class Subscriber {
    private String name;
    private Watcher watcher;

    public Subscriber(String name) {
        this.name = name;
    }

    public Subscriber(String name, Watcher watcher) {
        this.watcher = watcher;
        this.name = name;
    }

    public void subscribe(ZooKeeper zooKeeper, String path) throws KeeperException, InterruptedException {
        zooKeeper.exists(path, watcher);
    }

    @Override
    public String toString() {
        return "Subscriber{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Watcher getWatcher() {
        return watcher;
    }

    public void setWatcher(Watcher watcher) {
        this.watcher = watcher;
    }
}
