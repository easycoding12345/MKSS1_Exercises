package model;

public abstract class Orderable {
    private String name;

    public Orderable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();

    public abstract void print();

    @Override
    public String toString() {
        return name;
    }
}
