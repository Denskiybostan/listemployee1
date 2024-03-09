package service;

import employee.Employee;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee findMaxSalary(int department) {
        employeeService.getAll().stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparingInt(employee::getSalary))
                .orElse(null);
        return null;
    }


    public Employee findMinSalary(int department) {
        return employeeService.getAll().stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparingInt(employee::getSalary))
                .orElse(null);
    }

    public Collection<Employee> findByDepartment(int department) {
        return employeeService.getAll().stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
    }
    public Map<Integer, List<Employee>> groupByDepartment() {
        Map<Integer, List<Employee>> map = new HashMap<>();
        for(Object employee : employeeService.getAll()){
            if(map.containsKey(employee.getDepartment())){
                var employeeByDept = map.get(employee.getDepartment());
                employeeByDept.add((Employee) employee);
            }else{
                List<Employee> emp = new ArrayList<>();
                emp.add((Employee) employee);
                map.put(employee.getDepartment(), emp);
            }
        }
        return employeeService.getAll().stream()
                .collect(Collectors.groupingBy(employee::getDepartment));

    }
}
