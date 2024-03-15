package service;

import employee.Employee;
import exception.EmployeeAlreadyAddedException;
import exception.EmployeeNotFoundException;
import exception.EmployeeStorageIsFullException;
import exception.WrongNameException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;


import java.util.*;
import java.util.stream.Collectors;

import static javax.swing.plaf.synth.ColorType.MAX_COUNT;
@Service
public class EmployeeService {
    private static final int MAX_COUNT = 10;
    public static final Map<String, Employee> employees = new HashMap<>(MAX_COUNT);

    public void addEmployee(String firstName, String lastName, int salary, int departmentId) throws EmployeeAlreadyAddedException {
        checkLetters(firstName, lastName);
        if (!StringUtils.isAlpha(firstName) || !StringUtils.isAlpha(lastName)) {
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
        employees.put(key, employee);
    }

    public void removeEmployee(String firstName, String lastName) throws EmployeeNotFoundException {
        checkLetters(firstName, lastName);
        var key = makeKey(firstName, lastName);
        var removed = employees.remove(key);
        if (removed == null) {
            throw new EmployeeNotFoundException();
        }
    }

    public Employee find(String firstname, String lastName)  {
        checkLetters(firstname,lastName);
        var key = makeKey(firstname, lastName);
        var employee = employees.get(key);
        if (employee != null) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }
    public Collection<Employee> getAll() {
        return Collections.unmodifiableCollection(employees.values());
    }
    private static String makeKey(String firstName, String lastName) {
        return (firstName + "_" + lastName).toLowerCase();
    }
    private static void checkLetters(String... words) {
        for (String word : words) {
            if (!StringUtils.isAlpha(word)) {
                throw new WrongNameException("Name of last name must contain only letters");
        }
        }
    }
}








