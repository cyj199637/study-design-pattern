package chapter11.practice;

public class SimpleReportGenerator extends ReportGenerator {

    @Override
    protected String customersInfoReport(Customer customer) {
        return String.format("%s: %d\n", customer.getName(), customer.getPoint());
    }
}
