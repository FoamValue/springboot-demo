package cn.live.service.impl;

import org.springframework.stereotype.Service;

import cn.live.service.DemoService;

@Service
public class DemoServiceImpl implements DemoService {

  @Override
  public String hello(String name) {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return "Hello " + name + ", Welcome!";
  }
}
