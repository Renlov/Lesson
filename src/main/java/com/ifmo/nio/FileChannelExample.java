package com.ifmo.nio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by xmitya on 10.01.17.
 */
public class FileChannelExample {
    public static void main(String[] args) throws Exception {
        File file = new File("test_nio_file.txt");

        write(file);
        read(file);
        copy_1(file, new File(file.getAbsolutePath() + ".copy"));
    }

    private static void write(File file) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
            // Канал можно получить из RandomAccessFile или FileInputStream/FileOutputStream
            FileChannel ch = raf.getChannel();

            String text = """
                    Hello!
                    Hello!
                    Hello!!!
                    """;

            byte[] bytes = text.getBytes(StandardCharsets.UTF_8);

            // Создаем буфер для записи данных.
            ByteBuffer buf = ByteBuffer.allocate(512);
//            ByteBuffer buf = ByteBuffer.wrap(bytes);

            // Заполняем буфер данными.
            buf.put(bytes);

            // Ставим лимит на место курсора, а курсор перемещаем в начало.
            buf.flip();

            // Записываем данные из буфера в канал (курсор будет перемещен
            // на позицию равную количеству записанных байт)
            int written = ch.write(buf);

            System.out.println(">> Written " + written + " bytes to file " + file.getAbsolutePath());
        }
    }

    private static void read(File file) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
            // Канал можно получить из RandomAccessFile или FileInputStream/FileOutputStream
            FileChannel ch = raf.getChannel();

            // Создаем буфер для чтениия данных.
            ByteBuffer buf = ByteBuffer.allocate(512);

            StringBuilder sb = new StringBuilder();

            // Читаем данные в буфер.
            while (ch.read(buf) != -1) {
                sb.append(new String(buf.array(), 0, buf.remaining()));

                // Очищаем буфер для следующего чтения.
                buf.clear();
            }

            System.out.println(">> Read from file " + file + ":");
            System.out.println(sb);
        }
    }

    private static void copy_1(File src, File dst) throws IOException {
        try (RandomAccessFile rafSrc = new RandomAccessFile(src, "r");
            RandomAccessFile rafDst = new RandomAccessFile(dst, "rw")) {
            FileChannel srcCh = rafSrc.getChannel();
            FileChannel dstCh = rafDst.getChannel();

            srcCh.transferTo(0, rafSrc.length(), dstCh);
//            dstCh.transferFrom(srcCh, 0, rafSrc.length());
        }
    }

    private static void copy_2(Path src, Path dst) throws IOException {
        Files.copy(src, dst);
    }
}
