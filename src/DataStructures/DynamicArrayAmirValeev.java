package DataStructures;

public class DynamicArrayAmirValeev {
    public static void main(String[] args) {

    }
}

class DynamicArray {
    int[] array;
    int size;
    int capacity;

    public DynamicArray(int capacity) {
        size = 0;
        this.capacity = capacity;
        array = new int[capacity];
    }

    public void append(int value) {
        if (isFull()) {
            this.resize();
        }

        array[size] = value;
        size++;
    }

    private void resize(){
        int new_capacity = capacity * 2;
        int[] newArray = new int[new_capacity];

        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }

        array = newArray;
        capacity = new_capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return size == capacity;
    }

}