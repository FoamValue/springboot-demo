package cn.live.proxy;

public class UserDaoProxy implements IUserDao {

    private IUserDao target;

    public UserDaoProxy(IUserDao target) {
        this.target = target;
    }

    @Override
    public void say() {
        System.out.println("Proxy Begin");
        target.say();
        System.out.println("Proxy End");
    }
}
