package cn.live;

import org.openjdk.btrace.core.annotations.BTrace;
import org.openjdk.btrace.core.annotations.Kind;
import org.openjdk.btrace.core.annotations.Location;
import org.openjdk.btrace.core.annotations.OnMethod;
import org.openjdk.btrace.core.annotations.Return;
import org.openjdk.btrace.core.types.AnyType;

@BTrace
public class BTraceMain {


  @OnMethod(clazz = "cn.live.controller.DemoController", method = "hello", location = @Location(Kind.RETURN))
  public void func(String params, @Return AnyType result) {
    
  }
}
