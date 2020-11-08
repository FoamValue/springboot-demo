package cn.live.bridge;

import cn.live.decorator.Weekend;

public abstract class WeekendBridge {

    protected Weekend weekend;

    protected WeekendBridge(Weekend weekend) {
        this.weekend = weekend;
    }

    public abstract void enjoyBridge();
}
