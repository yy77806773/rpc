package net.yy.rpc.transport.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import net.yy.rpc.proxy.RpcProxy;

public class Server {
    private EventLoopGroup boss = null;
    private EventLoopGroup work = null;
    private String host;
    private int port;

    public Server(String host, int port) {
        boss = new NioEventLoopGroup(1);
        work = new NioEventLoopGroup();
        this.host = host;
        this.port = port;
    }

    public void start(RpcProxy rpcProxy) throws InterruptedException {
        ServerBootstrap b = new ServerBootstrap();
        b.channel(NioServerSocketChannel.class);
        b.group(boss, work);
        b.childHandler(new NettyInitializer(rpcProxy));
        ChannelFuture future = b.bind(host, port).sync();
        System.out.println("server start");
    }

    class NettyInitializer extends ChannelInitializer<SocketChannel> {
        private RpcProxy rpcProxy;
        public NettyInitializer(RpcProxy rpcProxy) {
            this.rpcProxy = rpcProxy;
        }

        protected void initChannel(SocketChannel ch) throws Exception {
            ch.pipeline().addLast(new NettyHandler(rpcProxy));
        }
    }
}
