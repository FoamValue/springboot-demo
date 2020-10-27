package cn.live.factory;

import org.apache.commons.lang3.StringUtils;

public class SimpleFactory {

    public static Car drive(String carType) {
        if (StringUtils.isBlank(carType)) {
            throw new RuntimeException("carType can not be empty.");
        }
        Car car = null;
        switch (carType.toLowerCase()) {
            case "bwm":
                car = new Bwm();
                break;
            case "benz":
                car = new Benz();
                break;
            case "audi":
                car = new Audi();
                break;
            default:
                throw new RuntimeException("invalid data.");
        }
        return car;
    }
}
