
// Refactored Ε6.java
public class E6Refactored {

    public static void main(String[] args) {
        int[] data = {10, 20, 30, 40, 50};
        int sum = calculateSum(data);
        double average = calculateAverage(data);
        printResults(sum, average);
    }

    public static int calculateSum(int[] numbers) {
        int total = 0;
        for (int num : numbers) {
            total += num;
        }
        return total;
    }

    public static double calculateAverage(int[] numbers) {
        if (numbers.length == 0) return 0;
        return (double) calculateSum(numbers) / numbers.length;
    }

    public static void printResults(int sum, double average) {
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
    }
}
