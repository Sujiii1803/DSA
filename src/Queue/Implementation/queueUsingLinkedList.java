package Queue.Implementation;

class Queue{

    class Node{
        int data;
        Node next;
        Node(int value){
            this.data = value;
            this.next = null;
        }
    }

    Node front = null;
    Node rear = null;

    void enqueue( int value ){
        Node newNode = new Node(value);

        if( rear == null){
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    int dequeue(){
        if( front == null ){
            System.out.println("Queue is empty,Underflow");
            return -1;
        }
        int value = front.data;
        front = front.next;

        if( front == null ){
            rear = null;
        }
        return value;
    }

    int peek(){
        if( front == null ){
            System.out.println("Queue is empty");
            return -1;
        }
        return front.data;
    }

    boolean isEmpty(){
        return front == null;
    }

    void print(){
        Node temp = front;
        while( temp != null ){
            System.out.print( temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

}
public class queueUsingLinkedList {
    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        q.print();

        q.dequeue();
        q.print();

        System.out.println(q.peek());
        System.out.println(q.isEmpty());
        q.print();
    }
}
