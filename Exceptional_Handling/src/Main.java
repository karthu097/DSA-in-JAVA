public class Main {
    public static void main(String[] args) {
        int[] nums = {10, 5, 0};  // 0 will cause error

        for (int n : nums) {
            try {
                int result = 100 / n;
                System.out.println("100 / " + n + " = " + result);
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            } finally {
                System.out.println("Attempted with n = " + n);
            }
        }
    }
}
