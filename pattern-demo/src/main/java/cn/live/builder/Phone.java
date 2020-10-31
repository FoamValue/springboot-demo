package cn.live.builder;

public class Phone {
    private String name;
    private String screen;
    private String cpu;
    private String capacity;

    public Phone() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return String.format("Phone(name: %s,screen: %s,cpu: %s, capacity: %s)",
                this.name, this.screen, this.cpu, this.capacity);
    }
}
