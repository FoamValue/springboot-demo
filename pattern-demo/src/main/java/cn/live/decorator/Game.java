package cn.live.decorator;

public class Game implements Weekend {

    @Override
    public void enjoy() {
        System.out.println("三个房子三周目中。");
    }
}
