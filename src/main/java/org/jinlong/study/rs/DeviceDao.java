package org.jinlong.study.rs;

import java.util.concurrent.ConcurrentHashMap;

public class DeviceDao {
    ConcurrentHashMap<String, Device> fakeDB = new ConcurrentHashMap<>();

    public DeviceDao() {
        fakeDB.put("10.11.58.163", new Device("10.11.58.163", 1));
        fakeDB.put("11.11.58.163", new Device("11.11.58.163", 1));
        fakeDB.put("12.11.58.163", new Device("12.11.58.163", 1));
        fakeDB.put("13.11.58.163", new Device("13.11.58.163", 1));
    }

    public Device getDevice(String indexIp) {
        return fakeDB.get(indexIp);
    }

    public Device updateDevice(Device device) {
        String id = device.getIp();
        fakeDB.put(id, device);
        return fakeDB.get(id);
    }
}
