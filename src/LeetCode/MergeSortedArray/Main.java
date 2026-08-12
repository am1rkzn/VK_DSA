package LeetCode.MergeSortedArray;

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[] nums1 = new int[m+n];
        int[] nums2 = new int[n];

        for (int i = 0; i < m; i++) {
            nums1[i] = sc.nextInt();
        }
        for (int i = m; i < n + m; i++) {
            nums1[i] = 0;
        }

        for (int i = 0; i < n; i++) {
            nums2[i] = sc.nextInt();
        }
        int[] res = merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(res));
    }

    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1_copy = new int[m];
        for (int i = 0; i < m; i++) {
            nums1_copy[i] = nums1[i];
        }

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < m && j < n) {
            if (nums1_copy[i] < nums2[j]) {
                nums1[k] = nums1_copy[i];
                i++;
            } else {
                nums1[k] = nums2[j];
                j++;
            }
            k++;
        }
        for (int l = k; l < n + m; l++){
            if (i == m){
                nums1[l] = nums2[j];
                j++;
            } else if (j == n){
                nums1[l] = nums1_copy[i];
                i++;
            }
        }
        return nums1;
    }

}