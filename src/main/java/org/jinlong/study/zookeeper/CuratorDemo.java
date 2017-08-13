package org.jinlong.study.zookeeper;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryOneTime;
import org.apache.curator.utils.ZookeeperFactory;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.ACL;

import java.io.DataOutput;
import java.io.IOException;
import java.security.acl.Acl;
import java.util.List;

public class CuratorDemo {
    public static final String CONNECTION_STRING = "192.168.152.132:2181,192.168.152.133:2181,192.168.152.134:2181";
    public static void main(String[] args) throws Exception {
        //构建客户端配置
        CuratorFramework client = CuratorFrameworkFactory
                .builder()
                .authorization("digest", "nick:nick".getBytes())
                .connectString(CONNECTION_STRING)
                .retryPolicy(new RetryOneTime(10))
                .build();

        //启动客户端连接
        client.start();

        //创建节点curator
        client.create().forPath("/curator");

        //获取curator节点数据
        byte[] bytes = client.getData().forPath("/curator");
        for (byte b : bytes) {
            System.out.print((char) b);
        }

        //获取节点权限信息
        List<ACL> acls = client.getACL().forPath("/curator");
        for (ACL acl : acls) {
            System.out.println(acl);
        }

        //设置节点权限
        client.setACL().withACL(ZooDefs.Ids.CREATOR_ALL_ACL).forPath("/curator");

        //更新节点数据
        client.setData().forPath("/curator", "curator data has been changed.".getBytes());

        byte[] bytesAfterChange = client.getData().forPath("/curator");
        for (byte b : bytesAfterChange) {
            System.out.print((char) b);
        }

        //删除节点
        client.delete().forPath("/curator");

    }
}
