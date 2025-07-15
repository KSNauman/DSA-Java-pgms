import java.util.*;
public class problems {
    public static void pushAtBottom(Stack<Integer> s, int data){
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }
    
    public static String reverseString(String str){
        Stack<Character> s = new Stack<>();
        for(int i=0;i<str.length();i++){
            s.push(str.charAt(i));
        }

        StringBuilder result = new StringBuilder("");
        while (!s.isEmpty()) {
            result.append(s.pop());
        }
        return result.toString();

        /*
         * instead of StringBuilder u can use String but issue is on every 
         * concatination it creates an object 
         * result += s.pop();
         * so when ever u come across prblm where u need to concatinate or 
         * modify use StringBuilder as it wont create unnecessary objects 
         */
    }
    public static void reverseStack(Stack<Integer> s){
        if (s.isEmpty()) {
            return;
        }

        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);

    }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s);
        pushAtBottom(s,4);
        System.out.println(s);
        /*
         * another method to print
         while (!s.isEmpty()) {
             System.out.println(s.pop());
         }
         */
        //System.out.println(reverseString("abc"));

        reverseStack(s);
        System.out.println(s);
    }
}
