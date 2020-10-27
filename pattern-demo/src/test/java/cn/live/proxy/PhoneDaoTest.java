package cn.live.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class PhoneDaoTest {

    @org.junit.Test
    public void Buy() {
        PhoneDao phoneDao = new PhoneDao();
        InvocationHandler handler = new ProxyHandler(phoneDao);
        Class<?> cls = phoneDao.getClass();
        /**
         * loader 类加载器
         * interfaces 实现接口
         * handler InvocationHandler
         * */
        IPhoneDao iPhoneDao = (IPhoneDao) Proxy.newProxyInstance(cls.getClassLoader(),
                cls.getInterfaces(), handler);
        iPhoneDao.buy();

    }
}
