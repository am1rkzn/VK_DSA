package SearchingAlgorithms;

public class BinarySearchAmirValeev {
    public static void main(String[] args) {

    }

    public int binarySearchRec(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        if (target < arr[left] || target > arr[right]) {
            return -1;
        }

        return binarySearch(arr, target, left, right);
    }

    public int binarySearch(int[] arr, int target, int left, int right) {

        if (left > right) {
            return -1;
        }

        int middle = left + (right - left) / 2;

        if (arr[middle] == target) {
            return middle;
        }

        if (arr[middle] < target) {
            return binarySearch(arr, target, middle + 1, right);
        } else {
            return binarySearch(arr, target, left, middle - 1);
        }
    }

    public int binarySearchIterative(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        if (target < arr[left] || target > arr[right]) {
            return -1;
        }
        while (left <= right) {

            int middle = left + (right - left) / 2;

            if (arr[middle] == target) {
                return middle;
            } else if (arr[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }

    public int leftBinarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        if (target < arr[left] || target > arr[right]) {
            return -1;
        }

        while (left + 1 < right) {

            int middle = left + (right - left) / 2;

            if (arr[middle] < target) {
                left = middle;
            } else  {
                right = middle;
            }
        }

        if (arr[left] == target) {
            return left;
        } else if (arr[right] == target) {
            return right;
        }

        return -1;
    }

    public int rightBinarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        if (target < arr[left] || target > arr[right]) {
            return -1;
        }

        while (left + 1 < right) {

            int middle = left + (right - left) / 2;

            if (arr[middle] <= target) {
                left = middle;
            } else  {
                right = middle;
            }
        }

        if (arr[right] == target) {
            return right;
        } else if (arr[left] == target) {
            return left;
        }

        return -1;
    }
}
