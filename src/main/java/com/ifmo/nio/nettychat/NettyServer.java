package com.ifmo.nio.nettychat;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.util.concurrent.GlobalEventExecutor;

// Больше примеров: https://github.com/netty/netty/tree/4.1/example/src/main/java/io/netty/example
public class NettyServer {
    private static final int PORT = 12345;

    public static void main(String[] args) throws InterruptedException {
        // Создаём EventLoop с одним потоком, который будет обрабатывать входящие
        // подключения.
        final EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        // EventLoop с одним потоком на обработку передачи данных.
        final EventLoopGroup workerGroup = new NioEventLoopGroup(1);

        // Собираем все каналы в группу для рассылки сообщений.
        final ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
        // Обработчик событий ввода/вывода.
        final ChatServerHandler serverHandler = new ChatServerHandler(channels);

        try {
            // Конфигурируем ТСР сервер.
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
//                    .option(ChannelOption.SO_BACKLOG, 100)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
//                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) {
                            System.out.println("Client connected: " + ch.remoteAddress());

                            // Добавлем обработчки ввода/вывода.
                            ChannelPipeline p = ch.pipeline();

                            //p.addLast(new LoggingHandler(LogLevel.INFO));
                            p.addLast(serverHandler);
                        }
                    });

            // Открываем порт, на котором будем слушать входящие подключения и ждём на Future.
            ChannelFuture f = b.bind(PORT).sync();

            // Закрываем канал.
            f.channel().closeFuture().sync();
        } finally {
            // Закрываем все EventLoop.
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    // Обработчик ввода-вывода.
    @Sharable
    public static class ChatServerHandler extends ChannelInboundHandlerAdapter {
        // Группа всех подключённых каналов.
        private final ChannelGroup channels;

        public ChatServerHandler(ChannelGroup channels) {
            this.channels = channels;
        }

        @Override
        public void channelActive(ChannelHandlerContext ctx) {
            // Обработка установления соединения.
            channels.add(ctx.channel());
        }

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) {
            // Канал готов для чтения данных.
            channels.write(Unpooled.copiedBuffer((ByteBuf) msg));
            channels.flush();
        }

        @Override
        public void channelInactive(ChannelHandlerContext ctx) {
            // Канал стал неактивным. Например, был закрыт или перестали приходить
            // heart-beat сообщения от клиента.
            System.out.println("Channel inactive, closing: " + ctx.channel().remoteAddress());

            ctx.close();
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
            // В случае исключения, к примеру, канал был зкарыт при записи или чтении
            // закрываем канал.
            cause.printStackTrace();
            ctx.close();
        }
    }
}
