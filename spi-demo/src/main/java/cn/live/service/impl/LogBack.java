package cn.live.service.impl;

import cn.live.service.Log;

public class LogBack implements Log {
    @Override
    public void log(String msg) {
        System.out.println(String.format("LogBack: %s", msg));
    }
}
