package cn.live.flyweight;

public class Card implements Play {

    private String name;

    public Card(String name) {
        this.name = name;
    }

    @Override
    public void play() {
        System.out.println("play " + name);
    }
}
