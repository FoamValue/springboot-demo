package cn.live.strategy;

public class SuperSaleStrategy implements SaleStrategy {
    @Override
    public double getRetailPrice(double tagPrice) {
        return tagPrice * 0.88D;
    }
}
