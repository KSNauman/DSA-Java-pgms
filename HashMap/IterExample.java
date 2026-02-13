import java.util.*;
public class IterExample{
    public static void main(String[] args){
        HashSet<String> set = new HashSet<>();
        set.add("1");
        set.add("2");
        set.add("3");
        set.add("4");

        Iterator i = set.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }
    }
}