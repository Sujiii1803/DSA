package Queue.Leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

class Student {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> q = new ArrayDeque<>();
        for( int s : students ){
            q.offer(s);
        }

        int i = 0;
        int count = 0;
        while( i < sandwiches.length && !q.isEmpty() ){
            if( q.peek() == sandwiches[i] ){
                q.poll();
                i++;
                count = 0;
            }
            else{
                q.offer( q.poll() );
                count++;
            }

            if( count == q.size() ){
                break;
            }

        }
        return q.size();

    }
}
public class NumberOfStudentsUnableToEatLunch {
    public static void main(String[] args) {
        Student s1 = new Student();
        int[] students = {1,1,0,1};
        int[] sandwiches = {0,1,0,1};
        System.out.println(s1.countStudents( students, sandwiches));
    }
}
