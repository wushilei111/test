package shejimoshi.command;

import java.util.ArrayList;
import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
        Receiver receiver = new ReceiverImpl();
        Command command = new CommandImpl(receiver);
        Invoker invoker = new Invoker(command);
        invoker.action();
    }
}
