package cn.live.factory;

public class BenzFactory extends CarFactory {

    @Override
    public Car drive() {
        return new Benz();
    }
}
