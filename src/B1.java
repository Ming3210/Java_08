import java.util.Scanner;

public class B1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        do {
            System.out.print("Nhập kích thước mảng: ");
            while(!sc.hasNextInt()) {
                System.out.println("Kích thước không hợp lệ!");
                System.out.print("Nhập lại kích thước: ");
                sc.next();
            }
            n = sc.nextInt();
            if(n <= 0) System.out.println("Kích thước không hợp lệ!");
        } while(n <= 0);

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            System.out.print("a[" + i + "] = ");
            arr[i] = sc.nextInt();
        }

        int min = arr[0];
        int max = arr[0];
        for(int x : arr) {
            if(x < min) min = x;
            if(x > max) max = x;
        }

        System.out.println("Min = " + min);
        System.out.println("Max = " + max);
    }
}