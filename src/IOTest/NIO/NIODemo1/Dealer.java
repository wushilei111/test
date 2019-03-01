package IOTest.NIO.NIODemo1;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Dealer {
    public static SocketChannel accept(Selector selector, ServerSocketChannel serverSocketChannel){
        SocketChannel socketChannel = null;
        try{
            socketChannel = serverSocketChannel.accept();
            socketChannel.configureBlocking(false);
            socketChannel.register(selector, SelectionKey.OP_READ);
            return socketChannel;
        } catch (IOException e) {
            e.printStackTrace();
            if (socketChannel!=null){
                try {
                    socketChannel.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return socketChannel;
    }


}
