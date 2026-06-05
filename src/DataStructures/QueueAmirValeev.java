package DataStructures;

public class QueueAmirValeev {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(5);
        queue.enqueue(10);
        queue.enqueue(15);
        System.out.print("Очередь: ");
        queue.printQueue(); // 5 10 15
        System.out.println("\npeek: " + queue.peek()); // 5
        System.out.println("dequeue: " + queue.dequeue()); // 5
        System.out.print("После удаления: ");
        queue.printQueue(); // 10 15
        queue.enqueue(20);
        System.out.print("\nДобавили 20: ");
        queue.printQueue(); // 10 15 20
        System.out.println("\ndequeue all:");
        while (!queue.isEmpty()) {
            System.out.print(queue.dequeue() + " ");
        }
        System.out.println("\ndequeue from empty: " + queue.dequeue()); // -1
    }
}

class Queue{
   int head;
   int tail;
   DynamicArray queue;

   public Queue() {
       head = 0;
       tail = 0;
       queue = new DynamicArray(10);
   }

   public void enqueue(int x) {
       queue.append(x);
       tail++;
   }

   public int dequeue() {
       if (isEmpty()) {
           System.out.println("Queue is empty");
           return -1;
       }
       int val = queue.array[head];
       head++;
       return val;
   }

   public int peek() {
       if (isEmpty()){
           System.out.println("Queue is empty");
           return -1;
       }
       return queue.array[head];
   }

   public void printQueue() {
       for (int i = head; i < tail; i++) {
           System.out.print(queue.array[i] + " ");
       }
   }

   public boolean isEmpty() {
       return head == tail;
   }
}