package DataStructures;

public class LinkedListAmirValeev {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Добавление в начало
        list = list.addNewHead(list, 10);
        list = list.addNewHead(list, 20);
        list = list.addNewHead(list, 30);
        System.out.print("После addNewHead (30,20,10): ");
        list.printLinkedList(list); // 30 20 10
        System.out.println(", size = " + list.size);

        // Добавление в конец
        list = list.addNewTail(list, 40);
        list = list.addNewTail(list, 50);
        System.out.print("После addNewTail (40,50): ");
        list.printLinkedList(list); // 30 20 10 40 50
        System.out.println(", size = " + list.size);

        // Вставка после узла с определённым значением
        list = list.addNewNode(list, 25, 20); // после 20 вставить 25
        list = list.addNewNode(list, 45, 40); // после 40 вставить 45
        System.out.print("После вставок 25 и 45: ");
        list.printLinkedList(list); // 30 20 25 10 40 45 50
        System.out.println(", size = " + list.size);

        // Поиск
        Node found = list.search(list, 25);
        System.out.println("Поиск 25: " + (found != null ? "найден" : "не найден"));
        found = list.search(list, 100);
        System.out.println("Поиск 100: " + (found != null ? "найден" : "не найден"));

        // Удаление элемента (не головы)
        list = list.removeElements(list, 25);
        System.out.print("После удаления 25: ");
        list.printLinkedList(list); // 30 20 10 40 45 50
        System.out.println(", size = " + list.size);

        // Удаление головы
        list = list.removeElements(list, 30);
        System.out.print("После удаления головы (30): ");
        list.printLinkedList(list); // 20 10 40 45 50
        System.out.println(", size = " + list.size);

        // Удаление хвоста
        list = list.removeElements(list, 50);
        System.out.print("После удаления хвоста (50): ");
        list.printLinkedList(list); // 20 10 40 45
        System.out.println(", size = " + list.size);

        // Удаление всех вхождений (если есть повторы)
        list = list.addNewTail(list, 20); // добавим ещё одну 20
        list = list.addNewTail(list, 20);
        System.out.print("Перед удалением всех 20: ");
        list.printLinkedList(list); // 20 10 40 45 20 20
        System.out.println(", size = " + list.size);
        list = list.removeElements(list, 20);
        System.out.print("После удаления всех 20: ");
        list.printLinkedList(list); // 10 40 45
        System.out.println(", size = " + list.size);

        // Удаление из пустого списка (не должно упасть)
        list = list.removeElements(list, 10);
        list = list.removeElements(list, 40);
        list = list.removeElements(list, 45);
        System.out.print("После удаления всех элементов: ");
        list.printLinkedList(list); // (пусто)
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

    public LinkedList addNewHead(LinkedList linkedList, int data){
        Node newHead = new Node(data, null);

        if (head == null){
            linkedList.tail = newHead;
        } else {
            newHead.next = linkedList.head;
        }

        linkedList.head = newHead;
        linkedList.size++;
        return linkedList;
    }

    public LinkedList addNewTail(LinkedList linkedList, int data){
        Node newTail = new Node(data, null);

        if (tail == null){
            linkedList.head = newTail;
        } else {
            linkedList.tail.next = newTail;
        }

        linkedList.tail = newTail;
        linkedList.size++;
        return linkedList;
    }

    public LinkedList addNewNode(LinkedList linkedList, int data, int after) {
        Node newNode = new Node(data, null);
        Node currentNode = linkedList.head;

        while (currentNode != null) {
            if (currentNode.data == after) {
                break;
            }
            currentNode = currentNode.next;
        }

        if (currentNode != null) {
            if (linkedList.tail == currentNode) {
                linkedList.tail = newNode;
            }
            newNode.next = currentNode.next;
            currentNode.next = newNode;
        }

        linkedList.size++;
        return linkedList;
    }

    public Node search(LinkedList linkedList, int data) {

        Node currentNode = linkedList.head;

        while (currentNode != null) {
            if (currentNode.data == data) {
                return currentNode;
            }

            currentNode = currentNode.next;
        }

        return null;
    }

    public LinkedList removeElements(LinkedList linkedList, int data) {
        Node dummy  = new Node(-1, linkedList.head);
        Node prev = dummy;
        Node current  = linkedList.head;

        while (current != null) {
            if (current.data == data) {
                prev.next = current.next;

                if (current == linkedList.tail){
                    linkedList.tail = prev;
                }

                linkedList.size--;
            } else {
                prev = current;
            }

            current = current.next;
        }

        linkedList.head = dummy.next;
        if (linkedList.head == null) {
            linkedList.tail = null;
        }
        return linkedList;
    }

    public void printLinkedList(LinkedList linkedList) {
        Node current = linkedList.head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}