package cn.live.builder;

public class PhoneBuilderTest {

    @org.junit.Test
    public void phone() {
        Phone phone12 = new PhoneBuilder()
                .setName("iphone 12")
                .setScreen("6.1 英寸 (对角线) OLED 全面屏")
                .setCpu("A14 仿生芯片")
                .setCapacity("256GB")
                .build();
        System.out.println(phone12.toString());

        Phone phoneXS = new PhoneBuilder()
                .setName("iphone XS")
                .setScreen("5.8 英寸 (对角线) OLED 全面屏")
                .setCpu("A12 仿生芯片")
                .setCapacity("256GB")
                .build();
        System.out.println(phoneXS.toString());

    }
}
