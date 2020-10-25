package cn.live.factory;

public class AudiFactory extends CarFactory {

    @Override
    public Car drive() {
        return new Audi();
    }
}
