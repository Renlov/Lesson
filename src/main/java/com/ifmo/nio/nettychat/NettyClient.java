package com.ifmo.nio.nettychat;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.ByteToMessageCodec;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

// Больше примеров: https://github.com/netty/netty/tree/4.1/example/src/main/java/io/netty/example
public class NettyClient {

    private static final String HOST = "127.0.0.1";
    private static final int PORT = 12345;

    public static void main(String[] args) throws Exception {
        // Создаём EventLoop на один поток, который будет обрабатывать события канала.
        EventLoopGroup group = new NioEventLoopGroup(1);

        try {
            // Конфигурирование TCP канала.
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .option(ChannelOption.SO_KEEPALIVE, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) {
                            ChannelPipeline p = ch.pipeline();

//                            p.addLast(new LoggingHandler(LogLevel.INFO));
                            // Добавляем класс, который кодирует/декодирует сообщения.
                            p.addLast(new MessageCodec());
                            // Добавляем обработчик событий канала.
                            p.addLast(new ChatClientHandler());
                        }
                    });

            // Инициируем соединение с сервером.
            ChannelFuture f = b.connect(HOST, PORT).sync();

            // Получаем канал.
            Channel channel = f.channel();
            Scanner scanner = new Scanner(System.in);

            while (true) {
                String message = scanner.nextLine();

                if ("/exit".equals(message))
                    break;

                // Отправляем сообщение серверу.
                channel.write(message);
                channel.flush();
            }
        } finally {
            // Shut down the event loop to terminate all threads.
            group.shutdownGracefully();
        }
    }

    // Кодер-декодер бинарных сообщений: превращает набор байт в строку и наоборот.
    private static class MessageCodec extends ByteToMessageCodec<String> {
        @Override
        protected void encode(ChannelHandlerContext ctx, String msg, ByteBuf out) {
            out.writeBytes(msg.getBytes(StandardCharsets.UTF_8));
        }

        @Override
        protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) {
            int len = in.readableBytes();

            byte[] bytes = new byte[len];

            in.readBytes(bytes);

            out.add(new String(bytes, StandardCharsets.UTF_8));
        }
    }

    // Обработчик событий канала.
    public static class ChatClientHandler extends ChannelInboundHandlerAdapter {
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) {
            // Пришло новое сообщение в канал.
            System.out.println(msg);
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
