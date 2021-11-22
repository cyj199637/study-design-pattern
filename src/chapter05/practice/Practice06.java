package chapter05.practice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;

public class Practice06 {
}

class Sale {
    private ArrayList<Item> items = new ArrayList<>();
    private Printable printer;

    public void printReceipt() {
        StringBuffer buf = new StringBuffer();
        for (Item item : items) {
            buf.append(item.getName());
            buf.append(item.getPrice());
        }
        printer.print(buf.toString());
    }

    public void add(Item item) {
        items.add(item);
    }

    public void changePrinter(Printable printer) {
        this.printer = printer;
    }
}

class Item {
    private String name;
    private BigDecimal price;

    public Item(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}

interface Printable {
    void print(String target);
}

class HD108ReceiptPrinter implements Printable {
    public void print(String target) {
        System.out.println(target);
    }
}