import java.util.Comparator;
import java.util.PriorityQueue;
public class Basic{
    static class Student implements Comparable<Student>{
        String name ;
        int rank;
        public Student(String name , int rank){
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2){
            return this.rank-s2.rank;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>();
        pq.add(new Student("Nauman", 2));
        pq.add(new Student("KS ", 1));
        pq.add(new Student("Ahmed", 3));
        while(!pq.isEmpty()){
            System.out.print(pq.peek().name+"->"+pq.peek().rank);
            pq.remove();
        }

    }
}