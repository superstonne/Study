package org.jinlong.study.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;

public class ChannelTransferPractice {
    public static void main(String[] args) throws IOException {
        String location = "E:\\workspace\\idea-workspace\\Study\\src\\main\\java\\org\\jinlong\\study\\nio";
        File[] files = new File(location).listFiles();
        for (int i = 0; i < files.length; i++) {
            FileChannel channel = new FileInputStream(files[i]).getChannel();
            channel.transferTo(0, channel.size(), Channels.newChannel(System.out));
            channel.close();
        }
    }
}
