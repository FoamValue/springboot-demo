package cn.live.factory;

public class SimpleFactoryTest {

    @org.junit.Test
    public void drive() {
        Car car = SimpleFactory.drive("Bwm");
        if (car != null) {
            car.drive();
        }
        car = SimpleFactory.drive("BENZ");
        if (car != null) {
            car.drive();
        }
        car = SimpleFactory.drive("audi");
        if (car != null) {
            car.drive();
        }
    }
}
