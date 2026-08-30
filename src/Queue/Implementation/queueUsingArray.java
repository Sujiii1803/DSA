package Queue.Implementation;

class ArrayQ{

    //instance variables
    int[] queue;
    int front;
    int rear;

    //constructor
    ArrayQ( int size ){
        queue = new int[size];
        front = 0;
        rear =-1; // -1 because no element yet
    }

    //instance methods

    void enqueue( int value ){
        if( rear == queue.length - 1 ){
            System.out.println("Queue is full, Overflow ");
            return ;
        }
        queue[ ++rear ] = value;
    }

    int dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty, Underflow");
            return -1;
        }
        int value = queue[front];
        front++;

        return value;
    }

    boolean isEmpty(){
        return front > rear;
    }

    boolean isFull(){
        return rear == queue.length - 1;
    }

    int peek(){
        if(isEmpty()){
            System.out.println("Queue is empty, Underflow");
            return -1;
        }
        return queue[front];
    }

    void print() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }

        System.out.println();
    }
}
public class queueUsingArray {
    public static void main(String[] args) {
        ArrayQ q = new ArrayQ(5);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);

        q.print();

        System.out.println(q.isFull());

        q.dequeue();
        q.dequeue();

        q.print();

        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.print();

        q.enqueue(60);
    }
}
