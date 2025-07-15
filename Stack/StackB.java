import java.util.ArrayList;

public class StackB {
    static class stackAL {
        static ArrayList<Integer> list = new ArrayList<>();

        public static boolean isEmpty() {
            return list.size() == 0;
            // == is an operator need not to be used only in the conditional statn
        }

        // push
        public static void push(int data) {
            list.add(data);
        }

        // pop
        public static int pop() {
            if (isEmpty()) {
                return -1;
            }
            int top = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return top;
        }

        // peek
        public static int peek() {
            if (isEmpty()) {
                return -1;
            }
            return list.get(list.size() - 1);
        }

    }

    public static void main(String[] args) {
        
        stackAL.push(1);
        stackAL.push(2);
        stackAL.push(3);

        while (!stackAL.isEmpty()) {
            System.out.println(stackAL.peek());
            stackAL.pop();
        }
    }
}