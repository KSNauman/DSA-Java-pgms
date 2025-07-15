package Strings;

public class palidrome {
    public static void main(String[] args) {
        String var = "noommmn";boolean check=true;
        for(int i=0;i<var.length()/2;i++){
            if (var.charAt(i) != var.charAt(var.length()-i-1)) {
                check = false;
                break;                
            }
        }
        if (check) {
            System.out.println("ITS A PALINDROME");
        }else{
            System.out.println("Its not a Palindrome");
        }
    }
}
