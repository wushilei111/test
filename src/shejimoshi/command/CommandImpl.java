package shejimoshi.command;

public class CommandImpl implements Command {
    private Receiver receiver;

    public CommandImpl(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.avtion();
    }
}
