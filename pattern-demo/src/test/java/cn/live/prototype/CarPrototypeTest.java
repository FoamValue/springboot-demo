package cn.live.prototype;

public class CarPrototypeTest {

    @org.junit.Test
    public void getCar() throws CloneNotSupportedException {
        CarPrototype.loadCar();
        Car bwm = CarPrototype.getCar("Bwm");
        System.out.println(bwm.toString());
        Car bwm02 = CarPrototype.getCar("Bwm");
        System.out.println(bwm02.toString());
        System.out.println(bwm == bwm02);
    }
}
