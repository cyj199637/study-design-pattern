package chapter14.practice;

public abstract class Element {
    protected String name;
    protected int depth;

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public String getName() {
        return name;
    }

    public abstract int getSize();

    public abstract void print();
}
