package cn.live.flyweight;

public class CardFactoryTest {

    @org.junit.Test
    public void card() {
        for (int i=0; i<10; i++) {
            Card card = CardFactory.getCard("三个房子");
            card.play();
        }
    }
}
