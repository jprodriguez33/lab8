import java.util.ArrayDeque;
public class MaxQueue {
    private ArrayDeque<Integer> mainQueue;
    //main Queue which will hold all x inputs
    private ArrayDeque<Integer> maxQueue;
    //max Queue which will hold only max elements

    public MaxQueue() {
        // to queue the main and max queues
        mainQueue = new ArrayDeque<>();
        maxQueue = new ArrayDeque<>();
    }

    public int getMax() {
        //returns the top value of the max queue
        return maxQueue.peek();
    }

    public void enqueue(int x) {
        mainQueue.offer(x);
        //check if main Queue is full, if not then put x into main Queue
        while (!maxQueue.isEmpty() && maxQueue.peekLast() < x) {
            //while max Queue is not empty and the last element is < x
            //then remove the top element of the max queue
            maxQueue.pollLast();
        }
        //insert x into max queue
        maxQueue.offer(x);
        //this ensures that an element that cannot possibly be the maximum element
        //is taken out of the max queue
    }
    public int dequeue() {
        //deque the elements that can no longer be considered the maximum element
        int x = mainQueue.poll();
        //sets x equals to the top value of the main queue
        if (x == maxQueue.peek()) {
            // if x from the main queue is equal to top element of the max queue
            // then it is removed from the max queue
            maxQueue.poll();
        }
        return x;
    }

    public static void main(String[] args) {
        MaxQueue max = new MaxQueue();

        max.enqueue(1);
        System.out.println("Maximum element after adding 1 is: " + max.getMax());

        max.enqueue(4);
        System.out.println("Maximum element after adding 4 is: " + max.getMax());

        max.enqueue(2);
        System.out.println("Maximum element after adding 2 is: " + max.getMax());

        max.enqueue(3);
        System.out.println("Maximum element after adding 3 is: " + max.getMax());

        max.dequeue();
        System.out.println("Maximum element after dequeues is: " + max.getMax());

        System.out.println("Main queue is 3 -> 2 -> 1 -> 4");
    }
}