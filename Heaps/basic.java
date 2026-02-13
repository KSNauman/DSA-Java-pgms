package Heaps;
import java.util.*;
public class basic {
    static class heap{
        ArrayList<Integer> arr = new ArrayList<>();
        public void add(int data){
            arr.add(data);
            int child = arr.size()-1;
            int par = (child-1)/2;
            while (arr.get(child) < arr.get(par)) {
                int temp = arr.get(par);
                arr.set(par, arr.get(child));
                arr.set(child, temp);
                child = par;
                par = (child-1)/2;
            }
        }
        public int peek(){
            return arr.get(0);
        }
        private void heapify(int i){
            int left = (2*i)+1;
            int right = (2*i)+2;
            int minVal = i;
            if (left < arr.size() && arr.get(left)<arr.get(minVal)) {
                minVal = left;
            }
            if (right < arr.size() && arr.get(right)<arr.get(minVal)) {
                minVal = right;
            }
            if (minVal != i) {
                int temp = arr.get(i);
                arr.set(i, arr.get(minVal));
                arr.set(minVal, temp);

                heapify(minVal);
            }
        }
        public int remove(){
            int data = arr.get(0);

            // step 1 : swap
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);
            // step 2 : delete
            arr.remove(arr.size()-1);
            // step 3 : heapify
            heapify(0);
            return data;
        }
        public boolean isEmpty(){
            return arr.size()==0;
        }}
        public static void main(String[] args) {
            heap hp = new heap();
            hp.add(3);
            hp.add(1);
            hp.add(7);
            hp.add(5);
            while (!hp.isEmpty()) {
                System.out.println(hp.peek());
                hp.remove();
            }

        }
}
