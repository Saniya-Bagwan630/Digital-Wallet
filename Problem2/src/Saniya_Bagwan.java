import java.util.*;

abstract class Employee {
    private int empId;
    private String name;
    private String email;
    private String role;

    public Employee(int empId, String name, String email, String role) {
        this.empId = empId;
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public int getEmpId() { return empId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getRole() { return role; }

    public void setRole(String role) { this.role = role; }

    // Abstract method
    public abstract double calculateSalary();

    public void display() {
        System.out.println("ID: " + empId + ", Name: " + name +
                ", Email: " + email + ", Role: " + role +
                ", Salary: " + calculateSalary());
    }
}

class PermanentEmployee extends Employee {
    private double baseSalary;
    private double bonus;

    public PermanentEmployee(int id, String name, String email, String role,
                             double baseSalary, double bonus) {
        super(id, name, email, role);
        this.baseSalary = baseSalary;
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + bonus;
    }
}

class ContractEmployee extends Employee {
    private double hourlyPay;
    private int hoursWorked;

    public ContractEmployee(int id, String name, String email, String role,
                            double hourlyPay, int hoursWorked) {
        super(id, name, email, role);
        this.hourlyPay = hourlyPay;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hourlyPay * hoursWorked;
    }
}

class InternEmployee extends Employee {
    private double stipend;
    private double performanceBonus;

    public InternEmployee(int id, String name, String email, String role,
                          double stipend, double performanceBonus) {
        super(id, name, email, role);
        this.stipend = stipend;
        this.performanceBonus = performanceBonus;
    }

    @Override
    public double calculateSalary() {
        return stipend + performanceBonus;
    }
}

// Main Class
public class Saniya_Bagwan {

    static Map<Integer, Employee> empMap = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== SMART HR SYSTEM =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee Role");
            System.out.println("5. Delete Employee");
            System.out.println("6. Display Unique Roles");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> displayEmployees();
                case 3 -> searchEmployee();
                case 4 -> updateEmployee();
                case 5 -> deleteEmployee();
                case 6 -> displayRoles();
                case 7 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }

        } while (choice != 7);
    }

    static void addEmployee() {
        System.out.println("\nSelect Type: 1.Permanent 2.Contract 3.Intern");
        int type = sc.nextInt();

        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Role: ");
        String role = sc.nextLine();

        Employee emp = null;

        switch (type) {
            case 1 -> {
                System.out.print("Base Salary: ");
                double salary = sc.nextDouble();
                System.out.print("Bonus: ");
                double bonus = sc.nextDouble();
                emp = new PermanentEmployee(id, name, email, role, salary, bonus);
            }
            case 2 -> {
                System.out.print("Hourly Pay: ");
                double pay = sc.nextDouble();
                System.out.print("Hours Worked: ");
                int hours = sc.nextInt();
                emp = new ContractEmployee(id, name, email, role, pay, hours);
            }
            case 3 -> {
                System.out.print("Stipend: ");
                double stipend = sc.nextDouble();
                System.out.print("Performance Bonus: ");
                double bonus = sc.nextDouble();
                emp = new InternEmployee(id, name, email, role, stipend, bonus);
            }
            default -> System.out.println("Invalid type!");
        }

        if (emp != null) {
            empMap.put(id, emp);
            System.out.println("Employee added successfully!");
        }
    }

    // Display Employees
    static void displayEmployees() {
        List<Employee> list = new ArrayList<>(empMap.values());

        if (list.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        for (Employee e : list) {
            e.display();
        }
    }

    // Search Employee
    static void searchEmployee() {
        System.out.println("Search by: 1.ID 2.Name");
        int ch = sc.nextInt();
        sc.nextLine();

        if (ch == 1) {
            System.out.print("Enter ID: ");
            int id = sc.nextInt();

            Employee e = empMap.get(id);
            if (e != null) e.display();
            else System.out.println("Not found!");

        } else if (ch == 2) {
            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            boolean found = false;
            for (Employee e : empMap.values()) {
                if (e.getName().equalsIgnoreCase(name)) {
                    e.display();
                    found = true;
                }
            }
            if (!found) System.out.println("Not found!");
        }
    }

    // Update Employee
    static void updateEmployee() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        Employee e = empMap.get(id);
        if (e != null) {
            System.out.print("Enter new role: ");
            String role = sc.nextLine();
            e.setRole(role);
            System.out.println("Updated successfully!");
        } else {
            System.out.println("Employee not found!");
        }
    }

    // Delete Employee
    static void deleteEmployee() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        if (empMap.remove(id) != null) {
            System.out.println("Deleted successfully!");
        } else {
            System.out.println("Employee not found!");
        }
    }

    // Display Unique Roles
    static void displayRoles() {
        Set<String> roles = new HashSet<>();

        for (Employee e : empMap.values()) {
            roles.add(e.getRole());
        }

        System.out.println("Unique Roles: " + roles);
    }
}