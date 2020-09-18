package net.yy.rpc;

import net.yy.rpc.proxy.RpcProxy;
import net.yy.rpc.transport.server.Sender;
import net.yy.rpc.transport.server.Server;

public class RpcServer extends Server implements Sender {
    RpcProxy rpcProxy;
    public RpcServer(RpcProxy rpcProxy) {
        super("localhost", 9999);
        this.rpcProxy = rpcProxy;
    }

    @Override
    public void sendMessage() {

    }
}
