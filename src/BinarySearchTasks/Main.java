package BinarySearchTasks;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int res = sqrt(n);

        System.out.println("Nearest sqrt of " + n + " is: " + res);

        int num = sc.nextInt();
        int h = sc.nextInt();
        int w = sc.nextInt();

        int res1 = binarySearchAnswer(h, w, num);
        System.out.println("Minimal value of square side is: " + res1);

        int papers = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();

        int res2 = easyTask(x, y, papers);
        System.out.println("The minimal time for copying " + papers + " papers is: " + res2);
    }

    public static int sqrt(int x) {
        int left = 0;
        int right = x;


        // Если граница right будет равна left, а значение квадрата будет меньше искомого,
        // то правая граница уйдёт влево, создавая условие left > right
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (mid * mid > x){
                right = mid - 1;
                continue;
            }

            if (mid * mid < x){
                left = mid + 1;
                continue;
            }

            return mid;
        }

        return right;
    }

    public static int binarySearchAnswer(int h, int w, int n){
        /*
        Мы смотри значения, которые может принимать сторона квадрата
        Левая граница - максимум из высоты и ширины диплома
        Правая граница - левая граница на кол-во дипломов, как будто мы разместили
        все дипломы в одну линию
         */
        int left = Integer.max(h, w);
        int right = left * n;

        /*
        Используется шаблон алгоритма left/right binary search
        Здесь на =ши задача применить бинарный поиск для стороны квадрата
        При этом мы выполняем проверку по ответу, сравнивая кол-во столбцов и строк с
        кол-во дипломов
         */
        while (left + 1 < right){
            int mid = (left + right) / 2;
            int res = (mid / h) * (mid / w);
            if (res > n) {
                right = mid;
            } else {
                left = mid;
            }
        }

        return right;
    }

    public static int easyTask(int x, int y, int n) {
        /*
        Левая граница - ничего не надо печатать
        Правая граница - все бумаги печатает самый долгий принтер
        В данной задача используется n - 1 бумаг, так как в начале нам нужно скопировать
        хотя бы одну на самом быстром ксероксе
         */
        int left = 0;
        int right = Integer.max(x, y) * (n - 1);

        while (left + 1 < right){
            int mid = (left + right) / 2;

            /*
            В этом условии мы проверяем хватит нам времени mid для печати работ
            mid/x - количество бумаг, которые можно напечатать на принтере со скоростью x за время mid.
            С y аналогичная ситуация
             */
            if (mid/x + mid/y < n - 1){
                left = mid;
            } else {
                right = mid;
            }
        }
        /*
        В конце нужно добавить время печати той самой первой бумаги
         */
        return right + Integer.min(x,y);
    }
}
