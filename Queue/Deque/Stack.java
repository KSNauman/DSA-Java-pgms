package Queue.Deque;
import java.util.*;
public class Stack {
    public static class stak{
        Deque<Integer> dq = new LinkedList<>();
        public void push(int data){
            dq.addLast(data);
        }
        public int pop(){
            return dq.removeLast();
        }
        public int peek(){
            return dq.getLast();
        }
    }
    public static void main(String[] args) {
        stak s = new stak();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.peek());
    }
}
