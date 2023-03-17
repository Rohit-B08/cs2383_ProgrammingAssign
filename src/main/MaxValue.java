public class MaxValue {

    public static double MaxVal(double[] values) {
        double startTime = System.currentTimeMillis();
        double maxValue = Integer.MIN_VALUE;
        for (double value : values) {
            if (maxValue < value) {
                maxValue = value;
            }
        }
        double endTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (endTime - startTime));
        return maxValue;
    }

    public static void main(String[] args) {
       int size = 5000000;
       double[] values = new double[size+1];
        for (int i = 0; i <= size; i++) {
           values[i] = i;
       }
        System.out.println(MaxVal(values));
    }
}
