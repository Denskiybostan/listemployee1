package employee;

import java.util.Objects;

public class Employee {

        private final String firstName;
        private final String lastName;
        private int department;
        private int salary;
        private int numberId;

        public Employee(String firstName, String lastName, int department, int salary) {
            this.firstName = firstName;
            this.lastName = lastName;
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

        public String getFirstName() {
            return this.firstName;
        }
        public String getLastName() {
        return this.lastName;
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
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                ", numberId=" + numberId +
                '}';
    }

    @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Employee employee = (Employee) o;
            return department == employee.department && salary == employee.salary && numberId == employee.numberId && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(firstName, lastName, department, salary, numberId);
        }
    }

