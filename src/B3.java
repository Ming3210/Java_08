import java.util.Scanner;
import java.util.regex.Pattern;

public class B3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String email, password;
        String emailRegex = "^[A-Za-z0-9][A-Za-z0-9._-]*@[A-Za-z0-9]+(\\.[A-Za-z]{2,})+$";

        do {
            System.out.print("Nhập email: ");
            email = scanner.nextLine().trim();

            if (!Pattern.matches(emailRegex, email) || email.chars().filter(ch -> ch == '@').count() != 1) {
                System.out.println("Email không hợp lệ! Vui lòng nhập lại.");
            }
        } while (!Pattern.matches(emailRegex, email) || email.chars().filter(ch -> ch == '@').count() != 1);

        do {
            System.out.print("Nhập mật khẩu: ");
            password = scanner.nextLine();

            boolean isValid = password.length() >= 8 &&
                    password.matches(".*[A-Z].*") &&
                    password.matches(".*[a-z].*") &&
                    password.matches(".*[0-9].*") &&
                    password.matches(".*[@#$%!&*].*");

            if (!isValid) {
                System.out.println("Mật khẩu không hợp lệ! Phải có ít nhất 8 ký tự, chữ hoa, chữ thường, số và ký tự đặc biệt.");
            } else {
                System.out.println("Email và mật khẩu hợp lệ!");
                break;
            }
        } while (true);

    }
}