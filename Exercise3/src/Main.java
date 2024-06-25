import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chuỗi cần kiểm tra: ");
        String input = scanner.nextLine();

        // Loại bỏ khoảng trắng và chuyển về chữ thường để kiểm tra Palindrome
        String sanitizedInput = input.replaceAll("\\s+", "").toLowerCase();

        if (isPalindrome(sanitizedInput)) {
            System.out.println("Chuỗi là Palindrome.");
        } else {
            System.out.println("Chuỗi không phải là Palindrome.");
        }

        // Đóng scanner
        scanner.close();
    }

    // Hàm kiểm tra chuỗi có phải là Palindrome hay không
    public static boolean isPalindrome(String str) {
        // Tạo Stack và Queue
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        // Duyệt từng ký tự và thêm vào Stack và Queue
        for (char ch : str.toCharArray()) {
            stack.push(ch);
            queue.add(ch);
        }

        // So sánh từng phần tử của Stack và Queue
        while (!stack.isEmpty()) {
            if (stack.pop() != queue.poll()) {
                return false;
            }
        }

        return true;
    }
}
