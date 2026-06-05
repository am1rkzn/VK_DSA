package DataStructures;

public class DoubleLinkedListAmirValeev {
    public static void main(String[] args) {

    }
}

class DoubleLinkedList {
    ModifiedNode head;
    ModifiedNode tail;
    int size;

    public DoubleLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void addHead(int data) {
        ModifiedNode newHead = new ModifiedNode(data, null, null);
        size++;

        if (head == null) {
            head = newHead;
            return ;
        }

        head.prev = newHead;
        newHead.next = head;
        head = newHead;
    }

    public void addTail(int data) {
        ModifiedNode newTail = new ModifiedNode(data, null, null);



        if (tail == null) {
            head = newTail;
        } else {
            tail.next = newTail;
            newTail.prev = tail;
        }
        size++;
        tail = newTail;
    }
}

class ModifiedNode{
    int data;
    ModifiedNode next;
    ModifiedNode prev;

    public ModifiedNode(int data, ModifiedNode next, ModifiedNode prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}