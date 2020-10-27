package cn.live.strategy;

public class BossStrategy implements SaleStrategy {
    @Override
    public double getRetailPrice(double tagPrice) {
        return tagPrice * 0.80D;
    }
}
