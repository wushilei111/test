package shejimoshi.facade;

public class PowerButton {
    CPU cpu;
    Disk disk;
    Memory memory;
    public PowerButton(){
        cpu = new CPU();
        disk = new Disk();
        memory = new Memory();
    }
    public void start() {
        System.out.println("开始启动电脑");
        cpu.start();
        disk.start();
        memory.start();
        System.out.println("成功启动电脑");
    }

    public void shutDown() {
        System.out.println("开始关闭电脑");
        cpu.shutDown();
        disk.shutDown();
        memory.shutDown();
        System.out.println("成功关闭电脑");
    }
}
