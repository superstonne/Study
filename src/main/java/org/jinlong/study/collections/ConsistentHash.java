package org.jinlong.study.collections;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class ConsistentHash<SERVER> {
    private TreeMap<Long, SERVER> nodes;
    private List<SERVER> trueNodes;
    private final int VIRTUAL_NODE_NUM = 100;

    public ConsistentHash(List<SERVER> trueNodes) {
        this.trueNodes = trueNodes;
        nodes = new TreeMap<Long, SERVER>();
        for (int i = 0; i < trueNodes.size(); i++) {
            SERVER server = trueNodes.get(i);
            for (int j = 0; j < VIRTUAL_NODE_NUM; j++) {
                nodes.put(hash("TRUE-NODE" + i + "VIRTUAL-NODE" + j), server);
            }
        }
    }

    public SERVER get(String key) {
        SortedMap<Long, SERVER> tail = nodes.tailMap(hash(key));
        if (tail.isEmpty()) {
            return nodes.get(nodes.firstKey());
        }
        return tail.get(tail.firstKey());
    }

    private Long hash(String key) {

        ByteBuffer buf = ByteBuffer.wrap(key.getBytes());
        int seed = 0x1234ABCD;
        ByteOrder byteOrder = buf.order();
        buf.order(ByteOrder.LITTLE_ENDIAN);
        long m = 0xc6a4a7935bd1e995L;
        int r = 47;
        long h = seed ^ (buf.remaining() * m);
        long k;
        while (buf.remaining() >= 8) {
            k = buf.getLong();
            k *= m;
            k ^= k >>> r;
            k *= m;
            h ^= k;
            h *= m;
        }
        if (buf.remaining() > 0) {
            ByteBuffer finish = ByteBuffer.allocate(8).order(
                    ByteOrder.LITTLE_ENDIAN);
            // for big-endian version, do this first:
            // finish.position(8-buf.remaining());
            finish.put(buf).rewind();
            h ^= finish.getLong();
            h *= m;
        }
        h ^= h >>> r;
        h *= m;
        h ^= h >>> r;
        buf.order(byteOrder);
        return h;
    }

}
