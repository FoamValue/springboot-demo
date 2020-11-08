package cn.live.adapter;

public class WeekendAdapter extends WeekendAdaptee implements WorkTarget {

    @Override
    public void working() {
        System.out.println("工作任务紧急，取消周末认真工作。");
    }
}
