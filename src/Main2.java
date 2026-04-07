class Employee {
    String name;
    double baseSalary;

    Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    double getSalary() {
        return baseSalary;
    }
}

class Manager extends Employee {
    double bonus;

    Manager(String name, double baseSalary, double bonus) {
        super(name, baseSalary);
        this.bonus = bonus;
    }

    @Override
    double getSalary() {
        return super.getSalary() + bonus;
    }
}

class Intern extends Employee {
    Intern(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    double getSalary() {
        return super.getSalary() * 0.5;
    }
}

public class Main2 {
    public static void main(String[] args) {
        Employee[] employees = new Employee[3];

        employees[0] = new Employee("Arun", 30000);
        employees[1] = new Manager("Meena", 50000, 10000);
        employees[2] = new Intern("Ravi", 20000);

        for (Employee e : employees) {
            System.out.println(e.name + " salary: " + e.getSalary());
        }
    }
}
