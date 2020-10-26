package cn.live.strategy;

public class CarShop {

    private SaleStrategy saleStrategy;

    private double tagPrice = 100000.00D;

    public CarShop(SaleStrategy saleStrategy) {
        this.saleStrategy = saleStrategy;
    }

    public void getPrice() {
        System.out.println(saleStrategy.getRetailPrice(tagPrice));
    }

}
