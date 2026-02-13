//package functAndMethods;
import java.util.*;
public class BinToDec {
    public static int binarytodecimal(int bin){


        // int pow=0,dec=0;
        // while (bin >0) {
        //     int LD = bin%10;
        //     dec += LD*(int)Math.pow(2,pow);
        //     pow++;
        //     bin /=10;
        // }
        int dec = 0 , pow = 0;
        int ld = 0;
        while(bin > 0){
            ld = bin%10;
            bin/=10;
            dec = dec + ld * (int)Math.pow(2 , pow);
            pow++;
        }
        return dec;
    }
 
    public static int decTOBin(int n){
        int rem , bin = 0 , pow = 0;
        while(n>0){
            rem = n%2;
            n/=2;
            bin = bin + rem*((int)Math.pow(10,pow));
            pow++;
        }
        return bin;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Binary number");
        int bin = sc.nextInt();
        // int result = binarytodecimal(bin);
        int result = decTOBin(bin);
        System.out.println("Decimal is :"+result);
    }
}
