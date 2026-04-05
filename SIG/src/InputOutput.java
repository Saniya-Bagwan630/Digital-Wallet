import java.util.Scanner;

public class InputOutput {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int age;
        String name;

        System.out.print("Enter age: ");
        age = sc.nextInt();
        System.out.println("Age: " + age);

        System.out.print("Enter Name: ");
        name = sc.next();
        System.out.println("Name: " + name);
    }
}