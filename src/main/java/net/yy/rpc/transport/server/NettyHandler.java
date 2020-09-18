package net.yy.rpc.transport.server;

import io.netty.channel.ChannelInboundHandlerAdapter;
import net.yy.rpc.proxy.RpcProxy;

public class NettyHandler extends ChannelInboundHandlerAdapter {
    private RpcProxy rpcProxy;
    public NettyHandler(RpcProxy rpcProxy) {
        this.rpcProxy = rpcProxy;
    }
}
