package org.jinlong.study.rs;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "device")
public class Device {

    private String ip;
    private int status;

    public Device() {
    }

    public Device(String ip, int status) {
        this.ip = ip;
        this.status = status;
    }

    @XmlAttribute
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @XmlAttribute
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
