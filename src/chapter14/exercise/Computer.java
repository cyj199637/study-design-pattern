package chapter14.exercise;

import java.util.ArrayList;
import java.util.List;

public class Computer implements ComputerComponent {
    private List<ComputerComponent> components = new ArrayList<>();

    public void addComponent(ComputerComponent component) {
        components.add(component);
    }

    public void removeComponent(ComputerComponent component) {
        components.remove(component);
    }

    @Override
    public int getPrice() {
        return components.stream()
            .map(ComputerComponent::getPrice)
            .reduce(0, Integer::sum);
    }

    @Override
    public int getPower() {
        return components.stream()
            .map(ComputerComponent::getPower)
            .reduce(0, Integer::sum);
    }
}
