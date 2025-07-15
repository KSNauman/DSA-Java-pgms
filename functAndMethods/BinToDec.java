//package functAndMethods;
import java.util.*;
public class BinToDec {
    public static int binarytodecimal(int bin){
        int pow=0,dec=0;
        while (bin >0) {
            int LD = bin%10;
            dec += LD*(int)Math.pow(2,pow);
            pow++;
            bin /=10;
        }
        return dec;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Binary number");
        int bin = sc.nextInt();
        int result = binarytodecimal(bin);
        System.out.println("Decimal is :"+result);
    }
}
