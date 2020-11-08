package cn.live.facade;

public class WeekendFacadeTest {

    @org.junit.Test
    public void facade() {
        WeekendFacade facade = new WeekendFacade();
        facade.cartoonEnjoy();
        facade.gameEnjoy();
    }
}
