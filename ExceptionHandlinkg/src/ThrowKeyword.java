import java.util.Scanner;

public class ThrowKeyword {

    static void check(int num){
        if(num>100){
            try {
                throw new Exception("greater Than 100");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }else{
            System.out.println("Valid");
        }
    }
    public static void main(String[] args) {
        int num;
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        check(num);
    }
}
