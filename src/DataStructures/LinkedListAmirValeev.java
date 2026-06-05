package DataStructures;

public class LinkedListAmirValeev {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Добавление в начало
        list.addNewHead(10);
        list.addNewHead(20);
        list.addNewHead(30);
        System.out.print("После addNewHead (30,20,10): ");
        list.printLinkedList(); // 30 20 10
        System.out.println(", size = " + list.size);

        // Добавление в конец
        list.addNewTail(40);
        list.addNewTail(50);
        System.out.print("После addNewTail (40,50): ");
        list.printLinkedList(); // 30 20 10 40 50
        System.out.println(", size = " + list.size);

        // Вставка после узла с определённым значением
        list.addNewNode(25, 20); // после 20 вставить 25
        list.addNewNode(45, 40); // после 40 вставить 45
        System.out.print("После вставок 25 и 45: ");
        list.printLinkedList(); // 30 20 25 10 40 45 50
        System.out.println(", size = " + list.size);

        // Поиск
        Node found = list.search(25);
        System.out.println("Поиск 25: " + (found != null ? "найден" : "не найден"));
        found = list.search(100);
        System.out.println("Поиск 100: " + (found != null ? "найден" : "не найден"));

        // Удаление элемента (не головы)
        list.removeElements(25);
        System.out.print("После удаления 25: ");
        list.printLinkedList(); // 30 20 10 40 45 50
        System.out.println(", size = " + list.size);

        // Удаление головы
        list.removeElements(30);
        System.out.print("После удаления головы (30): ");
        list.printLinkedList(); // 20 10 40 45 50
        System.out.println(", size = " + list.size);

        // Удаление хвоста
        list.removeElements(50);
        System.out.print("После удаления хвоста (50): ");
        list.printLinkedList(); // 20 10 40 45
        System.out.println(", size = " + list.size);

        // Удаление всех вхождений (если есть повторы)
        list.addNewTail(20); // добавим ещё одну 20
        list.addNewTail(20);
        System.out.print("Перед удалением всех 20: ");
        list.printLinkedList(); // 20 10 40 45 20 20
        System.out.println(", size = " + list.size);
        list.removeElements(20);
        System.out.print("После удаления всех 20: ");
        list.printLinkedList(); // 10 40 45
        System.out.println(", size = " + list.size);

        System.out.print("До разворота: ");
        list.printLinkedList();
        list.reverseLinkedList();
        System.out.print("\nПосле разворота: ");
        list.printLinkedList();
        System.out.println();

        // Удаление из пустого списка (не должно упасть)
        list.removeElements(10);
        list.removeElements(40);
        list.removeElements(45);
        System.out.print("После удаления всех элементов: ");
        list.printLinkedList(); // (пусто)
        System.out.println(", size = " + list.size);
        System.out.println("head = " + (list.head == null ? "null" : list.head.data));
        System.out.println("tail = " + (list.tail == null ? "null" : list.tail.data));
    }
}

class Node {
    int data;
    Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

class LinkedList{
    Node head;
    Node tail;
    int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void addNewHead(int data){
        Node newHead = new Node(data, null);

        if (head == null){
            tail = newHead;
        } else {
            newHead.next = head;
        }

        head = newHead;
        size++;
    }

    public void addNewTail(int data){
        Node newTail = new Node(data, null);

        if (tail == null){
            head = newTail;
        } else {
            tail.next = newTail;
        }

        tail = newTail;
        size++;
    }

    public void addNewNode(int data, int after) {
        Node newNode = new Node(data, null);
        Node currentNode = head;

        while (currentNode != null) {
            if (currentNode.data == after) {
                break;
            }
            currentNode = currentNode.next;
        }

        if (currentNode != null) {
            if (tail == currentNode) {
                tail = newNode;
            }
            newNode.next = currentNode.next;
            currentNode.next = newNode;
            size++;
        }


    }

    public Node search(int data) {

        Node currentNode = head;

        while (currentNode != null) {
            if (currentNode.data == data) {
                return currentNode;
            }

            currentNode = currentNode.next;
        }

        return null;
    }

    public void removeElements(int data) {
        Node dummy  = new Node(-1, head);
        Node prev = dummy;
        Node current  = head;

        while (current != null) {
            if (current.data == data) {
                prev.next = current.next;

                if (current == tail){
                    tail = prev;
                }

                size--;
            } else {
                prev = current;
            }

            current = current.next;
        }

        head = dummy.next;
        if (head == null) {
            tail = null;
        }
    }

    public void printLinkedList() {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    public void reverseLinkedList() {
        Node current = head;
        tail = head;
        Node prev = null;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;

    }

}