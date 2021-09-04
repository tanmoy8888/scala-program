package com.test.java;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeFlatMap {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("ABC");
        list.add("DEF");
        Employee emp1 = new Employee(1, list, 1);
        Employee emp2 = new Employee(2, list, 1);
        Employee emp3 = new Employee(3, list,2);
        Employee emp4 = new Employee(4, list,3);
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);
        employeeList.add(emp4);

        // Intention to collect the records as List<String>

        List<String> collect = employeeList.stream()
                .map(Employee::getPhoneNumber)
                .flatMap(List::stream)
                .collect(Collectors.toList());

        System.out.println(collect);

        employeeList.stream()
                .collect(Collectors.
                        groupingBy(e -> e.getManagerId(),
                                Collectors.counting()))
                                   .forEach((id,count)->{
                                        System.out.println("Managers Id is "+id+", Total Employee count "+count);
                                   });

        // Same like above using , just putting the values in a HashMap

        Map<Integer, Long> map = employeeList.stream()
                .collect(Collectors.
                        groupingBy(e -> e.getManagerId(),
                                Collectors.counting()));
        System.out.println("Printing Managers Map , with count :: "+map);

    }
}
