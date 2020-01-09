import java.util.*; 

/**
Priority Queue
1. To be used when objects are to be processed in some priority order.
2. Basic operations:
    * add()
    * peek() -> retrieves but doesn't remove the head of the queue
    * poll() -> retrieves and removes the head of the queue
3. The head of the queue is the last element with respect to the ordering of the queue.
4. Default initial capacity of the queue is 11.
5. PriorityQueue doesn't permit null.

Time Complexity:
Insert: O(log(n))
Delete: O(log(n))
Retrieve: O(1)

 */


class PriorityQueueDS {
    public static void main(String args[]) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>((n1, n2) -> n2 - n1);

        priorityQueue.add(10);
        priorityQueue.add(20);
        priorityQueue.add(5);

        System.out.println(priorityQueue.peek());

    }
}