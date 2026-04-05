import org.w3c.dom.ls.LSOutput;

class parent{
    int p=111;
    void display(){
        System.out.println("I am Parent");
    }
}

class child extends parent{
    int p=222;
    void display(){
        System.out.println("I am Child");
    }
}

public class Main {
    public static void main(String[] args) {
        parent obj;
        obj=new child();
        obj.display();
        System.out.println(obj.p);
    }



}
