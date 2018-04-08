package org.jinlong.study.rs;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("device")
public class DeviceResource {

    private final DeviceDao deviceDao;

    public DeviceResource() {
        this.deviceDao = new DeviceDao();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Device get(@QueryParam("ip") final String deviceIp) {
        Device device = null;
        device = deviceDao.getDevice(deviceIp);;
        return device;
    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Device put(final Device device) {
        Device result = null;

        System.out.println(device);
        if (device != null) {
            result = deviceDao.updateDevice(device);
        }
        return result;
    }
}
