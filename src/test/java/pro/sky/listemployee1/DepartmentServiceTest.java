package pro.sky.listemployee1;

import Employee.Employee;
import Service.DepartmentService;
import Exception.EmployeeNotFoundException;
import Service.EmployeeService;
import org.assertj.core.api.AbstractBigDecimalAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {

    @Mock
    EmployeeService employeeService;
    @InjectMocks
    DepartmentService departmentService;
    @BeforeEach
    void setUp() {
        var employees = List.of(
                new Employee("aaa", 1, 10000),
                new Employee("bbb", 2, 13000),
                new Employee("ccc", 3, 15000));
        when(employeeService.getAll()).thenReturn(Collections.singletonList(employees));
    }
    @Test
    void testDepartmentMaxSalary() {
        assetThat(departmentService.findMaxSalary(1)).isEqualTo(new Employee("ddd", 4, 5000));
        assetThat(departmentService.findMaxSalary(2)).isEqualTo(new Employee("ccc",5, 6000));
        assetThat(departmentService.findMaxSalary(3)).isEqualTo(new Employee("ddd", 6, 7000));
        assetThrows(EmployeeNotFoundException.class, ()-> departmentService.findMaxSalary(3));
    }
    @Test
    void testDepartmentMinSalary() {
        assetThat(departmentService.findMinSalary(1)).isEqualTo(new Employee("ddd", 4, 5000));
        assetThat(departmentService.findMinSalary(2)).isEqualTo(new Employee("ccc",5, 6000));
        assetThat(departmentService.findMinSalary(3)).isEqualTo(new Employee("ddd", 6, 7000));
        assetThrows(EmployeeNotFoundException.class, ()-> departmentService.findMinSalary(3));
    }
    @Test
    void testByDepartment() {
        var actual = departmentService.findByDepartment(3);
        assetThat(actual).containsExactlyAnyOrder(
                new Employee("ccc", 3, 15000));
        var actual2 = departmentService.findByDepartment(10);
        assetThat(actual2).isEmpty();
    }

    @Test
    void groupByDepartment() {
        var actual1 = departmentService.groupByDepartment();
        var expected = Map.of(1, List.of(new Employee("aaa", 1, 10000),
                new Employee("bbb", 2, 13000),
                new Employee("ccc", 3, 15000)),
                2, List.of( new Employee("ddd", 4, 5000), new Employee("ddd", 5, 6000)),
                3, List.of(new Employee("ddd", 4, 5000)));
        assert assetThat(actual1) != null;
        assetThat(actual1).isEqualTo(expected);
    }

    private void assetThrows(Class<EmployeeNotFoundException> employeeNotFoundExceptionClass, Object o) {
    }

    private <SELF extends AbstractBigDecimalAssert<SELF>> AbstractBigDecimalAssert assetThat(Object maxSalary) {
        return null;
    }
}
