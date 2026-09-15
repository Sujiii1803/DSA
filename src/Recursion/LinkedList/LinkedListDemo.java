package Recursion.LinkedList;

class Node{
    int data;
    Node next;
    Node( int data){
        this.data = data;
        this.next = null;
    }
}
public class LinkedListDemo {

    public static void print( Node head ){
        if( head == null ){
            return;
        }
        System.out.print(head.data + " ");
        print( head.next);
    }
    public static void printInReverse( Node head ){
        if( head == null ){
            return;
        }
        printInReverse( head.next);
        System.out.print(head.data + " ");

    }
    public static int search( Node head ,int target,int i){
        if( head == null ){
            return -1;
        }
        if( head.data == target ){
            return i;
        }
        i = i + 1;
        return search( head.next,target,i);

    }
    public static Node Reverse( Node head ){
        if( head == null || head.next == null ){
            return head;
        }
        Node newHead = Reverse( head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    public static void main( String[] args ){
        Node node = new Node(10);
        node.next = new Node(20);
        node.next.next = new Node(30);
        print(node);
        System.out.println();
        printInReverse(node);
        System.out.println();
        System.out.print( search(node,30,1));
        System.out.println();
        Reverse(node);
        print(node);

    }
}
