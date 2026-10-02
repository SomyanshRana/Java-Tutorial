import java.util.*;

public class Priority_QueueBasic {

    static class Student implements Comparable<Student> { //overriding
        String name;
        int rank;

        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override 
        public int compareTo(Student s2) {
            return this.rank - s2.rank;
        }
    }
    public static void main(String args[]) {
        PriorityQueue<Student> pq = new PriorityQueue<>();

        pq.add(new Student("A", 3));
        pq.add(new Student("B", 8));
        pq.add(new Student("C", 2));
        pq.add(new Student("D", 5));

        while(!pq.isEmpty()) {
            System.out.println(pq.peek().name +" -> "+ pq.peek().rank); //O(1)
            pq.remove(); //O(logn)
        }
    }
}