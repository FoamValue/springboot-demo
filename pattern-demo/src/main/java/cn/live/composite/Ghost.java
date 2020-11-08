package cn.live.composite;

import java.util.ArrayList;
import java.util.List;

public class Ghost {

    private String name;
    private List<Ghost> ghosts;

    public Ghost(String name) {
        this.name = name;
        ghosts = new ArrayList<>();
    }

    public void add(Ghost ghost) {
        this.ghosts.add(ghost);
    }

    public void remove(Ghost ghost) {
        this.ghosts.remove(ghost);
    }

    public String getName() {
        return name;
    }

    public List<Ghost> getGhosts() {
        return ghosts;
    }

    @Override
    public String toString() {
        return "Ghost{" +
                "name='" + name + '\'' +
                '}';
    }
}
