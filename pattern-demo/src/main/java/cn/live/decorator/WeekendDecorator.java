package cn.live.decorator;

public class WeekendDecorator implements Weekend {

    private Weekend weekend;

    public WeekendDecorator(Weekend weekend) {
        this.weekend = weekend;
    }

    @Override
    public void enjoy() {
        weekend.enjoy();
        System.out.println("晚上学习3小时。");
    }
}
