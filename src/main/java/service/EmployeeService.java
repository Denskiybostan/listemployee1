package service;

import employee.Employee;
import exception.EmployeeAlreadyAddedException;
import exception.EmployeeStorageIsFullException;
import exception.WrongNameException;
import org.springframework.util.StringUtils;

import java.util.*;

import static javax.swing.plaf.synth.ColorType.MAX_COUNT;

public class EmployeeService {
    public Map<String, Employee> employees = new HashMap<>(MAX_COUNT);

    public String addEmployee(String firstName, String lastName, int salary, int departmentId) throws EmployeeAlreadyAddedException, EmployeeStorageIsFullException {
        if (StringUtils.isAlpha(firstName) || StringUtils.isAlpha(lastName)) {
            throw new WrongNameException("Имя и фамилия должны состоять только из букв");
        }
        if (employees.size() >= MAX_COUNT) {
            throw new EmployeeStorageIsFullException();
        }


        Employee employee = new Employee(StringUtils.capitalize(firstName), StringUtils.capitalize(lastName), salary, departmentId);
        var key = makeKey(firstName, lastName);
        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException();

        }


        public void removeEmployee (String firstName, String lastName){
            var key = makeKey(firstName, lastName);
            var removed = employees.remove(key);
            private static String makeKey (String firstName, String lastName){
                return (firstName + "_" + lastName).toLowerCase();
            }
        }
    }
}

