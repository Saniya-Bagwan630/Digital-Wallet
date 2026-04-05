class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Inside Run");
    }
}
public class RunnableInterface {
    public static void main(String[] args) {
        MyRunnable r = new MyRunnable();
        Thread t1 = new Thread(r);
        t1.start();
    }
}
