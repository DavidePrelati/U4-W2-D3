package entities;

import java.util.Random;

public class Customer {

    private String name;
    private Long id;
    private Integer tier;

    public Customer(String name, Integer tier) {
        this.name = name;
        this.id = randomId();
        this.tier = tier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTier() {
        return tier;
    }

    public void setTier(Integer tier) {
        this.tier = tier;
    }

    private Long randomId() {
        return new Random().nextLong();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", tier=" + tier +
                '}';
    }
}
