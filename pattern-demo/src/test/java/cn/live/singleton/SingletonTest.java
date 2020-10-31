package cn.live.singleton;

public class SingletonTest {

    @org.junit.Test
    public void getInstace() {
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton.toString());
        Singleton singleton02 = Singleton.getInstance();
        System.out.println(singleton02.toString());
        Singleton singleton03 = Singleton.getInstance();
        System.out.println(singleton03.toString());

        System.out.println(singleton == singleton02);
        System.out.println(singleton02 == singleton03);
    }
}
