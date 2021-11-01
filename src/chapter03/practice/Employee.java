package chapter03.practice;

public class Employee {
    private String id;
    private String name;
    private Integer workHours;
    private Integer overTimeHours;
    private CalculatePayLogic payLogic;

    public Integer calculatePay() {
        return payLogic.calculate(workHours, overTimeHours);
    }
}
