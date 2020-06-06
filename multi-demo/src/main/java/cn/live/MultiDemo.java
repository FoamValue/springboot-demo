package cn.live;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 多线程
 * 
 * @author chenxinjie
 *
 */
public class MultiDemo {

  public void test() {
    // 准备10个线程的线程组
    ExecutorService service = Executors.newFixedThreadPool(10);
    List<Future<Boolean>> rst = new ArrayList<>();
    
    // 业务数据准备，省略。。。
    // 将业务数据分100分，放入线程组中。
    for (int i = 0; i < 100; i++) {
      Future<Boolean> future = service.submit(new CallableDemo(i));
      rst.add(future);
    }
    service.shutdown();
    
    // 线程组处理结果处理
    Boolean flag;
    for (Future<Boolean> future : rst) {
      try {
        try {
          flag = future.get(1L, TimeUnit.SECONDS);
          if (flag == null || !flag) {
            System.out.println("处理失败 flag: " + flag);
            // 业务数据补偿逻辑
          } else {
            System.out.println("处理成功 flag: " + flag);
          }
        } catch (TimeoutException e) {
          e.printStackTrace();
        }
      } catch (InterruptedException | ExecutionException e) {
        e.printStackTrace();
      }
    }

  }
}
