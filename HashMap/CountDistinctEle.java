import java.util.HashSet;
import java.util.Iterator;

public class CountDistinctEle {
    public static void main(String[] args) {
        int[] num = {4 , 3, 3, 2, 3, 5 ,1,2,3,4,5,6,7,8,9,3,2,1,4,5};
        HashSet<Integer> set = new HashSet<>();
        for (int i : num) {
            set.add(i);
        }
        System.out.println("Number of distinct ele: "+set.size());
        for(Integer i:set){
            System.out.println(i);
        }
        Iterator i = set.iterator();
        while (i.hasNext()) {
            System.out.println("iterator"+i.next());
        }
    }
}
