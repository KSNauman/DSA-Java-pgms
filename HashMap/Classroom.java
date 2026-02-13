import java.util.HashMap;
import java.util.Set;

public class Classroom {
    public static void main(String[] args) {
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("A",10);
        hm.put("B",20);
        hm.put("C",300);
        hm.put("D",40);
        System.out.println(hm);

        Set<String> st = hm.keySet();
        for (String s : st) {
            System.out.println("Key: "+s+" Value :"+hm.get(s));   
        }
        // System.out.println(st); 
    }   
}
