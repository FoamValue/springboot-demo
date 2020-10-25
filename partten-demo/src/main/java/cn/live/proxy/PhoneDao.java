package cn.live.proxy;

public class PhoneDao implements IPhoneDao {
    @Override
    public void buy() {
        System.out.println("Buy IPhone 12 Pro Max!!!");
        System.out.println("No");
        System.out.println("Buy IPhone Xr ?");
        System.out.println("OK, It's good.");
    }
}
