package cn.live.bridge;

import cn.live.decorator.Cartoon;
import cn.live.decorator.Game;

public class WeekendScheduleTest {

    @org.junit.Test
    public void schedule() {
        WeekendBridge am =  new WeekendSchedule("上午，", new Cartoon());
        WeekendBridge pm =  new WeekendSchedule("下午，", new Game());

        am.enjoyBridge();
        pm.enjoyBridge();
    }
}
