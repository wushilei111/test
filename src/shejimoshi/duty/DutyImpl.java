package shejimoshi.duty;

public class DutyImpl extends Duty {
    @Override
    public void doSomething() {
        if(1==1){//判断是否满足处理条件满足就处理不满足就向后传递，在这里就用true
            System.out.println("处理请求");
            return;
        }
        if(next!=null){
            next.doSomething();//向后传递如果是有参数的要将参数也传递过去
        }
        //如果有返回值在这里返回null 即没有可以处理请求的对象
    }
}
