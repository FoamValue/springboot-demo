package cn.live;

import java.lang.instrument.Instrumentation;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.DynamicType.Builder;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaModule;

public class AgentDemo {

  /**
   * premain 重载方法.
   * 
   * @param agentArgs -javaagent 命令携带的参数。
   * @param inst      操作类定义的相关方法
   * @throws Exception 异常堆栈
   */
  public static void premain(String agentArgs, Instrumentation inst) throws Exception {

    AgentBuilder.Transformer transformer = new AgentBuilder.Transformer() {

      @Override
      public Builder<?> transform(Builder<?> arg0, TypeDescription arg1, ClassLoader arg2,
          JavaModule arg3) {
        return arg0.method(ElementMatchers.any())
            .intercept(MethodDelegation.to(TimeInterceptor.class));
      }
    };

    AgentBuilder.Listener listener = new AgentBuilder.Listener() {

      @Override
      public void onComplete(String arg0, ClassLoader arg1, JavaModule arg2, boolean arg3) {

      }

      @Override
      public void onDiscovery(String arg0, ClassLoader arg1, JavaModule arg2, boolean arg3) {
      }

      @Override
      public void onError(String arg0, ClassLoader arg1, JavaModule arg2, boolean arg3,
          Throwable arg4) {
      }

      @Override
      public void onIgnored(TypeDescription arg0, ClassLoader arg1, JavaModule arg2, boolean arg3) {
      }

      @Override
      public void onTransformation(TypeDescription arg0, ClassLoader arg1, JavaModule arg2,
          boolean arg3, DynamicType arg4) {
      }
    };

    new AgentBuilder.Default().type(ElementMatchers.any()).transform(transformer).with(listener)
        .installOn(inst);
  }
}
