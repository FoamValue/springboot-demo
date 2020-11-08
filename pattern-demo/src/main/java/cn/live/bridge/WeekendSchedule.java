package cn.live.bridge;

import cn.live.decorator.Weekend;

public class WeekendSchedule extends WeekendBridge {

    private String time;

    public WeekendSchedule(String time, Weekend weekend) {
        super(weekend);
        this.time = time;
    }

    @Override
    public void enjoyBridge() {
        System.out.print(time);
        weekend.enjoy();
    }
}
