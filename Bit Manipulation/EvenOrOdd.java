public class EvenOrOdd {

    public static void main(String[] args) {
        int bitMask=1,n=9;
        if ((n & bitMask) == 0) {
            System.out.println("Even ");          
        }else{
            System.out.println("Odd");
        }
    }
}
/*
 * n & bitMask == 0 results to compilation error 
 */