package Sortings.Quadratic;
import java.util.Scanner;

public class ShellSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        shellSort(arr);
    }

    public static void shellSort(int[] arr) {
        int gap = arr.length / 2;
        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {
                int m_gap = i;
                while (m_gap >= gap && arr[m_gap] < arr[m_gap - gap]) {
                    int temp = arr[m_gap];
                    arr[m_gap] = arr[m_gap - gap];
                    arr[m_gap - gap] = temp;
                    m_gap = m_gap - gap;
                }

            }

//            for (int a: arr){
//                System.out.print(a + " ");
//            }
//            System.out.println();

            gap = gap / 2;
        }
    }
}
