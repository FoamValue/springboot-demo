package cn.live;

import java.util.concurrent.TimeUnit;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleStateHandler;

public class NettyServerMain {

  private final static String host = "127.0.0.1";
  private final static int port = 9999;
  private final static int port2 = 9991;

  private void start() {
    EventLoopGroup bossGroup = new NioEventLoopGroup();
    EventLoopGroup workerGroup = new NioEventLoopGroup();
    try {
      ServerBootstrap b = new ServerBootstrap();
      b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
          .option(ChannelOption.SO_BACKLOG, 1024)
          // TCP默认开启了 Nagle 算法，该算法的作用是尽可能的发送大数据快，减少网络传输。TCP_NODELAY 参数的作用就是控制是否启用 Nagle
          // 算法。
          .childOption(ChannelOption.TCP_NODELAY, true).handler(new LoggingHandler(LogLevel.INFO))
          // 当客户端第一次进行请求的时候才会进行初始化
          .childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) {
              // 30 秒之内没有收到客户端请求的话就关闭连接
              ch.pipeline().addLast(new IdleStateHandler(30, 0, 0, TimeUnit.SECONDS));
            }
          })
          // TCP默认开启了 Nagle 算法，该算法的作用是尽可能的发送大数据快，减少网络传输。TCP_NODELAY 参数的作用就是控制是否启用 Nagle
          // 算法。
          .childOption(ChannelOption.TCP_NODELAY, true)
          // 是否开启 TCP 底层心跳机制
          .childOption(ChannelOption.SO_KEEPALIVE, true)
          // 表示系统用于临时存放已完成三次握手的请求的队列的最大长度,如果连接建立频繁，服务器处理创建新连接较慢，可以适当调大这个参数
          .option(ChannelOption.SO_BACKLOG, 128);

      // 绑定端口，同步等待绑定成功
      ChannelFuture f = b.bind(host, port).sync();
      ChannelFuture f2 = b.bind(host, port2).sync();
      // 等待服务端监听端口关闭
      f.channel().closeFuture().sync();

    } catch (InterruptedException e) {
      System.out.println("occur exception when start server:" + e);
    } finally {
      System.out.println("shutdown bossGroup and workerGroup");
      bossGroup.shutdownGracefully();
      workerGroup.shutdownGracefully();
    }
  }

  public static void main(String[] args) {
    NettyServerMain main = new NettyServerMain();
    main.start();
  }

}
