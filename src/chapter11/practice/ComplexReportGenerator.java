package chapter11.practice;

import java.util.List;
import java.util.stream.Collectors;

public class ComplexReportGenerator extends ReportGenerator {
    private static final int MIN = 100;
    private int targetCustomersPointSum = 0;

    @Override
    protected List<Customer> makeTarget(List<Customer> customers) {
        List<Customer> target = customers.stream()
            .filter(customer -> customer.getPoint() >= MIN)
            .collect(Collectors.toList());
        setTargetCustomersPointSum(target);

        return target;
    }

    private void setTargetCustomersPointSum(List<Customer> target) {
        this.targetCustomersPointSum = target.stream()
            .map(Customer::getPoint)
            .reduce(0, Integer::sum);
    }

    @Override
    protected String customersCountReport(int count) {
        return String.format("고객 수: %d명 입니다.\n", count);
    }

    @Override
    protected String customersInfoReport(Customer customer) {
        return String.format("%d: %s\n", customer.getPoint(), customer.getName());
    }

    @Override
    protected String customersPointSumReport() {
        return String.format("점수 합계: %d", targetCustomersPointSum);
    }
}
