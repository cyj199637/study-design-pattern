package chapter03.practice;

import java.util.ArrayList;
import java.util.List;

public class PayrollManager {
    private List<Employee> employees = new ArrayList<>();
    private Printable print;

    public PayrollManager(List<Employee> employees, Printable print) {
        this.employees = employees;
        this.print = print;
    }

    public void writeEmployeePay() {
        employees.stream().forEach(
            employee -> {print.print(employee.calculatePay());}
        );
    }
}
