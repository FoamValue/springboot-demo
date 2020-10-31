package cn.live.strategy;

public class CarShopTest {

    @org.junit.Test
    public void getPrice() {
        SaleStrategy strategy = new PublicSaleStrategy();
        CarShop car = new CarShop(strategy);
        car.getPrice();
        strategy = new SuperSaleStrategy();
        car = new CarShop(strategy);
        car.getPrice();
        strategy = new BossStrategy();
        car = new CarShop(strategy);
        car.getPrice();
    }
}
