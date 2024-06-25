import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int decimalNumber = 111;

        String binaryNumber = decimalToBinary(decimalNumber);

        System.out.println("Chuyển đổi từ Decimal (" + decimalNumber + ") sang Binary: " + binaryNumber);
    }

    public static String decimalToBinary(int decimalNumber) {
        // Khởi tạo một Stack để lưu trữ các chữ số nhị phân
        Stack<Integer> stack = new Stack<>();

        // Chuyển đổi từ dạng thập phân sang nhị phân bằng phép chia lấy dư cho 2
        while (decimalNumber != 0) {
            int remainder = decimalNumber % 2;
            stack.push(remainder);
            decimalNumber = decimalNumber / 2;
        }

        // Đọc từ Stack để lấy kết quả nhị phân
        StringBuilder binaryBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            binaryBuilder.append(stack.pop());
        }

        // Trả về kết quả nhị phân dưới dạng chuỗi
        return binaryBuilder.toString();
    }
}
