import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập chuỗi cần kiểm tra
        System.out.print("Nhập chuỗi cần kiểm tra: ");
        String input = scanner.nextLine();

        // Gọi hàm kiểm tra chuỗi có phải là dãy số nguyên tố hay không
        boolean isAllPrime = isAllPrimeNumbers(input);

        // In ra kết quả kiểm tra
        if (isAllPrime) {
            System.out.println("Chuỗi chứa toàn bộ số nguyên tố.");
        } else {
            System.out.println("Chuỗi không chứa toàn bộ số nguyên tố.");
        }

        // Đóng scanner
        scanner.close();
    }

    // Hàm kiểm tra chuỗi có phải là dãy số nguyên tố hay không
    public static boolean isAllPrimeNumbers(String str) {
        // Bước 1: Tạo một stack để lưu trữ các ký tự trong chuỗi đầu vào
        Stack<Character> stack = new Stack<>();

        // Bước 2: Duyệt qua từng ký tự trong chuỗi đầu vào và kiểm tra xem ký tự đó có phải là số hay không
        for (char ch : str.toCharArray()) {
            if (Character.isDigit(ch)) {
                stack.push(ch);
            }
        }

        // Bước 3: Lấy từng ký tự từ stack và chuyển đổi chúng thành số nguyên để kiểm tra xem chúng có phải là số nguyên tố hay không
        while (!stack.isEmpty()) {
            int number = Character.getNumericValue(stack.pop());
            if (!isPrime(number)) {
                return false;
            }
        }

        // Nếu tất cả các số trên stack đều là số nguyên tố, trả về true
        return true;
    }

    // Hàm kiểm tra một số có phải là số nguyên tố hay không
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
