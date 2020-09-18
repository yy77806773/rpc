package net.yy.rpc.proxy;

import net.yy.rpc.model.Message;

public interface RpcProxy {
    void export();
    Message invoke();
}
