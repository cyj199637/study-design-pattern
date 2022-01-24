package chapter14.practice;

import java.util.stream.IntStream;

public class File extends Element {
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void print() {
        IntStream.range(0, depth)
            .forEach(i -> System.out.print("\t"));

        System.out.println("[File] " + name + ", Size: " + size);
    }
}
