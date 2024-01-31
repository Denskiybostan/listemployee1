package Employee;

import java.util.Objects;

public class Employee {
    public class Employee {
        private String nameEmployee;
        private int department;
        private int salary;
        private int numberId;

        public Employee(String nameEmployee, int department, int salary) {
            this.nameEmployee = nameEmployee;
            this.department = department;
            this.salary = salary;
            numberId = new CounterId().getId();
        }

        public void CounterId() {
            int CounterId = 0;
            numberId = CounterId;
            CounterId = 0;
            this.numberId = CounterId++;
        }

        public String getNameEmployee() {
            return this.nameEmployee;
        }

        public int getDepartment() {
            return this.department;
        }

        public int getSalary() {
            return this.salary;
        }

        public int getNumberId() {
            return this.numberId;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }

        public void setDepartment(int department) {
            this.department = department;
        }


        @Override
        public String toString() {
            return "Employee{" +
                    "nameEmployee='" + nameEmployee + '\'' +
                    ", departament=" + department +
                    ", salary=" + salary +
                    ", numberId=" + numberId +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Employee employee = (Employee) o;
            return department == employee.department && salary == employee.salary && numberId == employee.numberId && Objects.equals(nameEmployee, employee.nameEmployee);
        }

        @Override
        public int hashCode() {
            return Objects.hash(nameEmployee, department, salary, numberId);
        }
    }
}
