package shejimoshi.proxy;

public class Attorney {
    Accuser accuser;

    public Attorney(Accuser accuser) {
        this.accuser = accuser;
    }

    public void prosecute(){
        accuser.prosecute();
    }
}
