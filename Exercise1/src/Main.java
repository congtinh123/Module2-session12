import java.util.Scanner;
import java.util.Stack;
public class Main {
    public static void main(String[] args) {
        // B1: Tạo 1 Stack để lưu trữ văn bản
        Stack<String> stack = new Stack<>();

        // B2: Nhập số lượng từ cần nhập từ bàn phím
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng từ cần nhập: ");
        int numOfWords = scanner.nextInt();
        scanner.nextLine();  // Để đọc dòng mới sau khi nhập số

        // B3: Tạo 1 vòng lặp for với số lần lặp bằng số lượng từ vừa nhập mỗi vòng lặp cho nhập 1 từ. rồi push vào stack.
        for (int i = 0; i < numOfWords; i++) {
            System.out.print("Nhập từ: ");
            String word = scanner.nextLine();
            stack.push(word);
        }

        // B4: Tạo vòng lặp rồi in các từ trong stack ra bằng phương thức pop()
        System.out.println("Các từ theo thứ tự đảo ngược là:");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        // Đóng scanner
        scanner.close();
    }
}