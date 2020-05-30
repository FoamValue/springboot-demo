package cn.live.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.live.service.DemoService;

@RestController
public class DemoController {

  @Autowired
  private DemoService demoService;
  
  @GetMapping("/demo/zm")
  public String a() {
    return "周末刷剧啊，鑫姐！";
  }

  @GetMapping("/demo/hello")
  public String hello() {
    String rs = demoService.hello("鑫姐!");
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return rs;
  }
}
