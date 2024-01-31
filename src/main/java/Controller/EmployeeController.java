package Controller;

import Service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    public final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @GetMapping("/max-salary")
    public Employee max(@RequestParam int department) {
        return service.findMaxSalary(department);
    }

    @GetMapping(value = "all", params = {"DepartmentId"})
    public Collection<Employee> findByDepartment(@RequestParam int departmentId) {
        return service.findByDepartment(departmentId);
    }

    @GetMapping("all")
    public Map<Integer, List<Employee>> groupByDepartment() {
        return service.groupByDepartment();

    }
}
