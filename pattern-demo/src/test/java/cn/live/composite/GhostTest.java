package cn.live.composite;

public class GhostTest {

    @org.junit.Test
    public void composite() {
        Ghost g0 = new Ghost("库洛洛·鲁西鲁");

        g0.add(new Ghost("信长·哈查马"));
        g0.add(new Ghost("飞坦"));
        g0.add(new Ghost("玛奇"));
        g0.add(new Ghost("柯特·揍敌客"));
        g0.add(new Ghost("芬克斯"));
        g0.add(new Ghost("侠客"));
        g0.add(new Ghost("富兰克林"));
        g0.add(new Ghost("小滴"));
        g0.add(new Ghost("派克诺妲"));
        g0.add(new Ghost("剥落列夫"));
        g0.add(new Ghost("伊路米·揍敌客"));
        g0.add(new Ghost("库哔"));

        System.out.println(g0);
        for (Ghost g : g0.getGhosts()) {
            System.out.println(g);
        }
    }
}
