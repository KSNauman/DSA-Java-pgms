package Queue.Deque;

import java.util.*;

public class deq {
    public static void main(String[] args) {
        Deque<Integer> Dq = new LinkedList<>();

        Dq.addFirst(1);
        Dq.addLast(3);
        System.out.println(Dq);
    }
}
/*
 *  1.addFirst()
    2.addLast()
    3.removeFirst()
    4.removeLast()
    5.getLast()
 */