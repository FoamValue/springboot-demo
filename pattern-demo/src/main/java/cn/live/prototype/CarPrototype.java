package cn.live.prototype;

import java.util.HashMap;
import java.util.Map;

public class CarPrototype {

    private static Map<String, Car> cars = new HashMap<>();

    public static void loadCar() {
        Car benz = new Benz();
        benz.setName("梅赛德斯");
        cars.put("Benz", benz);
        Car bwm = new Bwm();
        bwm.setName("宝马");
        cars.put("Bwm", bwm);
    }

    public static Car getCar(String brand) throws CloneNotSupportedException {
        Car car = cars.get(brand);
        return (Car)car.clone();
    }
}
