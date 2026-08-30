package Queue.Implementation;

class cQueue{
    int[] queue;
    int front = 0;
    int rear = 0;
    int size = 0;

    cQueue( int size ){
        queue = new int[size];
    }

    boolean isEmpty(){
        return size == 0;
    }

    boolean isFull(){
        return size == queue.length;
    }

    void enqueue( int value ){

        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }

        queue[rear] = value;
        rear = (rear + 1) % queue.length;
        size++;
    }

    void dequeue(){

        if (isEmpty()) {
            return;
        }

        front = ( front + 1) % queue.length;
        size--;
    }

    void peek(){
        System.out.print( queue[front]);
    }

    void print() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        int index = front;

        for (int i = 0; i < size; i++) {
            System.out.print(queue[index] + " ");
            index = (index + 1) % queue.length;
        }

        System.out.println();
    }
}
public class circularQueue {
    public static void main(String[] args){
           cQueue q = new cQueue(5);

           q.enqueue(10);
           q.enqueue(20);
           q.enqueue(30);
           q.enqueue(40);
           q.enqueue(50);

           q.print();

           q.dequeue();
           q.dequeue();

           q.print();

           q.enqueue(60);
           q.print();
    }
}