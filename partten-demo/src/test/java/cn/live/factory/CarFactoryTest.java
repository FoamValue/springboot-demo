package cn.live.factory;

public class CarFactoryTest {

    @org.junit.Test
    public void drive() {
        CarFactory factory = new BwmFactory();
        Car car = factory.drive();
        if (car != null) {
            car.drive();
        }
        factory = new BenzFactory();
        car = factory.drive();
        if (car != null) {
            car.drive();
        }
        factory = new AudiFactory();
        car = factory.drive();
        if (car != null) {
            car.drive();
        }
    }
}
