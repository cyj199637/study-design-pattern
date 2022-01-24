package chapter14.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Directory extends Element {
    private List<Element> entries = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public void addEntry(Element entry) {
        entries.add(entry);
        entry.setDepth(depth + 1);
    }

    public void removeEntry(Element entry) {
        entries.remove(entry);
    }

    @Override
    public int getSize() {
        return entries.stream()
            .map(Element::getSize)
            .reduce(0, Integer::sum);
    }

    @Override
    public void print() {
        IntStream.range(0, depth)
            .forEach(i -> System.out.print("\t"));

        System.out.println("[Directory] " + name + ", Size: " + getSize());

        entries.forEach(Element::print);
    }
}
