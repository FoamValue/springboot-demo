package cn.live.factory;

public class BwmFactory extends CarFactory {

    @Override
    public Car drive() {
        return new Bwm();
    }
}
