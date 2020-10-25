package cn.live.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class UserDaoTest {
    @org.junit.Test
    public void say() {
        UserDao userDao = new UserDao();
        UserDaoProxy proxy = new UserDaoProxy(userDao);
        proxy.say();
    }

    @org.junit.Test
    public void say02() {
        UserDao userDao = new UserDao();
        InvocationHandler handler = new ProxyHandler(userDao);
        Class<?> cls = userDao.getClass();
        /**
         * loader 类加载器
         * interfaces 实现接口
         * handler InvocationHandler
         * */
        IUserDao iUserDao = (IUserDao) Proxy.newProxyInstance(cls.getClassLoader(),
                cls.getInterfaces(), handler);
        iUserDao.say();

    }
}
