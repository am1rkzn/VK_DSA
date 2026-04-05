package CleaningUpTheExperiment;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int element = sc.nextInt();
        int count = 0;
        for (int i = 0; i < n; i++){
            if (arr[i] == element){
                count++;
            }
        }

        int[] new_arr = new int[n-count];
        int j = 0;
        for (int i = 0; i < n; i++){
            if (arr[i] != element){
                new_arr[j] = arr[i];
                j++;
            }
        }


        for (int i = 0; i < n - count; i++) {
            System.out.print(new_arr[i] + " ");
        }

    }

}
