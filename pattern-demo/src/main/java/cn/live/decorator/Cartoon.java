package cn.live.decorator;

public class Cartoon implements Weekend {

    @Override
    public void enjoy() {
        System.out.println("全职猎人追剧中。");
    }
}
