package cn.live;

public class MainDemo {

  public static void main(String[] args) throws Exception {
    Thread.sleep(1000);
    MainTest test = new MainTest();
    test.fun();
    Thread.sleep(3000);
    System.out.println("MainDemo end");
  }
}
