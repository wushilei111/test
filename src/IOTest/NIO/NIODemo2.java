package IOTest.NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;

public class NIODemo2 {

    private Selector selector;

    public void init(){
        try{
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false );
            serverSocketChannel.socket().bind(new InetSocketAddress(8899));
            selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            //将此服务器连接注册到选择器，并声明对接收就
            // 绪事件感兴趣，当此服务器接受到连接时会将与之关联SelectionKey对象放入选择器就绪队列

            while (true){
                selector.select();//可设置超时.则超时返回0
                Iterator<SelectionKey> it = selector.selectedKeys().iterator();
                while(it.hasNext()){
                    try{
                        SelectionKey selectionKey = it.next();
                        if (selectionKey.isAcceptable()){
                            //表示一个连接处于接收就绪状态，在此处进行处理
                            new Socket().getInputStream().read();
                        }
                    }finally {
                        it.remove();//此事件已被处理必须手动将此事件从事件队列移除
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}
