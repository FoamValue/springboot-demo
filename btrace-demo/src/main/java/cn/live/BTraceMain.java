package cn.live;

import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.ProbeClassName;
import com.sun.btrace.annotations.ProbeMethodName;

@BTrace
public class BTraceMain {

  @OnMethod(clazz = "cn.live.controller.DemoController", method = "hello")
  public void func(@ProbeClassName String probeClass, @ProbeMethodName String probeMethod,
      long arg) {
    System.out.println("probeClass: " + probeClass);
    System.out.println("probeMethod: " + probeMethod);
    System.out.println("arg: " + arg);
  }
}
