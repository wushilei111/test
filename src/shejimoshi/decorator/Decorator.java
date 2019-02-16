package shejimoshi.decorator;

public class Decorator implements InterFace {
    InterFace interFace;

    public Decorator(InterFace interFace) {
        this.interFace = interFace;
    }

    @Override
    public void simpel() {
        interFace.simpel();
    }
}
