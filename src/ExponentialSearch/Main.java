package ExponentialSearch;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();

        int[] interval = exponentialSearch(arr, target);

        System.out.println(interval[0] + " " + interval[1]);
    }

    public static int[] exponentialSearch(int[] arr, int target) {
        int boarder = 1;
        int arrlen = arr.length - 1;
        int[] result = new int[2];

        while (boarder < arrlen && arr[boarder] < target ) {
            if (arr[boarder] == target) {
                result[0] = boarder;
                result[1] = boarder*2;
                return result;
            }

            boarder = boarder*2;

            if (boarder > arrlen) {
                result[0] = boarder/2;
                result[1] = arrlen;
                return result;
            }
        }

        result[0] = boarder/2;
        result[1] = boarder;
        return result;
    }

}
