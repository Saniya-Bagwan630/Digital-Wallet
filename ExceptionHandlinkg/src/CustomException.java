import java.util.Scanner;

class InvalidAge extends Exception{
    InvalidAge(String m){
        super(m);
    }
}

public class CustomException {
    static void check(int a) throws InvalidAge{
        if(a<18) throw new InvalidAge("Invalid");
        System.out.println("Valid");
    }
    public static void main(String[] args) {
        System.out.println("Enter Age: ");
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();
        try {
            check(age);
        }catch (InvalidAge e){
            System.out.println("Exception: "+e.getMessage());
        }
    }
}
