package NearestNeighbours;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int mn = Integer.MAX_VALUE;
        int res_index = 0;

        for (int i = 1; i < n; i++) {
            int p1 = arr[i - 1];
            int p2 = arr[i];

            if (p2 - p1 < mn){
                mn = p2 - p1;
                res_index = i;
            }
        }

        System.out.println(arr[res_index - 1] + " " + arr[res_index]);

    }
}
