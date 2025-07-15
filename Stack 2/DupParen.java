import java.util.Stack;
//Duplicate parenthesis use of stack 
// input: valid parenthesis
// output: true if duplicate exists
public class DupParen {
    public static boolean isDup(String str){
        Stack<Character> s = new Stack<>();
        for(int i=0 ; i<str.length();i++){
            char ch = str.charAt(i);

            //closing
            if (ch == ')') {
                int count = 0;
                while (s.peek() != '(') {
                    s.pop();
                    count++;
                }
                if(count <1){
                    return true;// duplicate
                }else{
                    s.pop();//opening pair
                }
            }else{
                s.push(ch);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String str = "(((a+b)+(c)))";
        System.out.println(isDup(str));
    }
}
// if (ch == ')') {
//     int count = 0;
//     while (s.pop() != '(') {
//         count++;
//     }
//     if(count <1){
//         return true;// duplicate
//     }
// }else{
//     s.push(ch);
// }