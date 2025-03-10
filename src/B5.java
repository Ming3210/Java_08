import java.util.Scanner;

public class B5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = null;
        int n = 0;

        while (true) {
            System.out.println("************************ MENU *************************");
            System.out.println("1. Nhập giá trị n phần tử của mảng");
            System.out.println("2. In giá trị các phần tử trong mảng");
            System.out.println("3. Tính trung bình các phần tử dương (>0) trong mảng");
            System.out.println("4. In ra chỉ số các phần tử có giá trị bằng k trong mảng (k nhập từ bàn phím)");
            System.out.println("5. Tính số lượng các phần tử là số nguyên tố trong mảng");
            System.out.println("6. Thoát chương trình");

            System.out.print("Chọn chức năng (1-6): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Nhập số phần tử của mảng (n): ");
                    n = scanner.nextInt();
                    arr = new int[n];
                    for (int i = 0; i < n; i++) {
                        System.out.print("Nhập phần tử thứ " + (i + 1) + ": ");
                        arr[i] = scanner.nextInt();
                    }
                    break;

                case 2:
                    if (arr == null) {
                        System.out.println("Vui lòng nhập mảng trước!");
                    } else {
                        System.out.println("Các phần tử trong mảng:");
                        for (int i = 0; i < arr.length; i++) {
                            System.out.print(arr[i] + " ");
                        }
                        System.out.println();
                    }
                    break;

                case 3:
                    if (arr == null) {
                        System.out.println("Vui lòng nhập mảng trước!");
                    } else {
                        double sum = 0;
                        int count = 0;
                        for (int i = 0; i < arr.length; i++) {
                            if (arr[i] > 0) {
                                sum += arr[i];
                                count++;
                            }
                        }
                        if (count > 0) {
                            System.out.println("Trung bình các số dương: " + (sum / count));
                        } else {
                            System.out.println("Không có số dương trong mảng!");
                        }
                    }
                    break;

                case 4:
                    if (arr == null) {
                        System.out.println("Vui lòng nhập mảng trước!");
                    } else {
                        System.out.print("Nhập giá trị k cần tìm: ");
                        int k = scanner.nextInt();
                        boolean found = false;
                        System.out.println("Vị trí các phần tử có giá trị " + k + ":");
                        for (int i = 0; i < arr.length; i++) {
                            if (arr[i] == k) {
                                System.out.print(i + " ");
                                found = true;
                            }
                        }
                        if (!found) {
                            System.out.println("Không tìm thấy giá trị " + k + " trong mảng!");
                        }
                        System.out.println();
                    }
                    break;

                case 5:
                    if (arr == null) {
                        System.out.println("Vui lòng nhập mảng trước!");
                    } else {
                        int primeCount = 0;
                        for (int i = 0; i < arr.length; i++) {
                            boolean isPrime = true;
                            if (arr[i] <= 1) {
                                isPrime = false;
                            } else {
                                for (int j = 2; j <= Math.sqrt(arr[i]); j++) {
                                    if (arr[i] % j == 0) {
                                        isPrime = false;
                                        break;
                                    }
                                }
                            }
                            if (isPrime) {
                                primeCount++;
                            }
                        }
                        System.out.println("Số lượng số nguyên tố trong mảng: " + primeCount);
                    }
                    break;

                case 6:
                    System.exit(0);
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }

            scanner.nextLine();
            if (choice != 1) scanner.nextLine();
        }
    }
}