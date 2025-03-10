import java.util.Scanner;

public class B6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = "";
        int[] arr = null;

        while (true) {
            System.out.println("===== MENU CHÍNH =====");
            System.out.println("1. Xử lý chuỗi");
            System.out.println("2. Xử lý số nguyên");
            System.out.println("3. Thoát chương trình");
            System.out.print("Chọn chức năng (1-3): ");

            int mainChoice = scanner.nextInt();
            scanner.nextLine();

            switch (mainChoice) {
                case 1:
                    while (true) {
                        System.out.println("\n===== MENU XỬ LÝ CHUỖI =====");
                        System.out.println("1. Nhập chuỗi");
                        System.out.println("2. Loại bỏ khoảng trắng thừa trong chuỗi");
                        System.out.println("3. Đếm số lần xuất hiện của từng ký tự");
                        System.out.println("4. Chuyển đổi chuỗi thành dạng chuẩn (viết hoa chữ cái đầu mỗi từ)");
                        System.out.println("5. Quay lại menu chính");
                        System.out.print("Chọn chức năng (1-5): ");

                        int strChoice = scanner.nextInt();
                        scanner.nextLine();

                        if (strChoice == 5) break;

                        switch (strChoice) {
                            case 1:
                                System.out.print("Nhập chuỗi: ");
                                str = scanner.nextLine();
                                break;

                            case 2:
                                if (str.isEmpty()) {
                                    System.out.println("Vui lòng nhập chuỗi trước!");
                                } else {
                                    str = str.trim().replaceAll("\\s+", " ");
                                    System.out.println("Chuỗi sau khi xử lý: " + str);
                                }
                                break;

                            case 3:
                                if (str.isEmpty()) {
                                    System.out.println("Vui lòng nhập chuỗi trước!");
                                } else {
                                    int[] count = new int[256];
                                    for (char c : str.toCharArray()) {
                                        count[c]++;
                                    }
                                    for (int i = 0; i < 256; i++) {
                                        if (count[i] > 0) {
                                            System.out.println("'" + (char)i + "' xuất hiện " + count[i] + " lần");
                                        }
                                    }
                                }
                                break;

                            case 4:
                                if (str.isEmpty()) {
                                    System.out.println("Vui lòng nhập chuỗi trước!");
                                } else {
                                    String[] words = str.toLowerCase().split("\\s+");
                                    StringBuilder result = new StringBuilder();
                                    for (String word : words) {
                                        if (word.length() > 0) {
                                            result.append(Character.toUpperCase(word.charAt(0)))
                                                    .append(word.substring(1)).append(" ");
                                        }
                                    }
                                    str = result.toString().trim();
                                    System.out.println("Chuỗi sau khi chuẩn hóa: " + str);
                                }
                                break;

                            default:
                                System.out.println("Lựa chọn không hợp lệ!");
                        }
                    }
                    break;

                case 2:
                    while (true) {
                        System.out.println("\n===== MENU XỬ LÝ MẢNG SỐ NGUYÊN =====");
                        System.out.println("1. Nhập mảng số nguyên");
                        System.out.println("2. Tìm số nguyên tố lớn nhất trong mảng");
                        System.out.println("3. Đếm số phần tử có chữ số đầu tiên là số lẻ");
                        System.out.println("4. Kiểm tra mảng có phải là mảng đối xứng không");
                        System.out.println("5. Quay lại menu chính");
                        System.out.print("Chọn chức năng (1-5): ");

                        int numChoice = scanner.nextInt();

                        if (numChoice == 5) break;

                        switch (numChoice) {
                            case 1:
                                System.out.print("Nhập số phần tử của mảng: ");
                                int n = scanner.nextInt();
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
                                    int maxPrime = -1;
                                    for (int num : arr) {
                                        boolean isPrime = true;
                                        if (num > 1) {
                                            for (int i = 2; i <= Math.sqrt(num); i++) {
                                                if (num % i == 0) {
                                                    isPrime = false;
                                                    break;
                                                }
                                            }
                                            if (isPrime && num > maxPrime) {
                                                maxPrime = num;
                                            }
                                        }
                                    }
                                    if (maxPrime == -1) {
                                        System.out.println("Không có số nguyên tố trong mảng");
                                    } else {
                                        System.out.println("Số nguyên tố lớn nhất: " + maxPrime);
                                    }
                                }
                                break;

                            case 3:
                                if (arr == null) {
                                    System.out.println("Vui lòng nhập mảng trước!");
                                } else {
                                    int count = 0;
                                    for (int num : arr) {
                                        int firstDigit = Math.abs(num);
                                        while (firstDigit >= 10) {
                                            firstDigit /= 10;
                                        }
                                        if (firstDigit % 2 != 0) {
                                            count++;
                                        }
                                    }
                                    System.out.println("Số phần tử có chữ số đầu tiên là số lẻ: " + count);
                                }
                                break;

                            case 4:
                                if (arr == null) {
                                    System.out.println("Vui lòng nhập mảng trước!");
                                } else {
                                    boolean isSymmetric = true;
                                    for (int i = 0; i < arr.length/2; i++) {
                                        if (arr[i] != arr[arr.length-1-i]) {
                                            isSymmetric = false;
                                            break;
                                        }
                                    }
                                    System.out.println("Mảng " + (isSymmetric ? "là" : "không phải là") + " mảng đối xứng");
                                }
                                break;

                            default:
                                System.out.println("Lựa chọn không hợp lệ!");
                        }
                    }
                    break;

                case 3:
                    System.exit(0);
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}