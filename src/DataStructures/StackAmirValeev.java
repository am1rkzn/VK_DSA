package DataStructures;

public class StackAmirValeev {
    public static void main(String[] args) {
        // Тест StackLL
        System.out.println("=== StackLL ===");
        StackLL stackLL = new StackLL();
        stackLL.push(10);
        stackLL.push(20);
        stackLL.push(30);
        System.out.println("pop: " + stackLL.pop()); // 30
        System.out.println("pop: " + stackLL.pop()); // 20
        stackLL.push(40);
        System.out.println("pop: " + stackLL.pop()); // 40
        System.out.println("pop: " + stackLL.pop()); // 10
        System.out.println("pop empty: " + stackLL.pop()); // -1

        // Тест StackArray
        System.out.println("\n=== StackArray ===");
        StackArray stackArr = new StackArray();
        stackArr.push(1);
        stackArr.push(2);
        stackArr.push(3);
        System.out.println("peek: " + stackArr.peek()); // 3
        System.out.println("pop: " + stackArr.pop());   // 3
        System.out.println("pop: " + stackArr.pop());   // 2
        stackArr.push(4);
        System.out.println("pop: " + stackArr.pop());   // 4
        System.out.println("pop: " + stackArr.pop());   // 1
        System.out.println("pop empty: " + stackArr.pop()); // -1
    }
}


class StackLL{
    LinkedList stack;
    public StackLL(){
        stack = new LinkedList();
    }

    public void push(int data){
        stack.addNewHead(data);
    }

    public int pop(){
        if (stack.head == null){
            return -1;
        }

        Node top = stack.head;

        if (stack.head.next != null){
            stack.head = stack.head.next;
        } else {
            stack.head = null;
        }
        stack.size--;
        return top.data;
    }
}

class StackArray {
    DynamicArray stack;

    public StackArray() {
        stack = new DynamicArray(1);
    }

    public void push(int data) {
        stack.append(data);
    }

    public int pop() {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        // Уменьшаем размер, затем берём последний элемент
        stack.size--;
        return stack.array[stack.size];
    }

    public int peek() {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        // Последний элемент – по индексу size-1
        return stack.array[stack.size - 1];
    }
}