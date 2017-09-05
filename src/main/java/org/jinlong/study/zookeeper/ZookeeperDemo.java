package org.jinlong.study.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by xiaobao on 2017/8/10.
 */
public class ZookeeperDemo {
    //如果是集群地址，则服务器IP地址之间用逗号隔开
    public static final String CONNECTION_STRING = "192.168.152.132:2181,192.168.152.133:2181,192.168.152.134:2181";
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        //由于连接使用异步连接，所有我们定义门栓，等到连接到集群以后，由Watcher的回调函数打开门栓进行接下来的操作
        final CountDownLatch latch = new CountDownLatch(1);
        ZooKeeper zooKeeper = new ZooKeeper(CONNECTION_STRING, 10, new Watcher() {
            public void process(WatchedEvent watchedEvent) {
                if (Event.KeeperState.SyncConnected == watchedEvent.getState()) {
                    System.out.println("zookeeper connected successfully.");
                    latch.countDown();
                }
            }
        });
        latch.await();
        List<ACL> acls = new ArrayList<ACL>();
        //world：所有人都有 权限
        ACL worldACL = new ACL(ZooDefs.Perms.ALL, new Id("world", "anyone"));
        //auth: 所有服务器已经验证过的用户都有权限
        ACL authACL = new ACL(ZooDefs.Perms.ALL, new Id("auth", "user1:password1"));
        //digest：只有指定的用户才有权限，注意：password是base64加密而得的，创建时候需先获得加密后的密码
        ACL digestACL = new ACL(ZooDefs.Perms.ALL, new Id("digest", "user1:XDkd2dsEuhc9ImU3q8pa8UOdtpI="));
        //IP: 只有指定的IP才有权限
        ACL ipACL = new ACL(ZooDefs.Perms.ALL, new Id("ip", "192.168.152.133"));

        zooKeeper.addAuthInfo("digest", "user1:password1".getBytes());
//        //创建一个永久world节点，ACL为world：anyone：crwda
//        zooKeeper.create("/world", "world".getBytes(), Collections.singletonList(worldACL), CreateMode.PERSISTENT);
//
//        //创建一个永久auth节点，只有已经通过验证的用户才有权限，ACL为auth：：crwda
//        //特别注意：在使用该ACL之前，必须先给客户端添加验证过的user，负责创建失败
//        zooKeeper.addAuthInfo("digest", "user1:password1".getBytes());
//        zooKeeper.create("/auth", "auth".getBytes(), Collections.singletonList(authACL), CreateMode.PERSISTENT);
//
//        //创建一个永久的digest节点，只有指定的用户user1拥有权限，ACL为digest：user1：password：crwda
//        zooKeeper.create("/digest", "digest".getBytes(), Collections.singletonList(digestACL), CreateMode.PERSISTENT);
//
//        //创建一个永久的ip节点，只有特定ip的客户端才有权限，ACL为ip:ipaddress:crwda
//        zooKeeper.create("/ip", "ip".getBytes(), Collections.singletonList(ipACL), CreateMode.PERSISTENT);

        //获取节点数据
        byte[] results = zooKeeper.getData("/world", true, null);
        for (byte b : results) {
            System.out.print((char)b);
        }

        //获取节点ACL信息
        List<ACL> worldAcls  = zooKeeper.getACL("/world", new Stat());
        for (ACL acl : worldAcls) {
            System.out.println(acl);
        }

        //更新节点数据
        zooKeeper.setData("/world", "data has been changed".getBytes(), 1);

        //获取子节点
        List<String> nodes = zooKeeper.getChildren("/world", false);
        for (String node : nodes) {
            System.out.println(node);
        }

        byte[] resultsAfter = zooKeeper.getData("/world", true, null);
        for (byte b : resultsAfter) {
            System.out.print((char)b);
        }

        //更新节点权限信息
        zooKeeper.setACL("/world", Collections.singletonList(digestACL), 0);

        //删除节点
        zooKeeper.delete("/world", 2);




    }
}
