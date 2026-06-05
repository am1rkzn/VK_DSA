package DataStructures;

public class DequeAmirValeev {
    public static void main(String[] args) {
        Deque deque = new Deque();
        deque.pushFront(10);
        deque.pushFront(20);
        deque.pushBack(30);
        deque.pushBack(40);
        System.out.print("Дек: ");
        deque.printDeque(); // 20 10 30 40
        System.out.println("\npopFront: " + deque.popFront()); // 20
        System.out.println("popBack: " + deque.popBack());     // 40
        System.out.print("После удалений: ");
        deque.printDeque(); // 10 30
        deque.pushBack(50);
        deque.pushFront(5);
        System.out.print("\nДобавили 5 в начало и 50 в конец: ");
        deque.printDeque(); // 5 10 30 50
        System.out.println("\npopBack: " + deque.popBack()); // 50
        System.out.println("popBack: " + deque.popBack()); // 30
        System.out.println("popBack: " + deque.popBack()); // 10
        System.out.println("popBack: " + deque.popBack()); // 5
        System.out.println("popBack empty: " + deque.popBack()); // -1
    }
}

class Deque{
    ModifiedNode head;
    ModifiedNode tail;
    int size;

    public Deque() {
        head = new ModifiedNode(-1, null, null);
        tail = new ModifiedNode(-1, null, null);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public void pushFront(int data) {
        ModifiedNode newNode = new ModifiedNode(data, head.next, head);
        head.next.prev = newNode;
        head.next = newNode;
        size++;
    }

    public void pushBack(int data) {
        ModifiedNode newNode = new ModifiedNode(data, tail, tail.prev);
        tail.prev.next = newNode;
        tail.prev = newNode;
        size++;
    }

    public int popFront() {
        if (size == 0) return -1;
        ModifiedNode node = head.next;
        head.next = node.next;
        node.next.prev = head;
        size--;
        return node.data;
    }

    public int popBack() {
        if (size == 0) {
            return -1;
        }
        ModifiedNode pop_res = tail.prev;

        tail.prev = pop_res.prev;
        pop_res.prev.next = tail;

        pop_res.prev = null;
        pop_res.next = null;
        size--;
        return pop_res.data;
    }

    public void printDeque() {
        ModifiedNode curr = head.next;
        while (curr != tail) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}