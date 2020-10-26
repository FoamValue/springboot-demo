package cn.live.strategy;

public class PublicSaleStrategy implements SaleStrategy {
    @Override
    public double getRetailPrice(double tagPrice) {
        return tagPrice * 0.95D;
    }
}
