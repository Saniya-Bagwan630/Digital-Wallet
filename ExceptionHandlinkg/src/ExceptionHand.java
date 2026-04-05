public class ExceptionHand {
    public static void main(String[] args) {
        int[] a= new int[10];
        try {
            System.out.println(5/0); //exception will occur
            System.out.println(a[11]); // as above line gives exception this line will not be checked
        }
        catch (ArithmeticException e){ //exception will be catched here and remaining catch blocks will not be checked
            System.out.println("Arithmetic Exception Occured!");
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Array Index Out Of Bounds Exception Occured!");
        }
        catch (Exception e) {
            System.out.println("Exception occurred "+e);
        }finally {
            System.out.println("I will work anyway");
        }
    }
}
