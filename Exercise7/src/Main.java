import java.util.Scanner;
import java.util.Stack;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập chuỗi cần kiểm tra
        System.out.print("Nhập chuỗi cần kiểm tra: ");
        String input = scanner.nextLine();

        // Gọi hàm kiểm tra chuỗi có phải là dãy giảm dần hay không
        boolean isDescending = isDescendingOrder(input);

        // In ra kết quả kiểm tra
        if (isDescending) {
            System.out.println("Chuỗi là dãy giảm dần.");
        } else {
            System.out.println("Chuỗi không phải là dãy giảm dần.");
        }

        // Đóng scanner
        scanner.close();
    }

    // Hàm kiểm tra chuỗi có phải là dãy giảm dần hay không
    public static boolean isDescendingOrder(String str) {
        // Bước 1: Khởi tạo một Stack để lưu trữ các ký tự của chuỗi đầu vào
        Stack<Character> stack = new Stack<>();

        // Bước 2: Đưa các ký tự của chuỗi vào Stack bằng cách sử dụng vòng lặp for
        for (char ch : str.toCharArray()) {
            stack.push(ch);
        }

        // Bước 3: Khởi tạo một biến flag để lưu trữ kết quả kiểm tra, ban đầu gán giá trị là true
        boolean flag = true;

        // Bước 4: Duyệt qua từng ký tự trong chuỗi đầu vào bằng vòng lặp for, và so sánh với ký tự đầu tiên trong Stack bằng phương thức peek()
        for (char ch : str.toCharArray()) {
            // Bước 5: Nếu ký tự trong chuỗi lớn hơn ký tự đầu tiên trong Stack, ta gán giá trị của flag là false và thoát khỏi vòng lặp
            if (!stack.isEmpty() && ch > stack.peek()) {
                flag = false;
                break;
            }
            // Lấy phần tử trên cùng của Stack ra
            stack.pop();
        }

        // Bước 6: Trả về giá trị của flag
        return flag;
    }
}






public static boolean isDescendingOrder(String str) {
    // Bước 1: Khởi tạo một Stack để lưu trữ các ký tự của chuỗi đầu vào
    Stack<Character> stack = new Stack<>();

    // Bước 2: Đưa các ký tự của chuỗi vào Stack bằng cách sử dụng vòng lặp for
    for (char ch : str.toCharArray()) {
        stack.push(ch);
    }

    // Bước 3: Khởi tạo một biến flag để lưu trữ kết quả kiểm tra, ban đầu gán giá trị là true
    boolean flag = true;

    // Bước 4: Sử dụng vòng lặp while để duyệt qua các ký tự trong chuỗi
    int i = 0;
    while (i < str.length()) {
        // Lấy ký tự hiện tại trong chuỗi
        char ch = str.charAt(i);

        // Bước 5: Sử dụng vòng lặp for để so sánh ký tự hiện tại với các ký tự trong Stack
        for (; i < str.length() && !stack.isEmpty(); i++) {
            // Nếu ký tự hiện tại lớn hơn ký tự trên cùng của Stack
            if (ch > stack.peek()) {
                flag = false;
                break;
            }
            // Lấy phần tử trên cùng của Stack ra
            stack.pop();
            // Lấy ký tự tiếp theo trong chuỗi
            if (i < str.length() - 1) {
                ch = str.charAt(i + 1);
            }
        }

        // Nếu flag đã được gán là false thì thoát khỏi vòng lặp while
        if (!flag) {
            break;
        }
    }

    // Bước 6: Trả về giá trị của flag
    return flag;
}
