package Queue;
import java.util.*;

// import LinkedList.LinkedList;
public class FNRL {
    public static void printNonRepeating(String str){
        int[] freq = new int[26];
        Queue<Character> q = new LinkedList<>();

        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch-'a']++;

            while (!q.isEmpty() && freq[q.peek()-'a']>1) {
                q.remove();
            }

            // case 01
            if (q.isEmpty()) {
                System.out.println(-1+" ");
            }else{
                System.out.println(q.peek()+" ");
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        String str = "aabccxb";
        printNonRepeating(str);
    }
}
/*
 * while (!q.isEmpty() && freq[q.peek()-'a']>1) {
                q.remove();
            }
    why queue is empty the condtion need to be checked 
    because the second condition is q.peek if the queue itself is empty
    then peeking will result to error 
 */