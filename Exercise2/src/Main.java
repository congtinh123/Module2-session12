import java.util.Scanner;
import java.util.Stack;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chuỗi cần kiểm tra: ");
        String input = scanner.nextLine();

        if (isBalanced(input)) {
            System.out.println("Chuỗi có cặp dấu ngoặc mở đóng đủ.");
        } else {
            System.out.println("Chuỗi không có cặp dấu ngoặc mở đóng đủ.");
        }

        // Đóng scanner
        scanner.close();
    }

    // Hàm kiểm tra chuỗi có cặp dấu ngoặc mở đóng đủ hay không
    public static boolean isBalanced(String str) {
        // B1: Tạo một Stack rỗng để lưu trữ các dấu ngoặc
        Stack<Character> stack = new Stack<>();

        // B2: Duyệt từng ký tự trong chuỗi đầu vào
        for (char ch : str.toCharArray()) {
            // B3: Nếu ký tự đang xét là một dấu ngoặc mở, đưa nó vào stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            // B4: Nếu ký tự đang xét là một dấu ngoặc đóng
            else if (ch == ')' || ch == '}' || ch == ']') {
                // Nếu stack rỗng hoặc phần tử trên cùng của stack không khớp với dấu ngoặc đóng
                if (stack.isEmpty() || !isMatchingPair(stack.pop(), ch)) {
                    return false;
                }
            }
        }

        // B5: Nếu đã duyệt hết chuỗi và Stack vẫn còn phần tử, chuỗi không đúng
        return stack.isEmpty();
    }

    // Hàm kiểm tra cặp dấu ngoặc có khớp hay không
    public static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }
}