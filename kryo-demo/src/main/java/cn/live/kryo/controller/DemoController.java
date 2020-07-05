package cn.live.kryo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.live.kryo.dto.UserDTO;
import cn.live.kryo.utils.KryoUtil;

@RestController
public class DemoController {

  @GetMapping("/demo/hello")
  public String hello() {
    Object object = "周末刷剧啊，鑫姐！";
    byte[] bt = KryoUtil.serialize(object);
    String nb = KryoUtil.deserialize(bt, String.class);
    System.out.println(nb);
    
    UserDTO user = new UserDTO("鑫姐", "周末福利中");
    byte[] nbt = KryoUtil.serialize(user);
    UserDTO nnb = KryoUtil.deserialize(nbt, UserDTO.class);
    System.out.println(nnb.toString());
    
    return nnb.toString();
  }
}
