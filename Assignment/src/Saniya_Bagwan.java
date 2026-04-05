import java.util.HashMap;
import java.util.Scanner;

abstract class Student{
    private int studentId;
    private String name;
    private String course;
    private float baseFee;

    public Student(int studentId, String name, String course, float baseFee){
        this.studentId=studentId;
        this.name=name;
        this.course=course;
        this.baseFee=baseFee;
    };

    void display(){
        System.out.println("Student ID: "+studentId);
        System.out.println("Student Name: "+name);
        System.out.println("Student Course: "+course);
        System.out.println("Student BaseFee: "+baseFee);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getBaseFee() {
        return baseFee;
    }
    public void setBaseFee(float baseFee) {
        this.baseFee = baseFee;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public abstract double calculateFee();
}

class RegularStudent extends Student{

    public RegularStudent(int studentId, String name, String course, float baseFee){
        super(studentId,name,course,baseFee);
    }
    public double calculateFee(){
        return getBaseFee();
    }
}

class ScholarshipStudent extends Student{
    public ScholarshipStudent(int studentId, String name, String course, float baseFee){
        super(studentId,name,course,baseFee);
    }
    public double calculateFee(){
        return getBaseFee() -0.2*getBaseFee();
    }
}

class ExchangeStudent extends Student{
    private static final float international_charges=12000;
    public ExchangeStudent(int studentId, String name, String course, float baseFee){
        super(studentId,name,course,baseFee);
    }
    public double calculateFee(){
        return getBaseFee() +international_charges;
    }
}

public class Saniya_Bagwan {
    public static void main(String[] args) {
        HashMap<Integer,Student> studentMap= new HashMap<>();
        int c,id,t;
        String n,cs;
        float b;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println();
            System.out.println("-------------Menu-------------");
            System.out.println("1.Add Student");
            System.out.println("2.Search Student");
            System.out.println("3.Delete Student");
            System.out.println("4.Update Student");
            System.out.println("5.Display All Students(Polymorphism )");
            System.out.println("6.Exit");
            System.out.println();
            System.out.print("Enter Choice: ");
            c = sc.nextInt();
            switch (c) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Student Name: ");
                    n = sc.nextLine();
                    System.out.print("Enter Student Course: ");
                    cs = sc.nextLine();
                    System.out.print("Enter Student Basefee: ");
                    b = sc.nextFloat();
                    sc.nextLine();
                    System.out.println();
                    do {
                        System.out.println("Select Student Type: ");
                        System.out.println("1.Regular");
                        System.out.println("2.Scholarship");
                        System.out.println("3.Exchange");
                        System.out.println();
                        System.out.print("Enter Choice: ");
                        t = sc.nextInt();
                        switch (t) {
                            case 1:
                                studentMap.put(id, new RegularStudent(id, n, cs, b));
                                break;
                            case 2:
                                studentMap.put(id, new ScholarshipStudent(id, n, cs, b));
                                break;
                            case 3:
                                studentMap.put(id, new ExchangeStudent(id, n, cs, b));
                                break;
                            default:
                                System.out.println("Invalid Type Selected!");
                        }
                    } while (t != 1 && t != 2 && t != 3);
                    System.out.println("Student Added!");
                    break;
                case 2:
                    System.out.print("Enter Student ID: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    if (studentMap.containsKey(id)) {
                        System.out.println("Student Found!");
                        studentMap.get(id).display();
                    } else {
                        System.out.println("Student Not Found!");
                    }
                    break;
                case 3:
                    System.out.print("Enter Student ID: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    if (studentMap.containsKey(id)) {
                        System.out.println("Student Found!");
                        studentMap.remove(id);
                        System.out.println("Student with ID :" + id + " is Deleted!");
                    } else {
                        System.out.println("Student Not Found!");
                    }
                    break;
                case 4:
                    System.out.print("Enter Student ID: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    if (studentMap.containsKey(id)) {
                        System.out.println("Student Found!");
                        System.out.println();
                        System.out.println("Old Details: ");
                        studentMap.get(id).display();
                        System.out.println();
                        System.out.print("Enter Student Name: ");
                        n = sc.nextLine();
                        System.out.print("Enter Student Course: ");
                        cs = sc.nextLine();
                        System.out.print("Enter Student Basefee: ");
                        b = sc.nextFloat();
                        sc.nextLine();
                        System.out.println();
                        do {
                            System.out.println("Select Student Type: ");
                            System.out.println("1.Regular");
                            System.out.println("2.Scholarship");
                            System.out.println("3.Exchange");
                            t = sc.nextInt();
                            switch (t) {
                                case 1:
                                    studentMap.put(id, new RegularStudent(id, n, cs, b));
                                    break;
                                case 2:
                                    studentMap.put(id, new ScholarshipStudent(id, n, cs, b));
                                    break;
                                case 3:
                                    studentMap.put(id, new ExchangeStudent(id, n, cs, b));
                                    break;
                                default:
                                    System.out.println("Invalid Type Selected!");
                            }
                        } while (t != 1 && t != 2 && t != 3);
                        System.out.println("Student Data Updated!");
                    } else {
                        System.out.println("Student Not Found!");
                    }
                    break;
                case 5:
                    if(studentMap.size()==0){
                        System.out.println("No Data Found!");
                    }else {
                        System.out.println("All Student Fees: ");
                        for (Student s : studentMap.values()) {
                            s.display();
                            System.out.println("Calculated Fees: " + s.calculateFee());

                        }
                    }
                    break;
                case 6:
                    System.out.println("Exiting.........");
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
        }while (c!=6);
        sc.close();
    }
}