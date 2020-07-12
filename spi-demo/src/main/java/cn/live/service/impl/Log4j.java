package cn.live.service.impl;

import cn.live.service.Log;

public class Log4j implements Log {

    @Override
    public void log(String msg) {
        System.out.println(String.format("Log4j: %s", msg));
    }
}
