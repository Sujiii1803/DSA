package Queue.Implementation;

import java.util.Deque;
import java.util.ArrayDeque;

public class Dequeue {

    public static void main(String[] args) {

        Deque<Integer> deque = new ArrayDeque<>();

        // Add elements
        deque.addLast(10);
        deque.addLast(20);
        deque.addLast(30);

        // Add at front
        deque.addFirst(5);

        // Add at rear
        deque.addLast(40);

        // Print deque
        System.out.println("Deque: " + deque);

        // Peek front
        System.out.println("Front: " + deque.peekFirst());

        // Peek rear
        System.out.println("Rear: " + deque.peekLast());

        // Remove from front
        System.out.println("Removed from front: " + deque.removeFirst());

        // Remove from rear
        System.out.println("Removed from rear: " + deque.removeLast());

        // Print after removal
        System.out.println("Deque after removal: " + deque);

        // Check empty
        System.out.println("Is empty: " + deque.isEmpty());

        // Size
        System.out.println("Size: " + deque.size());
    }
}
