import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập biểu thức cần kiểm tra: ");
        String expression = scanner.nextLine();

        if (isWellFormed(expression)) {
            System.out.println("Biểu thức sử dụng đúng dấu ngoặc.");
        } else {
            System.out.println("Biểu thức sử dụng sai dấu ngoặc.");
        }

        // Đóng scanner
        scanner.close();
    }

    // Hàm kiểm tra biểu thức có sử dụng đúng dấu ngoặc hay không
    public static boolean isWellFormed(String expr) {
        Stack<Character> bStack = new Stack<>();

        // Duyệt từng ký tự trong biểu thức
        for (char sym : expr.toCharArray()) {
            // Nếu là dấu ngoặc trái, đưa vào Stack
            if (sym == '(' || sym == '{' || sym == '[') {
                bStack.push(sym);
            }
            // Nếu là dấu ngoặc phải
            else if (sym == ')' || sym == '}' || sym == ']') {
                // Nếu Stack rỗng, biểu thức sai
                if (bStack.isEmpty()) {
                    return false;
                }

                // Lấy dấu ngoặc ở Stack
                char left = bStack.pop();

                // Kiểm tra xem dấu ngoặc có khớp hay không
                if (!isMatchingPair(left, sym)) {
                    return false;
                }
            }
        }

        // Nếu Stack rỗng, biểu thức đúng; ngược lại, sai
        return bStack.isEmpty();
    }

    // Hàm kiểm tra cặp dấu ngoặc có khớp hay không
    public static boolean isMatchingPair(char left, char right) {
        return (left == '(' && right == ')') ||
                (left == '{' && right == '}') ||
                (left == '[' && right == ']');
    }
}
