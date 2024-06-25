import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập kích thước của mảng
        System.out.print("Nhập kích thước của mảng: ");
        int n = scanner.nextInt();

        // Khởi tạo mảng
        int[] array = new int[n];

        // Nhập các phần tử của mảng
        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        // Gọi hàm tìm kiếm phần tử nhỏ nhất
        int minElement = findMinElement(array);

        // In ra phần tử nhỏ nhất
        System.out.println("Phần tử nhỏ nhất trong mảng là: " + minElement);

        // Đóng scanner
        scanner.close();
    }

    // Hàm tìm kiếm phần tử nhỏ nhất trong mảng sử dụng Queue
    public static int findMinElement(int[] array) {
        Queue<Integer> queue = new LinkedList<>();

        // B2: Duyệt qua từng phần tử trong mảng và đưa chúng vào queue
        for (int element : array) {
            queue.add(element);
        }

        // B3: Lấy phần tử đầu tiên trong queue ra khỏi queue và gán nó làm phần tử nhỏ nhất hiện tại
        int minElement = queue.poll();

        // B4: So sánh phần tử đó với các phần tử khác trong queue
        while (!queue.isEmpty()) {
            int currentElement = queue.poll();
            if (currentElement < minElement) {
                minElement = currentElement;
            }
        }

        // Phần tử nhỏ nhất đã được tìm thấy
        return minElement;
    }
}
