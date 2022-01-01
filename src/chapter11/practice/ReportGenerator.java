package chapter11.practice;

import java.util.List;

public abstract class ReportGenerator {
    public String generate(List<Customer> customers) {
        List<Customer> target = makeTarget(customers);

        String report = customersCountReport(target.size());
        for (Customer c : target) {
            report += customersInfoReport(c);
        }
        report += customersPointSumReport();

        return report;
    }

    protected List<Customer> makeTarget(List<Customer> customers) {
        return customers;
    }

    protected String customersCountReport(int count) {
        return String.format("고객 수: %d명\n", count);
    }

    protected abstract String customersInfoReport(Customer customer);

    protected String customersPointSumReport() {
        return "";
    }
}
