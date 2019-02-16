package shejimoshi.construct;

public class BuilderImpl implements Builder {

    private Model model = new Model();

    @Override
    public void buildPart1() {
        model.setP1("BuilderImpl buildPart1");
    }

    @Override
    public void buildPart2() {
        model.setP2("BuilderImpl buildPart2");
    }

    @Override
    public Model getModel() {
        return model;
    }
}
