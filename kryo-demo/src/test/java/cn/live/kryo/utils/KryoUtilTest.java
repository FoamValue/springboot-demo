package cn.live.kryo.utils;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.ByteBufferInput;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.serializers.BeanSerializer;

import cn.live.kryo.dto.UserDTO;

public class KryoUtilTest {
  private static  Kryo kryo = new Kryo();

  public class CallableDemo implements Callable<Boolean> {

    private int i;

    public CallableDemo(int i) {
      // 拆分后需要处理的业务数据
      this.i = i;
    }

    @Override
    public Boolean call() throws Exception {
      Object object = "鑫姐: 周末福利中！";
      byte[] bt = KryoPoolUtil.serialize(i + "," + object);
      String nb = KryoPoolUtil.deserialize(bt, String.class);
      
      
     
//      kryo.setClassLoader(Thread.currentThread().getContextClassLoader());
//      kryo.register(String.class);
//      kryo.register(UserDTO.class, new BeanSerializer<>(kryo, UserDTO.class));
//      
//      Output output = new Output(new ByteArrayOutputStream());
//      kryo.writeObject(output, i + "," + object);
//      byte[] bt = output.getBuffer();
//      
//      Input input = new Input(new ByteBufferInput(bt));
//      String nb =  (String) kryo.readObject(input, String.class);
//      
      System.out.println(i + "," + nb);
      return true;
    }
  }

  public static void main(String[] args) {
    // 准备10个线程的线程组
    ExecutorService service = Executors.newFixedThreadPool(3);
    List<Future<Boolean>> rst = new ArrayList<>();

    for (int i = 0; i < 100; i++) {
      Future<Boolean> future = service.submit(new KryoUtilTest().new CallableDemo(i));
      rst.add(future);
    }
    service.shutdown();
  }
}
