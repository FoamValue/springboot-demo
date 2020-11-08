package cn.live.flyweight;

import java.util.HashMap;

public class CardFactory {

    private static HashMap<String, Card> cards = new HashMap<>();

    public static Card getCard(String name) {
        Card card = cards.get(name);

        if (card == null) {
            card = new Card(name);
            cards.put(name, card);
            System.out.println("创建对象，name：" + name);
        }
        return card;
    }
}
