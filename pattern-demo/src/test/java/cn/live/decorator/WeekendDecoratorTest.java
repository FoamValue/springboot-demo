package cn.live.decorator;

public class WeekendDecoratorTest {

    @org.junit.Test
    public void weekend() {
        Weekend cartoon = new Cartoon();
        cartoon.enjoy();
        Weekend game = new Game();
        game.enjoy();
        System.out.println("----- 使用适配器 -----");
        WeekendDecorator cartoonDecorator = new WeekendDecorator(cartoon);
        cartoonDecorator.enjoy();
        System.out.println("----- 使用适配器 -----");
        WeekendDecorator gameDecorator = new WeekendDecorator(game);
        gameDecorator.enjoy();
    }
}
