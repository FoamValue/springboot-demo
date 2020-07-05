package cn.live.kryo.utils;

import java.io.ByteArrayOutputStream;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.ByteBufferInput;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.serializers.BeanSerializer;

import cn.live.kryo.dto.UserDTO;

public class KryoUtil {

  final static ThreadLocal<Kryo> kryoLocal = new ThreadLocal<Kryo>() {
    @Override
    protected Kryo initialValue() {
      Kryo kryo = new Kryo();
      kryo.setClassLoader(Thread.currentThread().getContextClassLoader());
      // 提前注册好需要处理的序列化对象
      kryo.register(String.class);
      kryo.register(UserDTO.class, new BeanSerializer<>(kryo, UserDTO.class));
      return kryo;
    }
  };

  public static byte[] serialize(Object object) {
    Output output = new Output(new ByteArrayOutputStream());
    try {
      kryoLocal.get().writeObject(output, object);
      return output.getBuffer();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    } finally {
      output.close();
      output.flush();
    }
  }

  @SuppressWarnings("unchecked")
  public static <T> T deserialize(byte[] bytes, Class<?> type) {
    Input input = new Input(new ByteBufferInput(bytes));
    try {
      Kryo kryo = kryoLocal.get();
      return (T) kryo.readObject(input, type);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    } finally {
      input.close();
    }
  }

}
