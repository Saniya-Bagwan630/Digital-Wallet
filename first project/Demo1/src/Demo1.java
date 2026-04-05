class Senior{
    String name;
    int roll;
    void Display(){
        System.out.println("Name: "+name);
        System.out.println("Roll: "+roll);
    }

    Senior(String n,int r){
        name=n;
        roll=r;
    }
}

class Junior extends Senior{
    int age;

    void Display(){
        System.out.println("Name: "+name);
        System.out.println("Roll: "+roll);
        System.out.println("Age: "+age);
    }
    Junior(String n,int r,int a){
        super(n,r);
        age=a;
    }
    Junior(String n,int r){
        super(n,r);
    }
}
public class Demo1 {
    public static void main(String[] args) {
        Senior s = new Junior("Saniya",23209,19);
        s.Display();

    }
}
