package cn.live;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;

public class ByteBuddyTest {

  @Test
  public void test1() throws InstantiationException, IllegalAccessException {
    Class<?> dynamicType = new ByteBuddy()
        .subclass(Object.class)
        .method(ElementMatchers.named("toString"))
        .intercept(FixedValue.value("Hello World!"))
        .make()
        .load(ByteBuddy.class.getClassLoader())
        .getLoaded();

    System.out.println(dynamicType.newInstance().toString());
    assertThat(dynamicType.newInstance().toString(), is("Hello World!"));
  }
  
  
}
