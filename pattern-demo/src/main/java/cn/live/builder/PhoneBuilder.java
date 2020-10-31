package cn.live.builder;

public class PhoneBuilder {

    private Phone phone;

    public PhoneBuilder() {
        this.phone = new Phone();
    }

    public PhoneBuilder setName(String name) {
        phone.setName(name);
        return this;
    }

    public PhoneBuilder setScreen(String screen) {
        phone.setScreen(screen);
        return this;
    }

    public PhoneBuilder setCpu(String cpu) {
        phone.setCpu(cpu);
        return this;
    }

    public PhoneBuilder setCapacity(String capacity) {
        phone.setCapacity(capacity);
        return this;
    }

    public Phone build() {
        return phone;
    }
}
