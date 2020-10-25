package cn.live.proxy;

public class UserDao implements  IUserDao {

    @Override
    public void say() {
        System.out.println("Hi, enjoy 1024.");
    }
}
