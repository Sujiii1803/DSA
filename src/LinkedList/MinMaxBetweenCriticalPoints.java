package LinkedList;

class MinMax {
    static class Node{
        int val;
        Node next;
        Node( int val, Node next){
            this.val = val;
            this.next = next;
        }
    }
    public int[] nodesBetweenCriticalPoints(Node head) {
        Node prev = head;
        Node current = head.next;
        Node next = current.next;

        int firstCritical = -1;
        int lastCritical = -1;
        int minDistance = Integer.MAX_VALUE;
        int index = 2;


        while( prev != null  && next != null ){
            int currentValue = current.val;
            if( (currentValue > prev.val && currentValue > next.val)  ||
                    (currentValue < prev.val && currentValue < next.val)){
                if (firstCritical == -1)
                {
                    firstCritical = index;
                    lastCritical = index;
                }else{
                    int distance = index - lastCritical;
                    minDistance = Math.min( minDistance, distance);
                    lastCritical = index;
                }
            }
            prev = current;
            current = next;
            next = current.next;

            index++;

        }
        if (firstCritical == -1 || firstCritical == lastCritical) {
            return new int[]{-1, -1};
        }

        int maxDistance = lastCritical - firstCritical;

        return new int[]{minDistance, maxDistance};
    }
}
public class MinMaxBetweenCriticalPoints {
    public static void main(String[] args) {
        MinMax obj = new MinMax();

        MinMax.Node head =
                new MinMax.Node(5,
                        new MinMax.Node(3,
                                new MinMax.Node(1,
                                        new MinMax.Node(2,
                                                new MinMax.Node(5,
                                                        new MinMax.Node(1,
                                                                new MinMax.Node(2, null)
                                                        )
                                                )
                                        )
                                )
                        )
                );

        int[] result = obj.nodesBetweenCriticalPoints(head);

        System.out.println(result[0] + " " + result[1]);
    }
}
