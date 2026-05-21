package RaceRecord;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int max_points = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if (max_points < x){
                max_points = x;
            }
        }

        System.out.println(max_points);
    }
}
