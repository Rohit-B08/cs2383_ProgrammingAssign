public class Even {
    public static boolean isEven(double value) {
        boolean result;
        double startTime = System.currentTimeMillis();
        result = (value % 2 == 0);
        double endTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (endTime - startTime));
        return result;
    }

    public static void main(String[] args) {
        System.out.println(isEven(9899001));
    }
}
