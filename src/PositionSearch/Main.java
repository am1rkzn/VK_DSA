package PositionSearch;
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
        int searchRes = binarySearch(arr, target, 0, arr.length - 1);


        System.out.println(searchRes);
    }

    public static int binarySearch(int[] arr, int target, int left, int right) {

        while (left + 1 < right) {

            int middle = (left + right) / 2;

            if (arr[middle] < target){
                left = middle;
            } else {
                right = middle;
            }
        }

        if (arr[left] == target) {
            return left;
        } else if (arr[right] == target) {
            return right;
        }

        return right;

    }
}
