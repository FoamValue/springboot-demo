package cn.live;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;
import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.SuperCall;

public class TimeInterceptor {

  /**
   * 拦截器.
   * 
   * @param method   方法对象
   * @param callable 回调函数对象
   * @throws Exception 异常堆栈
   */
  @RuntimeType
  public static Object intercept(@Origin Method method, @SuperCall Callable<?> callable)
      throws Exception {
    long start = System.currentTimeMillis();
    try {
      return callable.call();
    } finally {
      System.out.println(method + " hook :" + (System.currentTimeMillis() - start) + "ms");
    }
  }
}
