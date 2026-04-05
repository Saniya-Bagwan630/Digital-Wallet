class Thread1 extends Thread{
    @Override
    public void run() {
        System.out.println("Inside Run Methode "+ Thread.currentThread().getName());
        System.out.println("Hello "+Thread.currentThread().getName());
    }
}

public class MyThread {
    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread1 t2 = new Thread1();
        t1.setName("t1");
        t2.setName("t2");
        t1.setPriority(10);
        t2.setPriority(1);
        t1.start();
        t2.start();
    }
}
