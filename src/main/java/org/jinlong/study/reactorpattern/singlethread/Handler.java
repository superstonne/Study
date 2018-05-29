package org.jinlong.study.reactorpattern.singlethread;


import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

public final class Handler implements Runnable {
    final SocketChannel socketChannel;
    final SelectionKey selectionKey;
    ByteBuffer input = ByteBuffer.allocate(1024);
    ByteBuffer output = ByteBuffer.allocate(1024);
    static final int READING = 0, SENDING = 1;
    int state = READING;

    public Handler(Selector selector, SocketChannel socketChannel) throws IOException {
        this.socketChannel = socketChannel;
        this.socketChannel.configureBlocking(false);
        selectionKey = socketChannel.register(selector, 0);
        selectionKey.attach(this);
        selectionKey.interestOps(SelectionKey.OP_READ);
        selector.wakeup();
    }

    boolean inputIsComplete() {
        return false;
    }
    boolean outputIsComplete() {
        return false;
    }

    void process() {
        input.flip();
        String msg = new String(input.array());
        System.out.print(msg);
        input.clear();
    }

    @Override
    public void run() {
        try {
            if (state == READING) {
                read();
            } else if (state == SENDING) {
                send();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void read() throws IOException {
        socketChannel.read(input);
        process();
        state = SENDING;
        selectionKey.interestOps(SelectionKey.OP_WRITE);
    }

    private void send() throws IOException {
        socketChannel.write(output);
        selectionKey.cancel();
    }
}
