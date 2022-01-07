package patterns.static_factory_and_singleton;

import patterns.fluent_interfaces.Employee;

public class MonthEmployee {
    private Employee employee;
    private String reason;
    private String currentMonth;
    private static MonthEmployee monthEmployee;

    private MonthEmployee(Employee employee, String reason, String currentMonth) {
        this.employee = employee;
        this.reason = reason;
        this.currentMonth = currentMonth;
    }

    private MonthEmployee(Employee employee, String reason) {
        this.employee = employee;
        this.reason = reason;
        this.currentMonth = "Not passed";
    }

    private MonthEmployee(Employee employee) {
        this.employee = employee;
        this.reason = "Not passed";
        this.currentMonth = "Not passed";
    }

    public static MonthEmployee create(Employee employee, String reason, String currentMonth) throws MonthEmployeeException {
        if (monthEmployee != null) {
            monthEmployee.setEmployee(employee);
            monthEmployee.setReason(reason);
            return monthEmployee;
        }

        if (validate(reason)) throw new MonthEmployeeException("Field reason must be filled!");
        if (validate(currentMonth)) throw new MonthEmployeeException("Field current month must be filled!");

        return monthEmployee = new MonthEmployee(employee, reason, currentMonth);
    }

    public static MonthEmployee createNoReason(Employee employee, String currentMonth) throws MonthEmployeeException {
        if (monthEmployee != null) {
            monthEmployee.setEmployee(employee);
            monthEmployee.setCurrentMonth(currentMonth);
            monthEmployee.setReason("Not passed");
            return monthEmployee;
        }

        if (validate(currentMonth)) throw new MonthEmployeeException("Field current month must be filled!");

        monthEmployee = new MonthEmployee(employee);
        monthEmployee.setCurrentMonth(currentMonth);
        return monthEmployee;
    }

    public static MonthEmployee createNoCurrentMonth(Employee employee, String reason) throws MonthEmployeeException {
        if (monthEmployee != null) {
            monthEmployee.setEmployee(employee);
            monthEmployee.setReason(reason);
            monthEmployee.setCurrentMonth("Not passed");
            return monthEmployee;
        }

        if (validate(reason)) throw new MonthEmployeeException("Field reason must be filled!");

        return monthEmployee = new MonthEmployee(employee, reason);
    }

    private static boolean validate(String reason) {
        return reason.isBlank() || reason.isEmpty();
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getCurrentMonth() {
        return currentMonth;
    }

    public void setCurrentMonth(String currentMonth) {
        this.currentMonth = currentMonth;
    }

    public static MonthEmployee getMonthEmployee() {
        return monthEmployee;
    }
}
