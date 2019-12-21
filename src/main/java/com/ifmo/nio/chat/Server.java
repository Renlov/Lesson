package com.ifmo.nio.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by xmitya on 10.01.17.
 */
public class Server {

    public static void main(String[] args) {
        Server server = new Server();

        server.start();
    }

    public void start() {
        // Запускаем единственный поток, который будет обрабатывать все
        // соединения.
        new Thread(new NioWorker()).start();
    }

    private static class NioWorker extends Worker {
        private static final int BUF_SIZE = 1024;

        private ServerSocketChannel serverCh;
        private Selector sel;
        private ByteBuffer buf;

        @Override
        protected void init() throws Exception {
            // Создаем буфер для работы.
            buf = ByteBuffer.allocate(BUF_SIZE);

            // Создаем селектор.
            sel = Selector.open();

            // Открываем канал сервера.
            serverCh = ServerSocketChannel.open();

            // Слушаем адрес 12345.
            serverCh.bind(new InetSocketAddress(12345));

            // Переводим в неблокирующий режим.
            serverCh.configureBlocking(false);

            // Регистрируем канал в селекторе на все допустимые события.
            serverCh.register(sel, serverCh.validOps());
        }

        @Override
        protected void loop() throws Exception {
            // Ждем новых событий.
            sel.select();

            // Получаем ключи, на которые пришли события.
            Set<SelectionKey> keys = sel.selectedKeys();

            // Необходимо использовать итератор для того, чтобы удалить обработанные ключи
            Iterator<SelectionKey> iter = keys.iterator();

            // Обрабатываем все ключи.
            while (iter.hasNext()) {
                SelectionKey key = iter.next();

                // Этот флаг означает, что пришло входящее подключение и можно
                // получить новый канал для этого соединения.
                if (key.isAcceptable()) {
                    // Получаем канал.
                    SocketChannel ch = serverCh.accept();

                    // Переводим в неблокирующий режим.
                    ch.configureBlocking(false);

                    // Регистрируем в селекторе.
                    ch.register(sel, SelectionKey.OP_READ);

                    System.out.println("Client connected " + ch.getRemoteAddress());
                }

                // Этот флаг означает, что пришли данные для чтения.
                else if (key.isReadable())
                    // Читаем входящие данные.
                    doRead((SocketChannel) key.channel());

                // Первый флаг проверяет, что соединение еще открыто,
                // а второй, что канал готов к отправке данных.
                else if (key.isValid() && key.isWritable())
                    // Записываем данные в канал.
                    doWrite((SocketChannel) key.channel(), key);

                // Удаляем обработанный ключ.
                iter.remove();
            }
        }

        @Override
        protected void stop() throws Exception {
            serverCh.close();
            sel.close();
        }

        private void doRead(SocketChannel ch) throws IOException {
            // Готовим буфер для чтения данных.
            buf.clear();

            try {
                // Как и для InputStream возвращаается число прочитанных байт
                // или -1, если канал закрыт.
                int read = ch.read(buf);

                if (read != -1)
                    System.out.println(new String(buf.array(), 0, buf.position(), StandardCharsets.UTF_8));
                else {
                    System.out.println("Client disconnected: " + ch.getRemoteAddress());

                    ch.close();
                }

                // Готовим буфер для записи.
                buf.flip();

                // Берем все доступные ключи, чтобы установить им интерес на запись,
                // т.к. рассылаем прочитанное сообщение широковещательно.
                Set<SelectionKey> keys = sel.keys();

                for (SelectionKey key : keys) {
                    // Проверяем, что допускается установить интерес на запись, и
                    // если да, то устанавливаем.
                    if ((key.channel().validOps() & SelectionKey.OP_WRITE) > 0)
                        key.interestOps(key.interestOps() | SelectionKey.OP_WRITE);
                }
            }
            catch (IOException | RuntimeException e) {
                System.out.println("Client disconnected");

                buf.clear();

                ch.close();
            }
        }

        private void doWrite(SocketChannel ch, SelectionKey key) throws IOException {
            // Записываем данны из буфера.
            ch.write(buf);

            // Подготаливаем для следующей записи.
            buf.rewind();

            // Сбрасываем интерес на запись.
            key.interestOps(key.interestOps() & ~SelectionKey.OP_WRITE);
        }
    }
}

