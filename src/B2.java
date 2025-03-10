import java.util.Scanner;

public class B2 {
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
        int sum = 0;

        for(int i = 0; i < n; i++) {
            System.out.print("a[" + i + "] = ");
            arr[i] = sc.nextInt();
            if(arr[i] % 3 == 0) {
                sum += arr[i];
            }
        }

        if(sum != 0) {
            System.out.println("Tổng các số chia hết cho 3: " + sum);
        } else {
            System.out.println("Không có số chia hết cho 3");
        }
    }
}