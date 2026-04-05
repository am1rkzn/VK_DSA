package CheatingAtSchool;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int zero_index = 0;
        int numeric_index = 0;
        while (zero_index < n && numeric_index < n) {
            if (arr[zero_index] == 0 && arr[numeric_index] == 0) {
                numeric_index++;
            } else if (arr[zero_index] != 0 && arr[numeric_index] != 0) {
                zero_index++;
            } else if (arr[zero_index] != 0 && arr[numeric_index] == 0) {
                zero_index++;
                numeric_index++;
            } else {
                int temp = arr[zero_index];
                arr[zero_index] = arr[numeric_index];
                arr[numeric_index] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
