package Service;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService<Employee> {
    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee findMaxSalary(int department) {
        employeeService.getAll().stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
        return null;
    }


    public Employee findMinSalary(int department) {
        return employeeService.getAll().stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    public Collection<Employee> findByDepartment(int department) {
        return employeeService.getAll().stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
    }
    public Map<Integer, List<Employee>> groupByDepartment() {
        Map<Integer, List<Employee>> map = new HashMap<>();
        for(Employee employee : employeeService.getAll()){
            if(map.containsKey(employee.getDepartment())){
                var employeeByDept = map.get(employee.getDepartment());
                employeeByDept.add(employee);
            }else{
                List<Employee> emp = new ArrayList<>();
                emp.add(employee);
                map.put(employee.getDepartment(), emp);
            }

        }

        return employeeService.getAll().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

    }
}
