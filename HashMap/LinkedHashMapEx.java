import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class LinkedHashMapEx {
    public static void main(String[] args) {
        LinkedHashMap<String , Integer> lhm = new LinkedHashMap<>();
        HashMap<String , Integer> hm = new HashMap<>();
        TreeMap<String , Integer> tm = new TreeMap<>();
        hm.put("B", 20);
        hm.put("A", 10);
        hm.put("C", 30);

        lhm.put("B", 20);
        lhm.put("A", 10);
        lhm.put("C", 30);
        
        tm.put("B", 20);
        tm.put("A", 10);
        tm.put("C", 30);

        
        System.out.println(hm);
        System.out.println(lhm);
        System.out.println(tm);
    }
}
