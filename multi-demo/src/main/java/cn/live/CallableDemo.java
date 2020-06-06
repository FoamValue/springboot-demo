package cn.live;

import java.util.concurrent.Callable;

public class CallableDemo implements Callable<Boolean> {

  private int i;

  public CallableDemo(int i) {
    // 拆分后需要处理的业务数据
    this.i = i;
  }

  @Override
  public Boolean call() throws Exception {
    // 业务数据处理逻辑
    Thread.sleep(3000L);
    System.out.println(Thread.currentThread().getName() + " i: " + i);
    return true;
  }
}
