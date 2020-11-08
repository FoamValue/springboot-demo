package cn.live.facade;

import cn.live.decorator.Cartoon;
import cn.live.decorator.Game;
import cn.live.decorator.Weekend;

public class WeekendFacade {

    private Weekend cartoonWeekend;
    private Weekend gameWeekend;

    public WeekendFacade() {
        this.cartoonWeekend = new Cartoon();
        this.gameWeekend = new Game();
    }

    public void cartoonEnjoy() {
        cartoonWeekend.enjoy();
    }

    public void gameEnjoy() {
        gameWeekend.enjoy();
    }
}
