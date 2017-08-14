package org.jinlong.study.zookeeper;

import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;

import java.util.List;
import java.util.Map;

public class ZKClientDemo {
    public static final String CONNECTION_STRING = "192.168.152.132:2181,192.168.152.133:2181,192.168.152.134:2181";
    public static void main(String[] args) {
        //连接集群，此处zkClient做了处理，会一直等到成功连接才返回
        ZkClient zkClient = new ZkClient(CONNECTION_STRING);

        //创建节点
        String result = zkClient.create("/zkClient", "zkClient data", CreateMode.PERSISTENT);
        System.out.println("create node result: " + result);

        //读取节点数据
        String zkClientData = zkClient.readData("/zkClient");
        System.out.println(zkClientData);

        //读取节点权限信息
        Map.Entry<List<ACL>, Stat> acls = zkClient.getAcl("/zkClient");
        for (ACL acl : acls.getKey()) {
            System.out.println(acl);
        }
        System.out.println("stat: " + acls.getValue());

        //更新节点数据
        zkClient.writeData("/zkClient", "zkClient data has been changed");

        //增加用户信息
        zkClient.addAuthInfo("digest", "nick:nick".getBytes());

        //更新权限信息
        zkClient.setAcl("/zkClient", ZooDefs.Ids.CREATOR_ALL_ACL);

        //删除节点
        zkClient.delete("/zkClient");
    }
}
