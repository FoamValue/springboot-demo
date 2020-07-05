package cn.live.kryo.utils;

import java.io.ByteArrayOutputStream;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.ByteBufferInput;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.util.Pool;

public class KryoPoolUtil {

  private static Pool<Kryo> kryoPool = new Pool<Kryo>(true, false, 8) {
    protected Kryo create() {
      Kryo kryo = new Kryo();
      kryo.setRegistrationRequired(false);
      kryo.setReferences(false);
      return kryo;
    }
  };

  public static byte[] serialize(Object object) {
    Kryo kryo = kryoPool.obtain();
    Output output = new Output(new ByteArrayOutputStream());
    try {
      kryo.writeObject(output, object);
      return output.getBuffer();
    } finally {
      kryoPool.free(kryo);
      output.close();
      output.flush();
    }
  }

  @SuppressWarnings("unchecked")
  public static <T> T deserialize(byte[] bytes, Class<?> type) {
    Kryo kryo = kryoPool.obtain();
    Input input = new Input(new ByteBufferInput(bytes));
    try {
      return (T) kryo.readObject(input, type);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    } finally {
      kryoPool.free(kryo);
      input.close();
    }
  }

}
