package net.yy.rpc.proxy;

import net.yy.rpc.model.Message;
import net.yy.rpc.model.ServiceInfo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class SimpleRpcProxy implements RpcProxy {
    private Map<String, ServiceInfo> serviceTable = new ConcurrentHashMap<>();
    @Override
    public void export() {

    }

    @Override
    public Message invoke() {
        return null;
    }
}
