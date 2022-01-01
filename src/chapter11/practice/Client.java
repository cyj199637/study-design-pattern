package chapter11.practice;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();

        customers.add(new Customer("aaa", 150));
        customers.add(new Customer("bbb", 350));
        customers.add(new Customer("ccc", 50));
        customers.add(new Customer("ddd", 450));
        customers.add(new Customer("eee", 550));

        ReportGenerator reportGenerator = new ComplexReportGenerator();
        System.out.println(reportGenerator.generate(customers));
    }
}
